package std.aanrstudio.apps.moviesup.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MovieViewModel

class MovieViewModelTest {

    lateinit var movieViewModel: MovieViewModel

    @Before
    fun before() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val list: ArrayList<Movie> = movieViewModel.getMovies()
        assertNotNull(list)
        assertEquals(10, list.size)
    }
}