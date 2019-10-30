package std.aanrstudio.apps.moviesup.data.source.room

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie

class LocalRepository(val moviesUpDao: MoviesUpDao) {

    lateinit var INSTANCE: LocalRepository

    fun getInstance(moviesUpDao: MoviesUpDao): LocalRepository {
        if (INSTANCE == null) {
            INSTANCE = LocalRepository(moviesUpDao)
        }
        return INSTANCE
    }

    fun getFavMovies() : LiveData<ArrayList<Movie>> {
        return moviesUpDao.getFavMovies()
    }

}