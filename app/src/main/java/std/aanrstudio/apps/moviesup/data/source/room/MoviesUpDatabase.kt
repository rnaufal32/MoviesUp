package std.aanrstudio.apps.moviesup.data.source.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import std.aanrstudio.apps.moviesup.data.source.model.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesUpDatabase : RoomDatabase() {

    abstract fun moviesUpDao() : MoviesUpDao

    companion object {

        lateinit var INSTANCE: MoviesUpDatabase

        private val sLock = Any()

        fun getInstance(context: Context): MoviesUpDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MoviesUpDatabase::class.java, "Moviesup.db"
                    )
                    .build()
                }
                return INSTANCE
            }
        }
    }

}