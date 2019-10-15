package std.aanrstudio.apps.moviesup.mock

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvMockTest {

    lateinit var tvMock: TvMock

    @Before
    fun before() {
        tvMock = TvMock
    }

    @Test
    fun getMockData() {
        assertEquals(10, tvMock.mockData.size)
    }

    @Test
    fun getData() {
        assertNotNull(tvMock.getData(0))
    }
}