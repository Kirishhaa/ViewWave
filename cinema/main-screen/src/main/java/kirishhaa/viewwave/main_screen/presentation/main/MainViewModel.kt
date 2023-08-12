package kirishhaa.viewwave.main_screen.presentation.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.core.GenreProvider.ACTION_ID
import kirishhaa.viewwave.core.GenreProvider.ADVENTURE_ID
import kirishhaa.viewwave.core.GenreProvider.DRAMA_ID
import kirishhaa.viewwave.core.GenreProvider.FANTASY_ID
import kirishhaa.viewwave.core.GenreProvider.HORROR_ID
import kirishhaa.viewwave.core.GenreProvider.THRILLER_ID
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.main_screen.domain.OnMorePressedUseCase
import kirishhaa.viewwave.main_screen.presentation.recyclerview.OuterMovieAdapter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieDetailClickedUseCase: MovieDetailClickedUseCase,
    private val loadMoviesUseCase: LoadMoviesUseCase,
    private val onMorePressedUseCase: OnMorePressedUseCase
) : StateViewModel<MainViewModel.State>(), OuterMovieAdapter.OuterMovieAdapterListener {

    private val actionMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())
    private val adventureMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())
    private val dramaMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())
    private val fantasyMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())
    private val horrorMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())
    private val thrillerMoviesFlow: MutableStateFlow<List<MovieListItem>> =
        MutableStateFlow(emptyList())

    private val movieClickedFlow: MutableStateFlow<Finish<Unit>> =
        MutableStateFlow(PendingFinish())

    private val onMorePressedFlow: MutableStateFlow<Finish<Unit>> =
        MutableStateFlow(PendingFinish())

    private var currentState = State()

    init {
        loadMovieByGenreId(ACTION_ID, actionMoviesFlow)
        loadMovieByGenreId(ADVENTURE_ID, adventureMoviesFlow)
        loadMovieByGenreId(DRAMA_ID, dramaMoviesFlow)
        loadMovieByGenreId(FANTASY_ID, fantasyMoviesFlow)
        loadMovieByGenreId(HORROR_ID, horrorMoviesFlow)
        loadMovieByGenreId(THRILLER_ID, thrillerMoviesFlow)
    }

    override val state = combine(
        actionMoviesFlow,
        adventureMoviesFlow,
        dramaMoviesFlow,
        fantasyMoviesFlow,
        horrorMoviesFlow,
        thrillerMoviesFlow
    ) {
        val actionMovies = it[0]
        val adventureMovies = it[1]
        val dramaMovies = it[2]
        val fantasyMovies = it[3]
        val horrorMovies = it[4]
        val thrillerMovies = it[5]
        val newState = State(
            actionMovies,
            adventureMovies,
            dramaMovies,
            fantasyMovies,
            horrorMovies,
            thrillerMovies
        )
        currentState = newState
        return@combine currentState
    }

    private fun loadMovieByGenreId(
        genreId: Int,
        flow: MutableStateFlow<List<MovieListItem>>,
    ) {
        viewModelScope.launch {
            flow.value = loadMoviesUseCase.loadMovies(genreId, 1)
        }
    }

    class State(
        private val actionMovies: List<MovieListItem> = emptyList(),
        private val adventureMovies: List<MovieListItem> = emptyList(),
        private val dramaMovies: List<MovieListItem> = emptyList(),
        private val fantasyMovies: List<MovieListItem> = emptyList(),
        private val horrorMovies: List<MovieListItem> = emptyList(),
        private val thrillerMovies: List<MovieListItem> = emptyList(),
    ) {
        fun getRecycleData(): List<OuterMovieAdapter.Data> {
            val mutableList = mutableListOf<OuterMovieAdapter.Data>()
            if (actionMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = ACTION_ID,
                        category = GenreProvider.provideGenreById(ACTION_ID),
                        movieList = actionMovies
                    )
                )
            }
            if (adventureMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = ADVENTURE_ID,
                        category = GenreProvider.provideGenreById(ADVENTURE_ID),
                        movieList = adventureMovies
                    )
                )
            }
            if (dramaMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = DRAMA_ID,
                        category = GenreProvider.provideGenreById(DRAMA_ID),
                        movieList = dramaMovies
                    )
                )
            }
            if (fantasyMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = FANTASY_ID,
                        category = GenreProvider.provideGenreById(FANTASY_ID),
                        movieList = fantasyMovies
                    )
                )
            }
            if (horrorMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = HORROR_ID,
                        category = GenreProvider.provideGenreById(HORROR_ID),
                        movieList = horrorMovies
                    )
                )
            }
            if (thrillerMovies.isNotEmpty()) {
                mutableList.add(
                    OuterMovieAdapter.Data(
                        categoryId = THRILLER_ID,
                        category = GenreProvider.provideGenreById(THRILLER_ID),
                        movieList = thrillerMovies
                    )
                )
            }
            return mutableList
        }
    }

    override fun onMorePressed(genreId: Int) {
        handleFinishFlow(onMorePressedFlow) {
            return@handleFinishFlow onMorePressedUseCase.onMorePressed(genreId)
        }
    }

    override fun onMoviePressed(id: Int) {
        handleFinishFlow(movieClickedFlow) {
            movieDetailClickedUseCase.onMovieDetailClicked(id)
        }.setUpdatable(true)
    }


}