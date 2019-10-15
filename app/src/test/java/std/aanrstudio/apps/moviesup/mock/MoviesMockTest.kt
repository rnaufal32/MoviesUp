package std.aanrstudio.apps.moviesup.mock

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesMockTest {

    lateinit var mockMovie: MoviesMock

    @Before
    fun before() {
        mockMovie = MoviesMock
    }

    @Test
    fun getMockData() {
        assertEquals(10, mockMovie.mockData.size)
    }

    @Test
    fun getData() {
        assertNotNull(mockMovie.getData(0))
    }
}