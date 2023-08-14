package kirishhaa.viewwave.main_screen.presentation.allmovie

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.main_screen.presentation.recyclerview.AllMovieAdapter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class AllMovieViewModel @AssistedInject constructor(
    @Assisted private val genreId: Int,
    private val loadMoviesUseCase: LoadMoviesUseCase,
    private val movieDetailClickedUseCase: MovieDetailClickedUseCase,
) : StateViewModel<AllMovieViewModel.State>(), AllMovieAdapter.Listener {

    private var currentState = State()

    private val loadAllMoviesFlow: MutableStateFlow<Finish<List<MovieListItem>>> =
        MutableStateFlow(PendingFinish())
    private val movieDetailClickedFlow: MutableStateFlow<Finish<Unit>> =
        MutableStateFlow(PendingFinish())


    override val state = combine(loadAllMoviesFlow) {
        val movieList = it[0]
        if (movieList is SuccessFinish) {
            currentState = currentState.copy(
                isErrorLoadedAllMovie = false,
                isLoadingAllMovies = false,
                isLoadedAllMovie = true
            )
        }
        if (movieList is ErrorFinish) {
            currentState = currentState.copy(
                isErrorLoadedAllMovie = true,
                isLoadingAllMovies = false,
                isLoadedAllMovie = false
            )
        }
        if (movieList is PendingFinish) {
            currentState = currentState.copy(
                isErrorLoadedAllMovie = false,
                isLoadingAllMovies = true,
                isLoadedAllMovie = false
            )
        }
        return@combine currentState
    }

    init {
        loadMovies()
    }

    data class State(
        val isLoadingAllMovies: Boolean = true,
        val isLoadedAllMovie: Boolean = false,
        val isErrorLoadedAllMovie: Boolean = false,
        val movieListItem: List<MovieListItem> = emptyList(),
        val page: Int = 1,
    )

    @AssistedFactory
    interface Factory {
        fun create(genre: Int): AllMovieViewModel
    }

    override fun onMoviePressed(id: Int) {
        handleFinishFlow(movieDetailClickedFlow) {
            return@handleFinishFlow movieDetailClickedUseCase.onMovieDetailClicked(id)
        }.setUpdatable(true)
    }

    override fun loadMovies() {
        handleFinishFlow(loadAllMoviesFlow) {
            return@handleFinishFlow loadMoviesUseCase.loadMovies(genreId, currentState.page)
        }.onSuccess { list ->
            currentState = currentState.copy(
                movieListItem = (currentState.movieListItem + list).distinct(),
                page = currentState.page + 1
            )
        }
    }
}