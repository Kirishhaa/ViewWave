package kirishhaa.viewwave.main_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.hideAllViews
import kirishhaa.viewwave.core.logD
import kirishhaa.viewwave.core.observe
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.databinding.FragmentMainBinding
import kirishhaa.viewwave.main_screen.presentation.recyclerview.movie.MovieAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    @Inject lateinit var movieAdapterFactory: MovieAdapter.Factory

    private lateinit var binding: FragmentMainBinding

    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val adapter = movieAdapterFactory.create(viewModel)
        binding.recycleView.adapter = adapter
        binding.recycleView.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)

        observe(viewModel.state) { state ->
            when {
                state.isSuccessLoadMovies -> {
                    binding.recycleView.isVisible = true
                    binding.progressBar.isVisible = false
                    val loadedMovies = state.movieList
                    adapter.setItems(loadedMovies)
                }
                state.isLoadingMovies -> { binding.progressBar.isVisible = true }
            }
        }

    }

}