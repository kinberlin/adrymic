package cm.proj.adrymic.weather

import cm.proj.adrymic.Interface.ApiHelper

class ApiHelperImpl(private val apiService: ApiHelper) : ApiHelper {

    override suspend fun getWeather() = apiService.getWeather()

}
