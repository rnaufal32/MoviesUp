package std.aanrstudio.apps.moviesup.utils

import org.json.JSONObject

interface FanCallback {
    fun response(objects: JSONObject)
}