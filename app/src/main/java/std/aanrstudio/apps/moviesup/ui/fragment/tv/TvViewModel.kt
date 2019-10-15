package std.aanrstudio.apps.moviesup.ui.fragment.tv

import androidx.lifecycle.ViewModel
import std.aanrstudio.apps.moviesup.mock.TvMock
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class TvViewModel : ViewModel() {

    fun getTvs() : ArrayList<Tv> {
        return TvMock.mockData
    }

}