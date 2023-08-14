package kirishhaa.viewwave.main_screen.presentation.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.logD
import kirishhaa.viewwave.core.observe
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.databinding.FragmentMainBinding
import kirishhaa.viewwave.main_screen.presentation.recyclerview.OuterMovieAdapter

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        const val TAG = "MainFragment"
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private val viewModel by viewModels<MainViewModel>()

    private var _adapter: OuterMovieAdapter? = null
    private val adapter get() = _adapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD("tag = $tag")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        _adapter = OuterMovieAdapter(viewModel)
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = adapter

        observe(viewModel.state) { state ->
            val recycleData = state.getRecycleData()
            if (recycleData.isEmpty()) {
                binding.progressBar.isVisible = true
            } else {
                binding.progressBar.isVisible = false
                adapter.setItems(recycleData)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _adapter = null
    }

}