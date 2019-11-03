package std.aanrstudio.apps.moviesup.data.source.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv


@Database(entities = [Movie::class, Tv::class], version = 1)
abstract class MoviesUpDatabase : RoomDatabase() {

    abstract val moviesUpDao : MoviesUpDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesUpDatabase? = null

        fun getInstance(context: Context): MoviesUpDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesUpDatabase::class.java,
                    "moviesUpDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}