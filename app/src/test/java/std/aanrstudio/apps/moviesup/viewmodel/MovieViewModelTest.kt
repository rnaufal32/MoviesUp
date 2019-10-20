package std.aanrstudio.apps.moviesup.viewmodel

import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MovieViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Rule
import org.mockito.Mockito.*


@RunWith(JUnit4::class)
class MovieViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var movieViewModel: MovieViewModel
    private var repository = mock(MovieRepository::class.java)

    @Before
    fun before() {
        movieViewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummy:MutableLiveData<ArrayList<Movie>> = MutableLiveData()

        `when`(repository.getMovie()).thenReturn(dummy)
        verify(repository).getMovie()
    }
}