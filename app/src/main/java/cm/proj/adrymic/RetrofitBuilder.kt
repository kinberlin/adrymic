package cm.proj.adrymic

import cm.proj.adrymic.Interface.weatherAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "    https://api.open-meteo.com/v1/forecast?"
//latitude=4.05&longitude=9.70&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,snow_depth,surface_pressure,cloudcover,cloudcover_low,cloudcover_mid,cloudcover_high,evapotranspiration,windspeed_10m,winddirection_10m,temperature_80m&daily=sunrise,sunset,uv_index_max,uv_index_clear_sky_max,windspeed_10m_max&current_weather=true&start_date=2023-04-08&end_date=2023-04-15&timezone=auto
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL + "jhj")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: weatherAPI = getRetrofit().create(weatherAPI::class.java)

}
