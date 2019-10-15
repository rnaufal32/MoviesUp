package std.aanrstudio.apps.moviesup.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvViewModel

class TvViewModelTest {

    lateinit var tvViewModel: TvViewModel

    @Before
    fun before() {
        tvViewModel = TvViewModel()
    }

    @Test
    fun getTvs() {
        val list: ArrayList<Tv> = tvViewModel.getTvs()
        assertNotNull(list)
        assertEquals(10, list.size)
    }
}