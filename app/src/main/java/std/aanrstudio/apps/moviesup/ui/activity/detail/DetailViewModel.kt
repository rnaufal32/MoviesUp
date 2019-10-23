package std.aanrstudio.apps.moviesup.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.DetailRepository
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class DetailViewModel(var repository: DetailRepository) : ViewModel() {

    var id: String? = ""

    fun getMovies() : LiveData<Movie> {
        return repository.getDetailMovie(id)
    }

    fun getTv() : LiveData<Tv> {
        return repository.getDetailTv(id)
    }

}