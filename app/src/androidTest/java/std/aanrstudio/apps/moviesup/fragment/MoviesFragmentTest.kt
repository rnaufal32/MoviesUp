package std.aanrstudio.apps.moviesup.fragment

import androidx.recyclerview.widget.RecyclerView
import org.junit.Before
import org.junit.Rule
import std.aanrstudio.apps.moviesup.testing.SingleFragmentActivity
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.RecyclerViewItemCountAssertion
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MoviesFragment


class MoviesFragmentTest {
    @Rule @JvmField
    var activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private var moviesFragment = MoviesFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
    }

    @Test
    fun loadMovies() {
        val recyclerViewItemCountAssertion = RecyclerViewItemCountAssertion()
        recyclerViewItemCountAssertion.expectedCount = 10

        onView(withId(R.id.list_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.list_movie)).check(recyclerViewItemCountAssertion)

        onView(withId(R.id.list_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }
}