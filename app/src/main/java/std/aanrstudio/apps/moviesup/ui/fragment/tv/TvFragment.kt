package std.aanrstudio.apps.moviesup.ui.fragment.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Tv

class TvFragment : Fragment() {

    private var list: ArrayList<Tv> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvList: RecyclerView = view.findViewById(R.id.list_tv)
        tvList.setHasFixedSize(true)
        tvList.layoutManager = LinearLayoutManager(view.context)

        val tvViewModel = ViewModelProviders.of(this).get(TvViewModel::class.java)
        list = tvViewModel.getTvs()

        val adapter = TvAdapter(list)
        tvList.adapter = adapter
    }

}
