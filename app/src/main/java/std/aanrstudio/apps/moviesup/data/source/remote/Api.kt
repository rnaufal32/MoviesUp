package std.aanrstudio.apps.moviesup.data.source.remote

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import std.aanrstudio.apps.moviesup.BuildConfig
import std.aanrstudio.apps.moviesup.data.source.model.Movie
import std.aanrstudio.apps.moviesup.utils.FanCallback

object Api {

    fun detail(cat: String, id: Int?, callback: FanCallback) : ArrayList<Movie> {
        val list: ArrayList<Movie> = arrayListOf()

        AndroidNetworking.get("${BuildConfig.TMDB_URL}$cat/$id")
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .addQueryParameter("language", "en")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    callback.response(response)
                }
                override fun onError(anError: ANError?) {
                    Log.e("ERROR", anError.toString())
                }
            })
        return list
    }

    fun popular(cat: String, callback: FanCallback) : ArrayList<Movie> {

        val list: ArrayList<Movie> = arrayListOf()

        AndroidNetworking.get("${BuildConfig.TMDB_URL}$cat/popular?page=1")
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .addQueryParameter("language", "en")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    callback.response(response)
                }
                override fun onError(anError: ANError?) {
                    Log.e("ERROR", anError.toString())
                }
            })
        return list
    }

}
