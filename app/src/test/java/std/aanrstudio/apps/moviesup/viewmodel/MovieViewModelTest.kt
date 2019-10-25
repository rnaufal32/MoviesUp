package std.aanrstudio.apps.moviesup.viewmodel

import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MovieViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import std.aanrstudio.apps.moviesup.data.source.mock.MovieMockData
import std.aanrstudio.apps.moviesup.data.source.remote.RemoteRepository


@RunWith(JUnit4::class)
class MovieViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var movieViewModel: MovieViewModel? = null
    private var repository = mock(MovieRepository::class.java)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val list = MovieMockData.mockData
        val dummy: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
        dummy.value = list

        `when`(repository.getMovie()).thenReturn(dummy)

        val observer = mock(Observer::class.java)

        movieViewModel?.movieList?.observeForever(observer as Observer<in ArrayList<Movie>>)

        verify(observer)
    }
}