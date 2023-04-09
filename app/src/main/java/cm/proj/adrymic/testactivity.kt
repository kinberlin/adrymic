package cm.proj.adrymic

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import cm.proj.adrymic.Interface.ApiHelper
import cm.proj.adrymic.weather.APIFetchModel
import kotlinx.coroutines.*


class testactivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testactivity)
    }*/
    var cardView: CardView? = null
    var arrow: ImageView? = null
    var hiddenGroup: Group? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testactivity)

        val forecast = APIFetchModel.getInstances().create(ApiHelper::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = forecast.getWeather()
            if (result != null)
            // Checking the results
                Log.d("forecast: ", result.body().toString())
        }

        cardView = findViewById(R.id.base_cardview)
        val arrow = findViewById(R.id.show) as ImageView
        val hiddenGroup = findViewById(R.id.card_group) as Group
        arrow.setOnClickListener { view ->
            if (hiddenGroup.getVisibility() === View.VISIBLE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.setVisibility(View.GONE)
                arrow.setImageResource(R.drawable.ic_arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.setVisibility(View.VISIBLE)
                arrow.setImageResource(R.drawable.ic_arrow_up_float)
            }
        }
    }
}