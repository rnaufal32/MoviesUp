package std.aanrstudio.apps.moviesup.ui.activity.detail

import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.mock.MoviesMock
import std.aanrstudio.apps.moviesup.mock.TvMock
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class DetailViewModel : ViewModel() {

    var position: Int = 0

    fun getMovies() : Movie {
        return MoviesMock.getData(position)
    }

    fun getTv() : Tv {
        return TvMock.getData(position)
    }

}