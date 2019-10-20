package std.aanrstudio.apps.moviesup.data.source

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository

class MovieRepository(val remoteRepository: RemoteRepository) {

    fun getMovie(): LiveData<ArrayList<Movie>> {
        remoteRepository.getMovies()
        return remoteRepository.liveData
    }

    fun getDetailMovie(id: String?) : LiveData<Movie> {
        remoteRepository.detailMovie(id)
        return remoteRepository.movie
    }

    fun getTvShow(): LiveData<ArrayList<Tv>> {
        remoteRepository.getTvShow()
        return remoteRepository.liveDataTv
    }

    fun getDetailTv(id: String?) : LiveData<Tv> {
        remoteRepository.detailTv(id)
        return remoteRepository.detailTv
    }

}