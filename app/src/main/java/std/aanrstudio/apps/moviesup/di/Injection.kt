package std.aanrstudio.apps.moviesup.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import std.aanrstudio.apps.moviesup.data.source.DetailRepository
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.TvRepository
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository
import std.aanrstudio.apps.moviesup.data.source.room.MoviesUpDatabase
import std.aanrstudio.apps.moviesup.viewmodel.ViewModelFactory

object Injection {

    fun provideApi(): RemoteRepository {
        return RemoteRepository()
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(MovieRepository(provideApi()), TvRepository(provideApi()), DetailRepository(
            provideApi()), provideRoom(context))
    }

    fun provideRoom(context: Context): LocalRepository {
        val db: MoviesUpDatabase = MoviesUpDatabase.getInstance(context)
        return LocalRepository(db.moviesUpDao())
    }
}