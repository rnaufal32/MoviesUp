package std.aanrstudio.apps.moviesup.data.source.room

import androidx.paging.DataSource
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import java.util.concurrent.Executor

class LocalRepository(
    val moviesUpDao: MoviesUpDao,
    val ioExecutor: Executor
) {

    fun getFavMovie() : DataSource.Factory<Int, Movie> {
        return moviesUpDao.getFavMovie()
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

    fun getFavTv() : DataSource.Factory<Int, Tv> {
        return moviesUpDao.getFavTv()
    }

    fun addTvFavorite(tv: Tv) {
        ioExecutor.execute {
            moviesUpDao.insertFavTv(tv)
        }
    }

    fun delTvFavorite(tv: Tv) {
        ioExecutor.execute {
            moviesUpDao.deleteFavTv(tv)
        }
    }

}