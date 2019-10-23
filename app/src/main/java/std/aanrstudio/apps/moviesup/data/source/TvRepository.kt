package std.aanrstudio.apps.moviesup.data.source

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository

class TvRepository(val remoteRepository: RemoteRepository) {

    fun getTvShow(): LiveData<ArrayList<Tv>> {
        remoteRepository.getTvShow()
        return remoteRepository.liveDataTv
    }

}