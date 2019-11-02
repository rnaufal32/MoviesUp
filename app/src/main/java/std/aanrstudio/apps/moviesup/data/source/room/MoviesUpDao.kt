package std.aanrstudio.apps.moviesup.data.source.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.*
import std.aanrstudio.apps.moviesup.data.source.model.Movie

@Dao
interface MoviesUpDao {

    @WorkerThread
    @Query("SELECT * FROM fav_movie")
    fun getFavMovies() : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavMovies(movie: Movie)

    @Delete
    fun deleteFavMovies(movie: Movie)
}