package kirishhaa.viewwave.main_screen.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.main_screen.presentation.recyclerview.movie.MovieAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val onMovieDetailClickedUseCase: MovieDetailClickedUseCase,
    private val loadMoviesUseCase: LoadMoviesUseCase,
) : BaseViewModel(), MovieAdapter.Listener {

    private val loadMoviesFlow: MutableStateFlow<Finish<Collection<MovieListItem>>> =
        MutableStateFlow(PendingFinish())
    private val movieItemClickedFlow: MutableStateFlow<Finish<Unit>> =
        MutableStateFlow(SuccessFinish(Unit))

    private var currentState = State()

    init {
        loadMoviesImpl()
    }

    val state = combine(loadMoviesFlow, movieItemClickedFlow) { loadMovies, movieItemClicked ->
        when (loadMovies) {
            is SuccessFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovies = true,
                    isErrorLoadMovies = false,
                    isLoadingMovies = false
                )
            }
            is ErrorFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovies = false,
                    isErrorLoadMovies = true,
                    isLoadingMovies = false
                )
            }
            is PendingFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovies = false,
                    isErrorLoadMovies = false,
                    isLoadingMovies = true
                )
            }
        }
        when (movieItemClicked) {
            is SuccessFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovieItemClick = true,
                    isErrorLoadMovieItemClick = false,
                    isLoadingMovieItemClick = false
                )
            }
            is ErrorFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovieItemClick = false,
                    isErrorLoadMovieItemClick = true,
                    isLoadingMovieItemClick = false
                )
            }
            is PendingFinish -> {
                currentState = currentState.copy(
                    isSuccessLoadMovieItemClick = false,
                    isErrorLoadMovieItemClick = false,
                    isLoadingMovieItemClick = true
                )
            }
        }
        return@combine currentState
    }

    override fun onMovieListItemClicked(item: MovieListItem) {
        handleFinishFlow(movieItemClickedFlow) {
            return@handleFinishFlow onMovieDetailClickedUseCase.onMovieDetailClicked(item.id)
        }.setUpdatable(true)
    }

    override fun loadMovies() = loadMoviesImpl()

    private fun loadMoviesImpl() {
        handleFinishFlow(loadMoviesFlow) {
            val movieSearchQuery = MovieSearchQuery(
                includeAdult = null,
                includeVideo = null,
                language = null,
                page = currentState.page,
                sortBy = null
            )
            return@handleFinishFlow loadMoviesUseCase.loadMovies(movieSearchQuery)
        }.onSuccess { movieItemCollection ->
            val oldPage = currentState.page
            val newPage = oldPage + 1

            val oldList = currentState.movieList
            val newList = (oldList + movieItemCollection).distinct()

            currentState = currentState.copy(
                movieList = newList,
                page = newPage
            )
        }
    }

    data class State(
        val isLoadingMovies: Boolean = false,
        val isSuccessLoadMovies: Boolean = false,
        val isErrorLoadMovies: Boolean = false,
        val isLoadingMovieItemClick: Boolean = false,
        val isSuccessLoadMovieItemClick: Boolean = false,
        val isErrorLoadMovieItemClick: Boolean = false,
        val page: Int = 1,
        val movieList: List<MovieListItem> = emptyList(),
    )
}