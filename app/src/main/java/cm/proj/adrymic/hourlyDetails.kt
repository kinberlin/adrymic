package cm.proj.adrymic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cm.proj.adrymic.weather.Hourly
import cm.proj.adrymic.weather.HourlyUnits
import cm.proj.adrymic.weather.weather_forecast
import com.google.gson.Gson

class hourlyDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_details)
        var hol : Hourly? = null;
        var holu: HourlyUnits? = null
        val gson = Gson()
        var unserialise : String

        val hourinfo = findViewById<RecyclerView>(R.id.recyclerview_hourlyinfo)
        val layoutManager = LinearLayoutManager(applicationContext)
        hourinfo.layoutManager = layoutManager
        // checking if the intent has extra
        if (intent.hasExtra("wf")) {
            // get the Serializable data model class with the details in it
            (intent.getSerializableExtra("wf") as String).also { unserialise = it }
            var wf = gson.fromJson(unserialise, weather_forecast::class.java)
            hol = wf.hourly
            holu = wf.hourly_units
            var adapter = HourDetailAdapter(hol,holu)
            hourinfo.adapter = adapter
            adapter.notifyDataSetChanged()
        }




    }
}