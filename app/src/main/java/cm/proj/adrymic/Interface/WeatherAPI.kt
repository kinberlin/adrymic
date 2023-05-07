package cm.proj.adrymic.Interface

import cm.proj.adrymic.weather.weather_forecast
import retrofit2.http.GET

interface weatherAPI {
    @GET("forecast")
    suspend fun getforecast(): List<weather_forecast>
}