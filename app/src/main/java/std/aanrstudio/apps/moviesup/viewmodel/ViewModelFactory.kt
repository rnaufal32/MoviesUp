package std.aanrstudio.apps.moviesup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import std.aanrstudio.apps.moviesup.data.source.DetailRepository
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.TvRepository
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailViewModel
import std.aanrstudio.apps.moviesup.ui.fragment.movie.FavMovieViewModel
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MovieViewModel
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val movie: MovieRepository,
    private val tv: TvRepository,
    private val detail: DetailRepository,
    private val favorite: LocalRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MovieViewModel::class.java) ->
                    MovieViewModel(movie)
                isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(detail)
                isAssignableFrom(TvViewModel::class.java) ->
                    TvViewModel(tv)
                isAssignableFrom(FavMovieViewModel::class.java) ->
                    FavMovieViewModel(favorite)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}