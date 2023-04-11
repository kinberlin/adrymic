package cm.proj.adrymic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayItemAdapter(private val mList: MutableList<DayItemViewModel>) : RecyclerView.Adapter<DayItemAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_day_items, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.date.text = ItemsViewModel.dates
        holder.day.text = ItemsViewModel.day
        holder.temperature.text = ItemsViewModel.temperature
        holder.weatherstate.text = ItemsViewModel.weather

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {

        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_weatherstate)
        val date: TextView = itemView.findViewById(R.id.txt_day_date)
        val day: TextView = itemView.findViewById(R.id.txt_day_day)
        val temperature: TextView = itemView.findViewById(R.id.txt_day_temperature)
        val weatherstate: TextView = itemView.findViewById(R.id.txt_weatherstate)
    }
}