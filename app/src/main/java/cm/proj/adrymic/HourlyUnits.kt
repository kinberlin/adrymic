package cm.proj.adrymic

data class HourlyUnits(
    val apparent_temperature: String,
    val cloudcover: String,
    val cloudcover_high: String,
    val cloudcover_low: String,
    val cloudcover_mid: String,
    val evapotranspiration: String,
    val precipitation: String,
    val precipitation_probability: String,
    val rain: String,
    val relativehumidity_2m: String,
    val showers: String,
    val snow_depth: String,
    val snowfall: String,
    val surface_pressure: String,
    val temperature_2m: String,
    val temperature_80m: String,
    val time: String,
    val winddirection_10m: String,
    val windspeed_10m: String
)