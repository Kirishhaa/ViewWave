package kirishhaa.viewwave.main_screen.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import kirishhaa.viewwave.main_screen.domain.MovieItemClickedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val onMovieItemClickedUseCase: MovieItemClickedUseCase,
    private val loadMoviesUseCase: LoadMoviesUseCase
): ViewModel() {

    private val _loadMoviesFlow: MutableStateFlow<Finish<List<MovieListItem>>> = MutableStateFlow(EmptyFinish())
    private val _movieItemClickedFlow: MutableStateFlow<Finish<Unit>> = MutableStateFlow(EmptyFinish())

    fun onMovieListItemClicked(item: MovieListItem) {
        handleSingleFinishEvent(_movieItemClickedFlow) {
            onMovieItemClickedUseCase.onMovieItemClicked(item)
        }
    }

    fun loadMovies(page: Int) {
        handleSingleFinishEvent(_loadMoviesFlow) {
            loadMoviesUseCase.loadMovies(page)
        }
    }

}