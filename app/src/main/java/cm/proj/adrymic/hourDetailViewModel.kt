package cm.proj.adrymic

import cm.proj.adrymic.weather.Hourly
import cm.proj.adrymic.weather.HourlyUnits

data class hourDetailViewModel(val hourly : Hourly, val hourly_units : HourlyUnits)
/*data class hourDetailViewModel
    (val hourdetail_humidity: String, val hourdetail_chancerain: String, val hourdetail_windspeed: String,
     val hourdetail_surfacepressure: String, val hourdetail_snowfall: String, val hourdetail_evapotranspiration: String,
     val hourdetail_winddirection: String, val hourdetail_cloudcover: String, val hourdetail_snowdepth: String,
     val hourdetail_time: String, val hourdetail_date: String, val txt_day_date: String,
     val img_hourdetail_dayornight: Int) */

