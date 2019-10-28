package std.aanrstudio.apps.moviesup.ui.fragment.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.TvRepository
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class TvViewModel(repository: TvRepository) : ViewModel() {
    val tvRepository: TvRepository = repository

    fun tvList(): LiveData<ArrayList<Tv>> {
        return tvRepository.getTvShow()
    }
}