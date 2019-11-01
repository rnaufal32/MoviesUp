package std.aanrstudio.apps.moviesup.ui.fragment.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.di.Injection
import java.util.ArrayList

/**
 * A placeholder fragment containing a simple view.
 */
class MoviesFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    lateinit var movielist: RecyclerView
    lateinit var adapter: MoviesAdapter
    lateinit var loading: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movielist = view.findViewById(R.id.list_movie)
        loading = view.findViewById(R.id.loading_movie)

        movielist.setHasFixedSize(true)
        movielist.layoutManager = LinearLayoutManager(view.context)

        movieViewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext())).get(
            MovieViewModel::class.java)
        movieViewModel.movieList().observe(this, Observer {
            adapter = MoviesAdapter(it)
            loading.visibility = View.GONE
            movielist.visibility = View.VISIBLE
            movielist.adapter = adapter
        })
    }
}