package std.aanrstudio.apps.moviesup.ui.fragment.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailActivity

class FavMovieAdapter :
    PagedListAdapter<Movie, FavMovieAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Movie>(){
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.txtTitle.text = movie?.title
        holder.txtOverview.text = movie?.overview

        Glide.with(holder.itemView)
            .load(movie?.poster)
            .into(holder.poster)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_INTENT, "Movie")
            intent.putExtra(DetailActivity.EXTRA_ID, movie?.id)
            it.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView = itemView.findViewById(R.id.poster)
        var txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        var txtOverview: TextView = itemView.findViewById(R.id.txt_overview)
    }

}