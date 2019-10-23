package std.aanrstudio.apps.moviesup.ui.fragment.tv

import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.TvRepository

class TvViewModel(repository: TvRepository) : ViewModel() {
    val tvList = repository.getTvShow()
}