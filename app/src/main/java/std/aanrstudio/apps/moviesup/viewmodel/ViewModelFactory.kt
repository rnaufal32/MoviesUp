package std.aanrstudio.apps.moviesup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailViewModel
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MovieViewModel
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MovieViewModel::class.java) ->
                    MovieViewModel(repository)
                isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(repository)
                isAssignableFrom(TvViewModel::class.java) ->
                    TvViewModel(repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}