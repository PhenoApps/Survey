package org.phenoapps.survey.data

class SurveyData {
    var nmea: String? = null
    var lat: Double? = null
    var lng: Double? = null

    data class GPSData(val lat: Double, val lng: Double)
    data class GNSSData(val nmea: String)
}