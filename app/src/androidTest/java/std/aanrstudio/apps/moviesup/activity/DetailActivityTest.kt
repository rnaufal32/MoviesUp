package std.aanrstudio.apps.moviesup.activity

import androidx.test.rule.ActivityTestRule

import org.junit.Rule
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailActivity
import std.aanrstudio.apps.moviesup.utils.EspressoIdlingResource


class DetailActivityTest {

    @Rule @JvmField
    var activityRule: ActivityTestRule<DetailActivity> =
        object : ActivityTestRule<DetailActivity>(
            DetailActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailActivity::class.java)
                result.putExtra(DetailActivity.EXTRA_ID, "475557")
                result.putExtra(DetailActivity.EXTRA_INTENT, "Movie")
                return result
            }
        }

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadDetail() {
        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))
        onView((withId(R.id.detail_title))).check(matches(withText("Joker")))
    }
}