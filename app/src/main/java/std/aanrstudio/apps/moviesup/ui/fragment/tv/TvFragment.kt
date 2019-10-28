package std.aanrstudio.apps.moviesup.ui.fragment.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.di.Injection

class TvFragment : Fragment() {

    lateinit var tvViewModel: TvViewModel
    lateinit var tvList: RecyclerView
    lateinit var loading: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loading = view.findViewById(R.id.loading_tv)
        tvList = view.findViewById(R.id.list_tv)
        tvList.setHasFixedSize(true)
        tvList.layoutManager = LinearLayoutManager(view.context)

        tvViewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory()).get(TvViewModel::class.java)
        tvViewModel.tvList().observe(this, Observer {
            loading.visibility = View.GONE
            tvList.visibility = View.VISIBLE
            val adapter = TvAdapter(it)
            tvList.adapter = adapter
        })
    }

}
