package kirishhaa.viewwavemovie_details_screen.presentation

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kirishhaa.viewwave.core.*
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail
import kirishhaa.viewwavemovie_details_screen.domain.InitializeDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class MovieDetailViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
    private val initializeDataUseCase: InitializeDataUseCase,
) : StateViewModel<MovieDetailViewModel.State>() {

    @AssistedFactory
    interface Factory {
        fun create(id: Int): MovieDetailViewModel
    }

    private var currentState = State()

    private val movieDetailFlow: MutableStateFlow<Finish<MovieDetail>> =
        MutableStateFlow(PendingFinish())
    override val state = combine(movieDetailFlow) {
        val finishMovieDetail = it[0]
        val newState = State(finishMovieDetail)
        this.currentState = newState
        return@combine newState
    }

    init {
        handleFinishFlow(movieDetailFlow) {
            initializeDataUseCase.initializeData(id)
        }
    }

    class State(
        val isLoadingDetails: Boolean = true,
        val isLoadedDetails: Boolean = false,
        val isLoadError: Boolean = false,
        val movieDetail: MovieDetail? = null,
    ) {

        constructor(movieDetail: Finish<MovieDetail>) : this(
            isLoadingDetails = movieDetail is PendingFinish,
            isLoadedDetails = movieDetail is SuccessFinish,
            isLoadError = movieDetail is ErrorFinish,
            movieDetail = (movieDetail as? SuccessFinish)?.data
        )

    }
}