package kirishhaa.viewwavemovie_details_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.createViewModel
import kirishhaa.viewwave.core.observe
import kirishhaa.viewwavemovie_details_screen.R
import kirishhaa.viewwavemovie_details_screen.databinding.FragmentMovieDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding: FragmentMovieDetailBinding get() = _binding!!

    @Inject
    lateinit var factory: MovieDetailViewModel.Factory

    private val viewModel by createViewModel { factory.create(arguments!!.getInt(ARG_MOVIE_ID)) }

    companion object {
        const val TAG = "MovieDetailFragment"

        private const val ARG_MOVIE_ID = "ARG_MOVIE_ID"

        fun newInstance(id: Int): MovieDetailFragment {
            val movieDetailFragment = MovieDetailFragment()
            movieDetailFragment.arguments = bundleOf(ARG_MOVIE_ID to id)
            return movieDetailFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailBinding.bind(view)
        observe(viewModel.state) { state ->
            when {
                state.isLoadingDetails -> binding.progressBar.isVisible = true
                state.isLoadedDetails -> {
                    val currentDetail = state.movieDetail!!
                    with(binding) {
                        progressBar.isVisible = false

                        Glide.with(requireContext())
                            .load(currentDetail.backdropPath)
                            .into(imageBackdropDetail)

                        textTitleDetail.text = currentDetail.title
                        textDescriptionDetail.text = currentDetail.overview
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}