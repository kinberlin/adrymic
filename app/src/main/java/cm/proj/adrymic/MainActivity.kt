package cm.proj.adrymic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var cardView: CardView? = null
    var arrow: ImageView? = null
    var hiddenGroup: Group? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data : MutableList<DayItemViewModel> = mutableListOf(
            DayItemViewModel(R.drawable.ic_rain,"12-04","Wednesday","Rainy", "25 °C "),
            DayItemViewModel(R.drawable.ic_rain,"13-04","Thursday","Rainy", "25 °C "),
            DayItemViewModel(R.drawable.ic_cloudy,"14-04","Friday","Cloudy", "25 °C ")
        )
        var adapter = DayItemAdapter(data)
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
}