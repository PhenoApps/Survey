package org.phenoapps.survey;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001SB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0004J\u0010\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0018\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0002J\u0018\u0010O\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0002J\u000e\u0010Q\u001a\u00020R2\u0006\u0010I\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b\'\u0010\bR\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u000e\u00104\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u000e\u00108\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u000e\u0010F\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lorg/phenoapps/survey/NmeaParser;", "", "()V", "accuracy", "", "getAccuracy", "()Ljava/lang/String;", "setAccuracy", "(Ljava/lang/String;)V", "altitude", "getAltitude", "setAltitude", "bearing", "getBearing", "setBearing", "course", "fix", "getFix", "setFix", "fixMode", "format", "Landroid/icu/text/SimpleDateFormat;", "getFormat", "()Landroid/icu/text/SimpleDateFormat;", "gsv", "Ljava/util/ArrayList;", "Lorg/phenoapps/survey/NmeaParser$GSV;", "getGsv", "()Ljava/util/ArrayList;", "setGsv", "(Ljava/util/ArrayList;)V", "gsvSatsInView", "", "getGsvSatsInView", "()I", "setGsvSatsInView", "(I)V", "hdop", "getHdop", "setHdop", "latitude", "getLatitude", "setLatitude", "longitude", "getLongitude", "setLongitude", "mPrevSentence", "getMPrevSentence", "setMPrevSentence", "meanSeaLevel", "getMeanSeaLevel", "setMeanSeaLevel", "modeIndicator", "numGsv", "getNumGsv", "setNumGsv", "pdop", "receiverMode", "rmcStatus", "satArray", "", "satellites", "getSatellites", "setSatellites", "speed", "getSpeed", "setSpeed", "utc", "getUtc", "setUtc", "vdop", "parse", "", "nmea", "parseFixQuality", "f", "parseLatitude", "hemisphere", "latString", "parseLongitude", "longString", "verifyChecksum", "", "GSV", "app_debug"})
public final class NmeaParser {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<org.phenoapps.survey.NmeaParser.GSV> gsv;
    private int numGsv;
    private int gsvSatsInView;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mPrevSentence;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String satellites;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String utc;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String latitude;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String longitude;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fix;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String hdop;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String altitude;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String meanSeaLevel;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String speed;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String accuracy;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String bearing;
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final android.icu.text.SimpleDateFormat format = null;
    private java.lang.String pdop;
    private java.lang.String vdop;
    private java.util.List<java.lang.String> satArray;
    private java.lang.String receiverMode;
    private java.lang.String fixMode;
    private java.lang.String rmcStatus;
    private java.lang.String course;
    private java.lang.String modeIndicator;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<org.phenoapps.survey.NmeaParser.GSV> getGsv() {
        return null;
    }
    
    public final void setGsv(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<org.phenoapps.survey.NmeaParser.GSV> p0) {
    }
    
    public final int getNumGsv() {
        return 0;
    }
    
    public final void setNumGsv(int p0) {
    }
    
    public final int getGsvSatsInView() {
        return 0;
    }
    
    public final void setGsvSatsInView(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMPrevSentence() {
        return null;
    }
    
    public final void setMPrevSentence(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSatellites() {
        return null;
    }
    
    public final void setSatellites(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUtc() {
        return null;
    }
    
    public final void setUtc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLatitude() {
        return null;
    }
    
    public final void setLatitude(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLongitude() {
        return null;
    }
    
    public final void setLongitude(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFix() {
        return null;
    }
    
    public final void setFix(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHdop() {
        return null;
    }
    
    public final void setHdop(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAltitude() {
        return null;
    }
    
    public final void setAltitude(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMeanSeaLevel() {
        return null;
    }
    
    public final void setMeanSeaLevel(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSpeed() {
        return null;
    }
    
    public final void setSpeed(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccuracy() {
        return null;
    }
    
    public final void setAccuracy(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBearing() {
        return null;
    }
    
    public final void setBearing(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.icu.text.SimpleDateFormat getFormat() {
        return null;
    }
    
    public final boolean verifyChecksum(@org.jetbrains.annotations.NotNull()
    java.lang.String nmea) {
        return false;
    }
    
    public final void parse(@org.jetbrains.annotations.NotNull()
    java.lang.String nmea) {
    }
    
    private final java.lang.String parseLatitude(java.lang.String hemisphere, java.lang.String latString) {
        return null;
    }
    
    private final java.lang.String parseLongitude(java.lang.String hemisphere, java.lang.String longString) {
        return null;
    }
    
    private final void parseFixQuality(java.lang.String f) {
    }
    
    public NmeaParser() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lorg/phenoapps/survey/NmeaParser$GSV;", "", "prn", "", "elevationDeg", "azimuthDeg", "snr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAzimuthDeg", "()Ljava/lang/String;", "getElevationDeg", "getPrn", "getSnr", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class GSV {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String prn = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String elevationDeg = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String azimuthDeg = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String snr = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrn() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getElevationDeg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAzimuthDeg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSnr() {
            return null;
        }
        
        public GSV(@org.jetbrains.annotations.NotNull()
        java.lang.String prn, @org.jetbrains.annotations.NotNull()
        java.lang.String elevationDeg, @org.jetbrains.annotations.NotNull()
        java.lang.String azimuthDeg, @org.jetbrains.annotations.NotNull()
        java.lang.String snr) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.phenoapps.survey.NmeaParser.GSV copy(@org.jetbrains.annotations.NotNull()
        java.lang.String prn, @org.jetbrains.annotations.NotNull()
        java.lang.String elevationDeg, @org.jetbrains.annotations.NotNull()
        java.lang.String azimuthDeg, @org.jetbrains.annotations.NotNull()
        java.lang.String snr) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}