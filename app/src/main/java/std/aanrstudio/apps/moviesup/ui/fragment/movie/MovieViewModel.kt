package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.model.Movie

class MovieViewModel(repository: MovieRepository) : ViewModel() {

    val movieRepository: MovieRepository = repository

    fun movieList(): LiveData<ArrayList<Movie>> {
        return movieRepository.getMovie()
    }

}