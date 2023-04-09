package cm.proj.adrymic.weather

data class Daily(
    val sunrise: List<String>,
    val sunset: List<String>,
    val time: List<String>,
    val uv_index_clear_sky_max: List<Double>,
    val uv_index_max: List<Double>,
    val windspeed_10m_max: List<Double>
)