package std.aanrstudio.apps.moviesup.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import std.aanrstudio.apps.moviesup.data.source.MovieRepository
import std.aanrstudio.apps.moviesup.data.source.TvRepository
import std.aanrstudio.apps.moviesup.data.source.mock.TvMockData
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvViewModel

class TvViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var tvViewModel: TvViewModel? = null
    private var repository = mock(TvRepository::class.java)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        tvViewModel = TvViewModel(repository)
    }

    @Test
    fun getTvs() {
        val list = TvMockData.mockData
        val dummy: MutableLiveData<ArrayList<Tv>> = MutableLiveData()
        dummy.value = list

        `when`(repository.getTvShow()).thenReturn(dummy)

        val observer = mock(Observer::class.java)

        tvViewModel?.tvList?.observeForever(observer as Observer<in ArrayList<Tv>>)
        verify(observer)
    }
}