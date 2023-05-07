package cm.proj.adrymic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cm.proj.adrymic.Interface.ApiHelper
import cm.proj.adrymic.weather.APIFetchModel
import cm.proj.adrymic.weather.weather_forecast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var cardView: CardView? = null
    var arrow: ImageView? = null
    var hiddenGroup: Group? = null
    var data : MutableList<DayItemViewModel> = mutableListOf(
        DayItemViewModel(R.drawable.ic_rain,"12-04","Wednesday","Rainy", "25 °C "),
        DayItemViewModel(R.drawable.ic_rain,"13-04","Thursday","Rainy", "25 °C "),
        DayItemViewModel(R.drawable.ic_cloudy,"14-04","Friday","Cloudy", "25 °C ")
    )
    lateinit var adapter : DayItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = DayItemAdapter(data)

        val forecast = APIFetchModel.getInstances().create(ApiHelper::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = forecast.getWeather()
            if (result != null)
            // Checking the results
                Log.d("forecast: ", result.body().toString())
            updateView(result.body() as weather_forecast)
            adapter.notifyDataSetChanged()
        }


            data.add(DayItemViewModel(R.drawable.ic_sunny,"15-04","Saturday","Clear Skies", "25 °C "))
        cardView = findViewById(R.id.base_cardview)
        val arrow = findViewById<ImageView>(R.id.show)
        val dayinfo = findViewById<RecyclerView>(R.id.recyclerview_dailyinfo)
        val layoutManager = LinearLayoutManager(applicationContext)
        dayinfo.layoutManager = layoutManager
        dayinfo.adapter = adapter

        adapter.notifyDataSetChanged()
        val hiddenGroup = findViewById<Group>(R.id.card_group)
        arrow.setOnClickListener { view ->
            if (hiddenGroup.visibility === View.VISIBLE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.visibility = View.GONE
                arrow.setImageResource(R.drawable.ic_arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.visibility = View.VISIBLE
                arrow.setImageResource(R.drawable.ic_arrow_up_float)
            }
        }
    }
    fun getDayOfWeek(dateString: String, format: String): String {
        // Parse the date string using the specified format
        val dateFormat = SimpleDateFormat(format, Locale.US)
        val date = dateFormat.parse(dateString)

        // Convert the date to a calendar instance
        val calendar = Calendar.getInstance()
        calendar.time = date

        // Get the day of the week as a number (1 = Monday, 7 = Sunday)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // Return the day of the week as a string
        return when (dayOfWeek) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> ""
        }
    }
    fun getFirst10Chars(str: String) = str.take(10)

     fun updateView(wf : weather_forecast){
          data.clear()
         var dateString = "2022-08-15"
         var format = "yyyy-MM-dd"
         for (x in 0..wf.hourly.time.size step 8) {
             if (wf.hourly.temperature_2m[x] > 19 && wf.hourly.temperature_2m[x] < 27) {
                 data.add(DayItemViewModel(R.drawable.ic_rain,wf.current_weather.time,getDayOfWeek(getFirst10Chars(wf.hourly.time[x]),format),"Rain",wf.hourly.temperature_2m[x].toString()+wf.hourly_units.temperature_2m))
             }
             else if (wf.hourly.temperature_2m[x] > 22 && wf.hourly.temperature_2m[x] < 45) {
                 data.add(DayItemViewModel(R.drawable.ic_sunny,wf.current_weather.time,getDayOfWeek(getFirst10Chars(wf.hourly.time[x]),format),"Sunny",wf.hourly.temperature_2m[x].toString()+wf.hourly_units.temperature_2m))
             }
             else if (wf.hourly.temperature_2m[x] > 16 && wf.hourly.temperature_2m[x] < 25) {
                 data.add(DayItemViewModel(R.drawable.ic_cloudy,wf.current_weather.time,getDayOfWeek(getFirst10Chars(wf.hourly.time[x]),format),"Foggy",wf.hourly.temperature_2m[x].toString()+wf.hourly_units.temperature_2m))
             }
         }
     }
}