package std.aanrstudio.apps.moviesup.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import java.util.ArrayList

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.di.Injection

class DetailActivity : AppCompatActivity() {
    lateinit var poster: ImageView
    lateinit var title: TextView
    lateinit var age: TextView
    lateinit var category: TextView
    lateinit var duration: TextView
    lateinit var overview: TextView
    lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        poster = findViewById(R.id.detail_poster)
        title = findViewById(R.id.detail_title)
        age = findViewById(R.id.detail_age)
        category = findViewById(R.id.detail_category)
        duration = findViewById(R.id.detail_duration)
        overview = findViewById(R.id.detail_overview)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val id = intent.extras?.getString(EXTRA_ID)
        val extraIntent = intent.extras?.getString(EXTRA_INTENT)

        detailViewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory())
            .get(DetailViewModel::class.java)
        detailViewModel.ID = id

        if (extraIntent == "Movie") {
            getMovie()
        } else if (extraIntent == "Tv") {
            getTv(detailViewModel.getTv())
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getTv(tv: Tv) {
        title.text = tv.title
        age.text = tv.age
        category.text = tv.genre
        duration.text = tv.duration
        overview.text = tv.overview
        poster.setImageResource(tv.poster)
    }

    private fun getMovie() {
        detailViewModel.getMovies().observe(this, Observer {
            title.text = it.title
            age.text = it.duration
            category.text = it.release_date
            overview.text = it.overview

            Glide.with(this)
                .load(it.poster)
                .into(poster)
        })
    }

    companion object {
        val EXTRA_ID = "extra_id"
        val EXTRA_INTENT = "extra_intent"
    }
}
