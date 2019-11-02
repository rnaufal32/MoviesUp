package std.aanrstudio.apps.moviesup.ui.fragment.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailActivity
import std.aanrstudio.apps.moviesup.data.source.model.Movie

class MoviesAdapter(private var listMovie: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.txtTitle.text = movie.title
        holder.txtOverview.text = movie.overview

        Glide.with(holder.itemView)
            .load(movie.poster)
            .into(holder.poster)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_INTENT, "Movie")
            intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
            it.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView = itemView.findViewById(R.id.poster)
        var txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        var txtOverview: TextView = itemView.findViewById(R.id.txt_overview)
    }

}