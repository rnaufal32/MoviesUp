package std.aanrstudio.apps.moviesup.data.source.room

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie

class LocalRepository(val moviesUpDao: MoviesUpDao) {

    fun getFavMovies() : LiveData<List<Movie>> {
        return moviesUpDao.getFavMovies()
    }

}