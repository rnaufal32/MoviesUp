package std.aanrstudio.apps.moviesup.data.source.remote

import androidx.lifecycle.MutableLiveData
import org.json.JSONObject
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.utils.FanCallback

class RemoteRepository {

    val liveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun getMovies() {
        val list: ArrayList<Movie> = arrayListOf()

        Api.tes("movie", object : FanCallback {
            override fun response(objects: JSONObject) {
                val jsonArray = objects.getJSONArray("results")
                val length: Int = jsonArray.length()
                for (i in 0 until length) {
                    val obj = jsonArray.getJSONObject(i)
                    val title = obj.getString("title")
                    val overview = obj.getString("overview")
                    val movie = Movie(
                        title,
                        overview,
                        "",
                        "",
                        "",
                        R.drawable.movie_poster_alita
                    )
                    list.add(movie)
                }
                liveData.postValue(list)
            }
        })
    }

}