package std.aanrstudio.apps.moviesup.data.source

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository

class MovieRepository(val remoteRepository: RemoteRepository) {

    fun getMovie(): LiveData<ArrayList<Movie>> {
        remoteRepository.getMovies()
        return remoteRepository.liveData
    }

}