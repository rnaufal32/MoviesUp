package std.aanrstudio.apps.moviesup.ui.fragment.favorite.tv

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.di.Injection
import std.aanrstudio.apps.moviesup.viewmodel.ViewModelFactory

class FavTvFragment : Fragment() {

    private lateinit var viewModel: FavTvViewModel
    lateinit var recyclerView: RecyclerView

    private val adapter: FavTvAdapter by lazy {
        FavTvAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_tv_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fav_tv_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext())).get(FavTvViewModel::class.java)
        viewModel.getPaged().observe(this, Observer {
            adapter.submitList(it)
            recyclerView.adapter = adapter
        })
    }
}
