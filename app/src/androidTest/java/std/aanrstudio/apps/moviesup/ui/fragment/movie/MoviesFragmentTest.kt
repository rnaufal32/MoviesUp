package std.aanrstudio.apps.moviesup.ui.fragment.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import std.aanrstudio.apps.moviesup.testing.SingleFragmentActivity
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.RecyclerViewItemCountAssertion
import std.aanrstudio.apps.moviesup.utils.EspressoIdlingResource

class MoviesFragmentTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private var moviesFragment = MoviesFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
        activityRule.activity.setFragment(moviesFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        val recyclerViewItemCountAssertion = RecyclerViewItemCountAssertion()
        recyclerViewItemCountAssertion.expectedCount = 20
        onView(withId(R.id.list_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.list_movie)).check(recyclerViewItemCountAssertion)
    }
}