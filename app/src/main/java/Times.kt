package cm.proj.adrymic

import java.text.SimpleDateFormat
import java.util.*

class Times {
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
    fun getHourMinute() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH:mm")
        return formatter.format(time)
    }
    fun getHour() : String{
        // Getting latest recent position time and date
        var time = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH")
        return formatter.format(time)
    }
}