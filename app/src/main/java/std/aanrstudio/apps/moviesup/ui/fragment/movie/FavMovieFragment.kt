package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.di.Injection

class FavMovieFragment : Fragment() {

    private lateinit var viewModel: FavMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext())).get(FavMovieViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
