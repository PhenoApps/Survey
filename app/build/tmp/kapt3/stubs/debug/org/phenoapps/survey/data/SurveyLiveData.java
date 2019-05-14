package org.phenoapps.survey.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010 \u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lorg/phenoapps/survey/data/SurveyLiveData;", "Landroidx/lifecycle/LiveData;", "Lorg/phenoapps/survey/data/SurveyData;", "Landroid/location/LocationListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mLocManager", "Landroid/location/LocationManager;", "getMLocManager", "()Landroid/location/LocationManager;", "mLocManager$delegate", "Lkotlin/Lazy;", "mMaxAccuracy", "", "mMinDist", "mMinTime", "", "surveyData", "getSurveyData", "()Lorg/phenoapps/survey/data/SurveyData;", "surveyData$delegate", "onLocationChanged", "", "location", "Landroid/location/Location;", "onProviderDisabled", "p0", "", "onProviderEnabled", "onStatusChanged", "p1", "", "p2", "Landroid/os/Bundle;", "app_debug"})
public final class SurveyLiveData extends androidx.lifecycle.LiveData<org.phenoapps.survey.data.SurveyData> implements android.location.LocationListener {
    private final kotlin.Lazy surveyData$delegate = null;
    private float mMaxAccuracy;
    private float mMinDist;
    private long mMinTime;
    private final kotlin.Lazy mLocManager$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    private final org.phenoapps.survey.data.SurveyData getSurveyData() {
        return null;
    }
    
    private final android.location.LocationManager getMLocManager() {
        return null;
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    @java.lang.Override()
    public void onStatusChanged(@org.jetbrains.annotations.Nullable()
    java.lang.String p0, int p1, @org.jetbrains.annotations.Nullable()
    android.os.Bundle p2) {
    }
    
    @java.lang.Override()
    public void onProviderEnabled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onProviderDisabled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public SurveyLiveData(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}