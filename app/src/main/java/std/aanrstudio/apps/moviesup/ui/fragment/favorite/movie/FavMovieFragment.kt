package std.aanrstudio.apps.moviesup.ui.fragment.favorite.movie

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
    lateinit var emptyView: View

    private val adapter: FavMovieAdapter by lazy {
        FavMovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_movie_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieList = view.findViewById(R.id.fav_movie_list)
        emptyView = view.findViewById(R.id.empty_fav_movie)

        movieList.setHasFixedSize(true)
        movieList.layoutManager = LinearLayoutManager(view.context)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext())).get(
            FavMovieViewModel::class.java)
        viewModel.getPaged().observe(this, Observer {
            adapter.submitList(it)
            movieList.adapter = adapter
            if (it.size > 0) {
                emptyView.visibility = View.GONE
                movieList.visibility = View.VISIBLE
            } else {
                emptyView.visibility = View.VISIBLE
                movieList.visibility = View.INVISIBLE
            }
        })
    }
}
