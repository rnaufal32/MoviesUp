package std.aanrstudio.apps.moviesup.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.mock.TvMock
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class DetailViewModel(var repository: MovieRepository) : ViewModel() {

    var position: Int = 0
    var ID: String? = ""

    fun getMovies() : LiveData<Movie> {
        return repository.getDetailMovie(ID)
    }

    fun getTv() : Tv {
        return TvMock.getData(position)
    }

}