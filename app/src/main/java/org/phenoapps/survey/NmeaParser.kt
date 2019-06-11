package org.phenoapps.survey

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.util.*

//TODO make nmea message data classes, lower api requirement
internal class NmeaParser {

    var gsv = ArrayList<GSV>(4)
    var numGsv = 4
    var gsvSatsInView = 0

    var mPrevSentence: String = String()
    var satellites: String = String()
    var utc: String = String()
    var latitude: String = String()
    var longitude: String = String()
    var fix: String = String()
    var hdop: String = String()
    var altitude: String = String()
    var meanSeaLevel: String = String()
    var speed: String = String()
    var accuracy: String = String()
    var bearing: String = String()

    @RequiresApi(Build.VERSION_CODES.N)
    val format = SimpleDateFormat("hhmmss")

    private var pdop: String = String()
    private var vdop: String = String()
    private var satArray: List<String> = listOf()
    private var receiverMode: String = String()
    private var fixMode = String()
    private var rmcStatus = String()
    private var course = String()
    private var modeIndicator = String()

    fun verifyChecksum(nmea: String): Boolean {

        if (nmea.contains("*")) {
            val split = nmea.split("*") //$NMEA,,,,,,,*33 <- getting the checksum
            val checksum = split[1].trim().toByte(16) //erase newline and line feed
            val msg = if ("$" in split[0]) split[0].substring(2)
            else split[0].substring(0)
            val start = split[0].toCharArray()[1]
            var sum: Int = start.toInt()
            msg.forEach {
                sum = sum xor(it.toInt()) //exclusive or of each character
            }
            //Log.d("NMEA", "${Integer.toHexString(sum)}")
            if (checksum.toInt() == sum) return true
        }
        return false
    }

    fun parse(nmea: String) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (verifyChecksum(nmea)) {

                nmea.split("*")[1]
                var nmeaType = String()
                val sentence = nmea.split(",")
                //Log.d("NMEA", "${sentence.size} $nmea")

                if (sentence.size > 0) {
                    nmeaType = sentence[0]
                    Log.d("TALKER", nmeaType)
                    //All messages should have  $TI where TI is the talker identifier
                    //followed by a 3 character nmea message type
                    if (nmeaType.length == 6) {
                        val talkerId = nmeaType.substring(0, 2)
                        nmeaType = nmeaType.substring(3)
                    }
                }

                when (nmeaType) {
                    "GGA", "PGGA" -> {
                        mPrevSentence = "GGA"
                        try {
                            utc = format.parse(sentence[1]).toString().split(" ")[3] ?: ""
                        } catch (e: ParseException) {

                        }
                        latitude = parseLatitude(sentence[3], sentence[2])
                        longitude = parseLongitude(sentence[5], sentence[4])
                        parseFixQuality(sentence[6])
                        satellites = sentence[7]
                        hdop = sentence[8]
                        altitude = sentence[9] + sentence[10]
                        meanSeaLevel = sentence[11] + sentence[12]
                    }
                    "RMC" -> { //recommended minimum specific gnss data
                        if (sentence.size == 14) {

                            mPrevSentence = "RMC"

                            /*try {
                                utc = format.parse(sentence[9] + sentence[1])?.toString() ?: ""
                            } catch (e: ParseException) {

                            }*/
                            rmcStatus = sentence[2]
                            latitude = parseLatitude(sentence[4], sentence[3])
                            longitude = parseLongitude(sentence[6], sentence[5])
                            speed = sentence[7]
                            bearing = sentence[8]
                            modeIndicator = sentence[9]
                        }
                    }
                    "GSA", "PGSA" -> {
                        //GPS receiver operating mode
                        mPrevSentence = "GSA"
                        if (sentence.size == 19) {
                            receiverMode = sentence[1]
                            fixMode = sentence[2]
                            satArray = sentence.subList(3, 14)
                            pdop = sentence[15]
                            hdop = sentence[16]
                            vdop = sentence[17]
                        }
                    }
                    //TODO parse GSV messages
                    "GSV" -> {
                        if (sentence.size >= 13) {
                            mPrevSentence = "GSV"
                            if (numGsv != sentence[1].toInt()) {
                                numGsv = sentence[1].toInt()
                                gsv = ArrayList()
                            }

                            var index = sentence[2].toInt()
                            gsvSatsInView = sentence[3].toInt()

                            for (i in 4 until 12 step 4) {
                                val thisGSV = GSV(
                                        //id of the satellite in view
                                        prn = sentence[i],
                                        //elevation in degrees
                                        elevationDeg = sentence[i + 1],
                                        //azimuth in degrees
                                        azimuthDeg = sentence[i + 2],
                                        //signal strength, 0 to 99, 0 means not being tracked
                                        snr = sentence[i + 3]
                                )

                                if (thisGSV.prn.isNotBlank() && thisGSV.snr.isNotBlank()) {
                                    gsv.removeIf { it.prn == thisGSV.prn }
                                    gsv.add(thisGSV)
                                }
                            }
                        }
                    }
                    "GLL" -> {
                        mPrevSentence = "GLL"
                        latitude = if (sentence[2] == "S") "-" + sentence[1] else sentence[1]
                        longitude = if (sentence[4] == "W") "-" + sentence[3] else sentence[3]
                        try {
                            utc = format.parse(sentence[5])?.toString() ?: ""
                        } catch (e: ParseException) {

                        }
                    }
                }
            }
        }
    }

    internal data class GSV(val prn: String, val elevationDeg: String, val azimuthDeg: String, val snr: String)

    // Convert latitude from DMS to decimal format
    private fun parseLatitude(hemisphere: String, latString: String): String {
        if (latString.isNotBlank()) {
            var lat = java.lang.Float.parseFloat(latString.substring(2)) / 60.0f
            lat += java.lang.Float.parseFloat(latString.substring(0, 2))
            if (hemisphere.contains("S")) {
                lat *= -1f
            }
            return lat.toString()
        }
        return ""
    }

    // Convert longitude from DMS to decimal format
    private fun parseLongitude(hemisphere: String, longString: String): String {
        if (longString.isNotBlank()) {
            var lng = java.lang.Float.parseFloat(longString.substring(3)) / 60.0f
            lng += java.lang.Float.parseFloat(longString.substring(0, 3))
            if (hemisphere.contains("W")) {
                lng *= -1f
            }
            return lng.toString()
        }
        return ""
    }

    private fun parseFixQuality(f: String) {
        fix = when (f) {
            "1" -> "GPS"
            "2" -> "DGPS"
            "3" -> "PPS"
            "4" -> "RTK"
            "5" -> "Float RTK"
            "6" -> "estimated"
            "7" -> "manual input mode"
            "8" -> "simulation"
            else -> "invalid"
        }
    }
}
