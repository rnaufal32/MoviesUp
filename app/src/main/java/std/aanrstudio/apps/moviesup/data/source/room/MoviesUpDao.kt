package std.aanrstudio.apps.moviesup.data.source.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import std.aanrstudio.apps.moviesup.data.source.model.Movie

@Dao
interface MoviesUpDao {

    @WorkerThread
    @Query("SELECT * FROM fav_movie")
    fun getFavMovies() : LiveData<List<Movie>>

    @Insert
    fun insertFavMovies(movie: Movie)
}