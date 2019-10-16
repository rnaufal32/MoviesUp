package std.aanrstudio.apps.moviesup.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.json.JSONObject
import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.utils.FanCallback

class RemoteRepository {

    val liveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovies() {
        val list: ArrayList<Movie> = arrayListOf()

        Api.popular("movie", object : FanCallback {
            override fun response(objects: JSONObject) {
                val jsonArray = objects.getJSONArray("results")
                val length: Int = jsonArray.length()
                for (i in 0 until length) {
                    val obj = jsonArray.getJSONObject(i)
                    val title = obj.getString("title")
                    val overview = obj.getString("overview")
                    val poster:String = obj.getString("poster_path")
                    val id = obj.getString("id")
                    val movie = Movie(
                        id,
                        title,
                        overview,
                        poster = "https://image.tmdb.org/t/p/w500/$poster"
                    )
                    list.add(movie)
                }
                liveData.postValue(list)
            }
        })
    }

    fun detailMovie(id: String?) {

        Api.detail("movie", id, object : FanCallback {
            override fun response(objects: JSONObject) {
                val title = objects.getString("title")
                val overview = objects.getString("overview")
                val poster:String = objects.getString("poster_path")
                val releaseDate = objects.getString("release_date")
                val duration = objects.getString("runtime")
                val id = objects.getString("id")
                val res = Movie(
                    id,
                    title,
                    overview,
                    releaseDate,
                    "$duration minute",
                    "https://image.tmdb.org/t/p/w500/$poster"
                )
                movie.postValue(res)
            }
        })
    }

}