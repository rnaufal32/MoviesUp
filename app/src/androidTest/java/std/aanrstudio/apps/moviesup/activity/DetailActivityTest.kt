package std.aanrstudio.apps.moviesup.activity

import androidx.test.rule.ActivityTestRule
import std.aanrstudio.apps.moviesup.mock.FakeMoviesMock

import org.junit.Rule
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailActivity


class DetailActivityTest {

    private val movie = FakeMoviesMock.getData(0)

    @Rule @JvmField
    var activityRule: ActivityTestRule<DetailActivity> =
        object : ActivityTestRule<DetailActivity>(
            DetailActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
                val result = Intent(targetContext, DetailActivity::class.java)
                result.putExtra(DetailActivity.EXTRA_ID, 0)
                result.putExtra(DetailActivity.EXTRA_INTENT, "Movie")
                return result
            }
        }

    @Test
    fun loadDetail() {
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))
        onView((withId(R.id.detail_title))).check(matches(withText(movie.title)))
    }
}