package com.irontec.kotlintest.models

/**
 * Created by axier on 24/4/15.
 */
class WeatherObject {

    var main: String = ""
    var description: String = ""
    var temp: Float = 0.0f
    var temp_Max: Float = 0.0f
    var temp_Min: Float = 0.0f
    var humidity: Int = 0
    var wind: WindObject? = null

    init {
        println(this.toString())
    }

    override fun toString() =
            "Main ${main}\n" +
            "description ${description}\n" +
            "temp ${temp}\n" +
            "temp_Max ${temp_Max}\n" +
            "temp_Min ${temp_Min}\n" +
            "humidity ${humidity}\n" +
            "wind ${wind.toString()}"

}