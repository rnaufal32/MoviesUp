package std.aanrstudio.apps.moviesup.data.source

import androidx.lifecycle.LiveData
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository
import std.aanrstudio.apps.moviesup.data.source.room.LocalRepository

class DetailRepository(
    val remoteRepository: RemoteRepository,
    val localRepository: LocalRepository
) {

    fun getDetailMovie(id: Int?) : LiveData<Movie> {
        remoteRepository.detailMovie(id)
        return remoteRepository.movie
    }

    fun getDetailTv(id: Int?) : LiveData<Tv> {
        remoteRepository.detailTv(id)
        return remoteRepository.detailTv
    }

    fun addFilmFavorite(movie: Movie) {
        localRepository.addFilmFavorite(movie)
    }

    fun delMovies(movie: Movie) {
        localRepository.delFilmFavorite(movie)
    }

    fun addTvFavorite(tv: Tv) {
        localRepository.addTvFavorite(tv)
    }

    fun delTv(tv: Tv) {
        localRepository.delTvFavorite(tv)
    }

}