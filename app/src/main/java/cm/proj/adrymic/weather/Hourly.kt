package cm.proj.adrymic.weather

data class Hourly(
    val apparent_temperature: List<Double>,
    val cloudcover: List<Int>,
    val cloudcover_high: List<Int>,
    val cloudcover_low: List<Int>,
    val cloudcover_mid: List<Int>,
    val evapotranspiration: List<Double>,
    val precipitation: List<Double>,
    val precipitation_probability: List<Int>,
    val rain: List<Double>,
    val relativehumidity_2m: List<Int>,
    val showers: List<Double>,
    val snow_depth: List<Double>,
    val snowfall: List<Double>,
    val surface_pressure: List<Double>,
    val temperature_2m: List<Double>,
    val temperature_80m: List<Double>,
    val time: List<String>,
    val winddirection_10m: List<Int>,
    val windspeed_10m: List<Double>
)