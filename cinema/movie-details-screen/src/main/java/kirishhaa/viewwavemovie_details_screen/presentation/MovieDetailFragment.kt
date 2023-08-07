package kirishhaa.viewwavemovie_details_screen.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kirishhaa.viewwave.core.logD

class MovieDetailFragment: Fragment() {

    companion object{
        private const val ARG_MOVIE_ID = "ARG_MOVIE_ID"

        fun newInstance(id: Int): MovieDetailFragment {
            val movieDetailFragment = MovieDetailFragment()
            movieDetailFragment.arguments = bundleOf(ARG_MOVIE_ID to id)
            return movieDetailFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD("MOVIE ID = ${arguments?.getInt(ARG_MOVIE_ID)}")
    }

}