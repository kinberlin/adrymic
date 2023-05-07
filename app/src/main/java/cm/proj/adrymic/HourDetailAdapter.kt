package cm.proj.adrymic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cm.proj.adrymic.weather.Hourly
import cm.proj.adrymic.weather.HourlyUnits

class HourDetailAdapter(private val mList: Hourly, val unit : HourlyUnits) : RecyclerView.Adapter<HourDetailAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourdetail_items, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ti = Times();
        holder.txt_hourdetail_time.text = mList.time[position]
        holder.txt_hourdetail_date.text = ti.getDate()
        if(ti.getHour().toInt() >5)
        {
        holder.img_hourdetail_dayornight.setImageResource(R.drawable.ic_day)
        }
        else{
            holder.img_hourdetail_dayornight.setImageResource(R.drawable.ic_night)
        }
        holder.txt_hourdetail_temperature.text = mList.temperature_2m[position].toString() +" "+ unit.temperature_2m
        holder.txt_hourdetail_humidity.text = mList.relativehumidity_2m[position].toString() +" " +unit.relativehumidity_2m
        holder.txt_hourdetail_chancerain.text = (mList.precipitation_probability[position] * 100).toString() + " " + unit.precipitation_probability
        holder.txt_hourdetail_windspeed.text = mList.windspeed_10m[position].toString() +" " + unit.winddirection_10m
        holder.txt_hourdetail_surfacepressure.text = mList.surface_pressure[position].toString() +" "+ unit.surface_pressure
        holder.txt_hourdetail_snowfall.text = mList.snowfall[position].toString() + " " + unit.snowfall
        holder.txt_hourdetail_snowdepth.text =mList.snow_depth[position].toString() + " " + unit.snow_depth
        holder.txt_hourdetail_winddirection.text = mList.winddirection_10m[position].toString() + " " + unit.winddirection_10m
        holder.txt_hourdetail_cloudcover.text = mList.cloudcover[position].toString() + " " + unit.cloudcover
        holder.txt_hourdetail_evapotranspiration.text = mList.evapotranspiration[position].toString() + " "+ unit.evapotranspiration

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {

        return mList.time.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txt_hourdetail_time: TextView= itemView.findViewById(R.id.txt_hourdetail_time)
        val txt_hourdetail_date: TextView = itemView.findViewById(R.id.txt_hourdetail_date)
        val img_hourdetail_dayornight: ImageView = itemView.findViewById(R.id.img_hourdetail_dayornight)
        val txt_hourdetail_temperature: TextView = itemView.findViewById(R.id.txt_hourdetail_temperature)
        val txt_hourdetail_humidity: TextView = itemView.findViewById(R.id.txt_hourdetail_humidity)
        val txt_hourdetail_chancerain: TextView = itemView.findViewById(R.id.txt_hourdetail_chancerain)
        val txt_hourdetail_windspeed: TextView = itemView.findViewById(R.id.txt_hourdetail_windspeed)
        val txt_hourdetail_surfacepressure: TextView = itemView.findViewById(R.id.txt_hourdetail_surfacepressure)
        val txt_hourdetail_snowfall: TextView = itemView.findViewById(R.id.txt_hourdetail_snowfall)
        val txt_hourdetail_snowdepth: TextView = itemView.findViewById(R.id.txt_hourdetail_snowdepth)
        val txt_hourdetail_winddirection: TextView = itemView.findViewById(R.id.txt_hourdetail_winddirection)
        val txt_hourdetail_cloudcover: TextView = itemView.findViewById(R.id.txt_hourdetail_cloudcover)
        val txt_hourdetail_evapotranspiration: TextView = itemView.findViewById(R.id.txt_hourdetail_evapotranspiration)


    }
}