package std.aanrstudio.apps.moviesup.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.di.Injection

class DetailActivity : AppCompatActivity() {
    lateinit var poster: ImageView
    lateinit var title: TextView
    lateinit var category: TextView
    lateinit var duration: TextView
    lateinit var overview: TextView
    lateinit var detailViewModel: DetailViewModel
    lateinit var loading: ProgressBar
    lateinit var content: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        poster = findViewById(R.id.detail_poster)
        title = findViewById(R.id.detail_title)
        category = findViewById(R.id.detail_category)
        duration = findViewById(R.id.detail_duration)
        overview = findViewById(R.id.detail_overview)
        loading = findViewById(R.id.loading_detail)
        content = findViewById(R.id.content_details)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val id = intent.extras?.getString(EXTRA_ID)
        val extraIntent = intent.extras?.getString(EXTRA_INTENT)

        detailViewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(applicationContext))
            .get(DetailViewModel::class.java)
        detailViewModel.id = id

        if (extraIntent == "Movie") {
            getMovie()
        } else if (extraIntent == "Tv") {
            getTv()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getTv() {
        detailViewModel.getTv().observe(this, Observer {
            content.visibility = View.VISIBLE
            loading.visibility = View.GONE
            title.text = it.title
            duration.text = it.duration
            category.text = it.release_date
            overview.text = it.overview

            Glide.with(this)
                .load(it.poster)
                .into(poster)

        })
    }

    private fun getMovie() {
        detailViewModel.getMovies().observe(this, Observer {
            content.visibility = View.VISIBLE
            loading.visibility = View.GONE
            title.text = it.title
            duration.text = it.duration
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
