package std.aanrstudio.apps.moviesup.ui.fragment.favorite.tv

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
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.ui.activity.detail.DetailActivity

class FavTvAdapter :
    PagedListAdapter<Tv, FavTvAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Tv>(){
            override fun areContentsTheSame(oldItem: Tv, newItem: Tv): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Tv, newItem: Tv): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = getItem(position)
        holder.txt_title.text = tv?.title
        holder.txt_overview.text = tv?.overview

        Glide.with(holder.itemView)
            .load(tv?.poster)
            .into(holder.poster)


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_INTENT, "Tv")
            intent.putExtra(DetailActivity.EXTRA_ID, tv?.id)
            it.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster: ImageView = itemView.findViewById(R.id.poster)
        var txt_title: TextView = itemView.findViewById(R.id.txt_title)
        var txt_overview: TextView = itemView.findViewById(R.id.txt_overview)
    }

}