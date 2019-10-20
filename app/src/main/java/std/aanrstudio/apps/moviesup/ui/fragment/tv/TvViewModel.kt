package std.aanrstudio.apps.moviesup.ui.fragment.tv

import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.data.source.MovieRepository

class TvViewModel(repository: MovieRepository) : ViewModel() {
    val tvList = repository.getTvShow()
}