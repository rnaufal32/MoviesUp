package std.aanrstudio.apps.moviesup.data.source.remote

import androidx.lifecycle.MutableLiveData
import org.json.JSONObject
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.data.source.model.Tv
import std.aanrstudio.apps.moviesup.utils.EspressoIdlingResource
import std.aanrstudio.apps.moviesup.utils.FanCallback

class RemoteRepository {

    val liveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val movie: MutableLiveData<Movie> = MutableLiveData()

    val liveDataTv: MutableLiveData<ArrayList<Tv>> = MutableLiveData()
    val detailTv: MutableLiveData<Tv> = MutableLiveData()

    fun getTvShow() {
        val list: ArrayList<Tv> = arrayListOf()
        EspressoIdlingResource.increment()

        Api.popular("tv", object : FanCallback {
            override fun response(objects: JSONObject) {
                val jsonArray = objects.getJSONArray("results")
                val length: Int = jsonArray.length()
                for (i in 0 until length) {
                    val obj = jsonArray.getJSONObject(i)
                    val title = obj.getString("name")
                    val overview = obj.getString("overview")
                    val poster:String = obj.getString("poster_path")
                    val id = obj.getString("id")
                    val tv = Tv(
                        id,
                        title,
                        overview,
                        poster = "https://image.tmdb.org/t/p/w500/$poster"
                    )
                    list.add(tv)
                }
                liveDataTv.postValue(list)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getMovies() {
        val list: ArrayList<Movie> = arrayListOf()
        EspressoIdlingResource.increment()

        Api.popular("movie", object : FanCallback {
            override fun response(objects: JSONObject) {
                val jsonArray = objects.getJSONArray("results")
                val length: Int = jsonArray.length()
                for (i in 0 until length) {
                    val obj = jsonArray.getJSONObject(i)
                    val title = obj.getString("title")
                    val overview = obj.getString("overview")
                    val poster:String = obj.getString("poster_path")
                    val id = obj.getInt("id")
                    val movie = Movie(
                        id,
                        title,
                        overview,
                        poster = "https://image.tmdb.org/t/p/w500/$poster"
                    )
                    list.add(movie)
                }
                liveData.postValue(list)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun detailMovie(id: Int?) {
        EspressoIdlingResource.increment()

        Api.detail("movie", id, object : FanCallback {
            override fun response(objects: JSONObject) {
                val title = objects.getString("title")
                val overview = objects.getString("overview")
                val poster:String = objects.getString("poster_path")
                val releaseDate = objects.getString("release_date")
                val duration = objects.getString("runtime")
                val id = objects.getInt("id")
                val res = Movie(
                    id,
                    title,
                    overview,
                    releaseDate,
                    "$duration minute",
                    "https://image.tmdb.org/t/p/w500/$poster"
                )
                movie.postValue(res)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun detailTv(id: Int?) {
        EspressoIdlingResource.increment()

        Api.detail("tv", id, object : FanCallback {
            override fun response(objects: JSONObject) {
                val title = objects.getString("name")
                val overview = objects.getString("overview")
                val poster:String = objects.getString("poster_path")
                val releaseDate = objects.getString("first_air_date")
                val episodeRunTime = objects.getJSONArray("episode_run_time")
                val duration = episodeRunTime.getString(0)
                val id = objects.getString("id")
                val res = Tv(
                    id,
                    title,
                    overview,
                    releaseDate,
                    "$duration minute",
                    "https://image.tmdb.org/t/p/w500/$poster"
                )
                detailTv.postValue(res)
                EspressoIdlingResource.decrement()
            }
        })
    }

}