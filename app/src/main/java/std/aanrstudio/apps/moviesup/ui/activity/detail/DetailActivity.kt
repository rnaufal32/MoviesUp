package std.aanrstudio.apps.moviesup.ui.activity.detail

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
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
    lateinit var btnFav: Button

    lateinit var pref: SharedPreferences

    private var movie: Movie = Movie()

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
        btnFav = findViewById(R.id.fav_btn)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val id = intent.extras?.getInt(EXTRA_ID)
        val extraIntent = intent.extras?.getString(EXTRA_INTENT)

        pref = getSharedPreferences(id.toString(), Context.MODE_PRIVATE)

        detailViewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(applicationContext))
            .get(DetailViewModel::class.java)
        detailViewModel.id = id

        if (extraIntent == "Movie") {
            getMovie()
        } else if (extraIntent == "Tv") {
            getTv()
        }

        changeButton(id)

        btnFav.setOnClickListener {
            if (pref.getBoolean(id.toString(), false)) {
                val editor = pref.edit()
                editor.putBoolean(id.toString(), false)
                editor.apply()
                detailViewModel.delFilmFavorite(movie)
                Toast.makeText(this, "Dihapus dari Favorit", Toast.LENGTH_LONG).show()
            } else {
                val editor = pref.edit()
                editor.putBoolean(id.toString(), true)
                editor.apply()
                detailViewModel.addFilmFavorite(movie)
                Toast.makeText(this, "Ditambahkan ke Favorit", Toast.LENGTH_LONG).show()
            }
            changeButton(id)
        }

    }

    fun changeButton(id: Int?) {
        if (pref.getBoolean(id.toString(), false)) {
            val icon = baseContext.resources.getDrawable(R.drawable.ic_star_black_24dp)
            btnFav.text = "Hapus Favorit"
            btnFav.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
        } else {
            val icon = baseContext.resources.getDrawable(R.drawable.ic_star_border_white_24dp)
            btnFav.text = baseContext.resources.getString(R.string.tambah_favorit)
            btnFav.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
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

            movie = it
        })
    }

    companion object {
        val EXTRA_ID = "extra_id"
        val EXTRA_INTENT = "extra_intent"
    }
}
