package std.aanrstudio.apps.moviesup.utils

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.ui.fragment.movie.MoviesFragment
import std.aanrstudio.apps.moviesup.ui.fragment.tv.TvFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a MoviesFragment (defined as a static inner class below).
        when (position) {
            0 -> return MoviesFragment()
            1 -> return TvFragment()
            else -> return MoviesFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}