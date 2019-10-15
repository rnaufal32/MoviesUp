package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.MovieRepository

class MovieViewModel(repository: MovieRepository) : ViewModel() {
    val movieList = repository.getMovie()
}