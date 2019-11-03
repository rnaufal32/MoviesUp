package std.aanrstudio.apps.moviesup.ui.fragment.favorite.tv

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import junit.framework.AssertionFailedError
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.testing.SingleFragmentActivity
import std.aanrstudio.apps.moviesup.utils.EspressoIdlingResource

class FavTvFragmentTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private var favTvFragment = FavTvFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
        activityRule.activity.setFragment(favTvFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        try {
            onView(withId(R.id.empty_fav_tv)).check(matches(isDisplayed()))
        } catch (e: AssertionFailedError) {
            onView(withId(R.id.fav_tv_list)).check(matches(isDisplayed()))
            onView(withId(R.id.fav_tv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }
    }
}