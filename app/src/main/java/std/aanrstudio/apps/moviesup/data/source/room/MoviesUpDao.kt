package std.aanrstudio.apps.moviesup.data.source.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv

@Dao
interface MoviesUpDao {

    @Query("SELECT * FROM fav_movie")
    fun getFavMovie() : DataSource.Factory<Int, Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavMovies(movie: Movie)

    @Delete
    fun deleteFavMovies(movie: Movie)

    @Query("SELECT * FROM fav_tv")
    fun getFavTv() : DataSource.Factory<Int, Tv>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavTv(tv: Tv)

    @Delete
    fun deleteFavTv(tv: Tv)

}