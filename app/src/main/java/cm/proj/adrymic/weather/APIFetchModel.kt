package cm.proj.adrymic.weather

import androidx.lifecycle.ViewModel
import cm.proj.adrymic.Interface.ApiHelper
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  APIFetchModel {

    private val baseUrl = "https://api.open-meteo.com/v1/"
    fun getInstances(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }

/* init {
        fetchWeather()
    }

    private fun fetchWeather() : List<weather_forecast>{
        var forecast : MutableList<weather_forecast> = mutableListOf()
        GlobalScope.launch(Dispatchers.Main)
        {
            try {
                var fet = apiHelper.getWeather();
                for (x in 0..fet.size)
                {forecast.add(fet[x]) }
                // list of users from the network
            } catch (e: Exception) {
                // handle exception
            }
        }
        return forecast
    }*/


}
