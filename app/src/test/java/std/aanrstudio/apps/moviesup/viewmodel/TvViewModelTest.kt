package std.aanrstudio.apps.moviesup.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.*
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvViewModel

class TvViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var tvViewModel: TvViewModel
    private var repository = mock(MovieRepository::class.java)

    @Before
    fun before() {
        tvViewModel = TvViewModel(repository)
    }

    @Test
    fun getTvs() {
        val dummy: MutableLiveData<ArrayList<Tv>> = MutableLiveData()

        `when`(repository.getTvShow()).thenReturn(dummy)
        verify(repository).getTvShow()
    }
}