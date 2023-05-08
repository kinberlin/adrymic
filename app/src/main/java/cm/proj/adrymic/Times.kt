package cm.proj.adrymic

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Time {
    fun getDateTime() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return formatter.format(time)
    }
    fun getDate() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.format(time)
    }
    fun getHour() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH:mm")
        return formatter.format(time)
    }
    fun getHourInt() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH")
        return formatter.format(time)
    }
    fun addDaystoDate(daysToAdd: Int): String {
        // Get the current date and time
        val currentDate = Calendar.getInstance().time

        // Create a new Calendar instance and add the specified number of days to the current date
        val calendar = Calendar.getInstance()
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd)

        // Format the new date as a string in the desired format
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // Change the format as desired
        val formattedDate = dateFormat.format(calendar.time)

        // Return the formatted date string
        return formattedDate
    }
}