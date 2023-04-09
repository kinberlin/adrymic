package cm.proj.adrymic.Interface

import cm.proj.adrymic.weather.weather_forecast
import retrofit2.Response
import retrofit2.http.GET

interface ApiHelper {

    @GET("forecast?latitude=4.05&longitude=9.70&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,surface_pressure,cloudcover,cloudcover_low,cloudcover_mid,cloudcover_high,evapotranspiration,windspeed_10m,winddirection_10m,temperature_80m&daily=sunrise,sunset,uv_index_max,uv_index_clear_sky_max,windspeed_10m_max&current_weather=true&start_date=2023-04-08&end_date=2023-04-15&timezone=auto")
    suspend fun getWeather(): Response<weather_forecast>


}
