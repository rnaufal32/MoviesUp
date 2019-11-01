package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository

class FavMovieViewModel(repository: LocalRepository) : ViewModel() {

    val repo: LocalRepository = repository

    fun getFavMovies() : LiveData<ArrayList<Movie>> {
        return repo.getFavMovies()
    }

}
