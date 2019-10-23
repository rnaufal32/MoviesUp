package std.aanrstudio.apps.moviesup.data.source

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository

class DetailRepository(val remoteRepository: RemoteRepository) {

    fun getDetailMovie(id: String?) : LiveData<Movie> {
        remoteRepository.detailMovie(id)
        return remoteRepository.movie
    }

    fun getDetailTv(id: String?) : LiveData<Tv> {
        remoteRepository.detailTv(id)
        return remoteRepository.detailTv
    }

}