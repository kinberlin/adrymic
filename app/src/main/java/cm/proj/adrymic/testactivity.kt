package cm.proj.adrymic

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group


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