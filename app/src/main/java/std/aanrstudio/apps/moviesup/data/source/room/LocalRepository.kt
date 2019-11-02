package std.aanrstudio.apps.moviesup.data.source.room

import android.util.Log
import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import java.util.concurrent.Executor

class LocalRepository(
    val moviesUpDao: MoviesUpDao,
    val ioExecutor: Executor
) {

    fun getFavMovies() : LiveData<List<Movie>> {
        return moviesUpDao.getFavMovies()
    }

    fun addFilmFavorite(movie: Movie) {
        ioExecutor.execute {
            moviesUpDao.insertFavMovies(movie)
        }
    }

    fun delFilmFavorite(movie: Movie) {
        ioExecutor.execute {
            moviesUpDao.deleteFavMovies(movie)
        }
    }

}