package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.di.Injection

class FavMovieFragment : Fragment() {

    private lateinit var viewModel: FavMovieViewModel
    lateinit var movieList: RecyclerView
    lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_movie_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieList = view.findViewById(R.id.fav_movie_list)

        movieList.setHasFixedSize(true)
        movieList.layoutManager = LinearLayoutManager(view.context)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext())).get(FavMovieViewModel::class.java)
        viewModel.getFavMovies().observe(this, Observer {
            adapter = MoviesAdapter(it)
            movieList.adapter = adapter
        })
    }
}
