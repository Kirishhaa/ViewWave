package kirishhaa.viewwave.main_screen.presentation.allmovie

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.createViewModel
import kirishhaa.viewwave.core.observe
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.databinding.FragmentAllMovieBinding
import kirishhaa.viewwave.main_screen.presentation.recyclerview.AllMovieAdapter
import javax.inject.Inject

@AndroidEntryPoint
class AllMovieFragment : Fragment(R.layout.fragment_all_movie) {

    companion object {
        fun newInstance(genreId: Int): AllMovieFragment {
            val fr = AllMovieFragment()
            fr.arguments = bundleOf(ARG_GENRE to genreId)
            return fr
        }

        private const val ARG_GENRE = "ARG_GENRE"

        const val TAG = "AllMovieFragment"
    }

    @Inject
    lateinit var factory: AllMovieViewModel.Factory

    private val viewModel by createViewModel { factory.create(arguments!!.getInt(ARG_GENRE)) }

    private var _binding: FragmentAllMovieBinding? = null
    private val binding: FragmentAllMovieBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AllMovieAdapter(viewModel)
        _binding = FragmentAllMovieBinding.bind(view)
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerView.adapter = adapter
        observe(viewModel.state) { state ->
            when {
                state.isLoadingAllMovies -> {
                    binding.progressBar.isVisible = true
                }
                state.isLoadedAllMovie -> {
                    adapter.setItems(state.movieListItem)
                    binding.progressBar.isVisible = false
                    binding.recyclerView.isVisible = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}