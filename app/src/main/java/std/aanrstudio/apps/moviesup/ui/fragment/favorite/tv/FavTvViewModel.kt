package std.aanrstudio.apps.moviesup.ui.fragment.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository

class FavTvViewModel(repository: LocalRepository) : ViewModel() {
    val repo: LocalRepository = repository

    fun getPaged() : LiveData<PagedList<Tv>> {
        return LivePagedListBuilder(repo.getFavTv(), 20).build()
    }
}
