package std.aanrstudio.apps.moviesup.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {

    val RESOURCE = "GLOBAL"

    var espressoTestIdlingResource: CountingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResource() : IdlingResource {
        return espressoTestIdlingResource
    }
}