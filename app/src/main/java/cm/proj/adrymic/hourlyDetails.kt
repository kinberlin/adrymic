package cm.proj.adrymic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class hourlyDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_details)

        var hl = findViewById<RecyclerView>(R.id.recyclerview_hourlyinfo)
        var adapter = HourDetailAdapter(data)
        data.add(DayItemViewModel(R.drawable.ic_sunny,"15-04","Saturday","Clear Skies", "25 °C "))
        cardView = findViewById(R.id.base_cardview)
        val arrow = findViewById<ImageView>(R.id.show)
        val dayinfo = findViewById<RecyclerView>(R.id.recyclerview_dailyinfo)
        val layoutManager = LinearLayoutManager(applicationContext)
        dayinfo.layoutManager = layoutManager
        dayinfo.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}