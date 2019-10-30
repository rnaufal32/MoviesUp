package std.aanrstudio.apps.moviesup.ui.fragment.tv

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import std.aanrstudio.apps.moviesup.R

class FavTvFragment : Fragment() {

    companion object {
        fun newInstance() = FavTvFragment()
    }

    private lateinit var viewModel: FavTvViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_tv_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavTvViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
