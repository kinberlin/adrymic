package cm.proj.adrymic.weather

data class DailyUnits(
    val sunrise: String,
    val sunset: String,
    val time: String,
    val uv_index_clear_sky_max: String,
    val uv_index_max: String,
    val windspeed_10m_max: String
)