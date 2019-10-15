package std.aanrstudio.apps.moviesup.di

import androidx.lifecycle.ViewModelProvider
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.viewmodel.ViewModelFactory

object Injection {

    fun provideApi(): RemoteRepository {
        return RemoteRepository()
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory(MovieRepository(provideApi()))
    }
}