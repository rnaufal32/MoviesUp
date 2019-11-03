package std.aanrstudio.apps.moviesup.ui.fragment.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository

class FavMovieViewModel(repository: LocalRepository) : ViewModel() {

    val repo: LocalRepository = repository

    fun getPaged() : LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(repo.getFavMovie(), 20).build()
    }

}
