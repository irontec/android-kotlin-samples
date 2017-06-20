package com.irontec.kotlintest.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.irontec.kotlintest.models.WeatherObject
import com.irontec.kotlintest.models.WindObject
import java.lang.reflect.Type

/**
 * Created by axier on 24/4/15.
 */
open class WeatherDeserializer : JsonDeserializer<WeatherObject> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): WeatherObject? {
        val jsonObj = json as JsonObject

        val wheather = WeatherObject()
        val wind = WindObject()

        val jsonWeatherArray = jsonObj.getAsJsonArray("weather").get(0)
        val jsonMainObj = jsonObj.getAsJsonObject("main")
        val jsonWindObj = jsonObj.getAsJsonObject("wind")

        wheather.main = jsonWeatherArray.asJsonObject.get("main").asString
        wheather.description = jsonWeatherArray.asJsonObject.get("description").asString
        wheather.temp = jsonMainObj.get("temp").asFloat
        wheather.tempMax = jsonMainObj.get("temp_max").asFloat
        wheather.tempMin = jsonMainObj.get("temp_min").asFloat
        wheather.humidity = jsonMainObj.get("humidity").asInt
        wind.speed = jsonWindObj.get("speed").asFloat
        wind.deg = jsonWindObj.get("deg").asFloat
        wheather.wind = wind

        return wheather

    }
}