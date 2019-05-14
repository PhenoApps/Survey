package org.phenoapps.survey.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\b\u0010\'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006,"}, d2 = {"Lorg/phenoapps/survey/fragments/SatViewFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/hardware/SensorEventListener;", "()V", "accelerometerReading", "", "mBinding", "Lorg/phenoapps/survey/databinding/FragmentSatellitePlotBinding;", "mFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getMFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "mFirebaseAnalytics$delegate", "Lkotlin/Lazy;", "magnetometerReading", "orientationAngles", "parser", "Lorg/phenoapps/survey/NmeaParser;", "rotationMatrix", "sensorManager", "Landroid/hardware/SensorManager;", "getSensorManager", "()Landroid/hardware/SensorManager;", "sensorManager$delegate", "onAccuracyChanged", "", "p0", "Landroid/hardware/Sensor;", "p1", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "rotateView", "app_debug"})
public final class SatViewFragment extends androidx.fragment.app.Fragment implements android.hardware.SensorEventListener {
    private final kotlin.Lazy mFirebaseAnalytics$delegate = null;
    private final float[] accelerometerReading = null;
    private final float[] magnetometerReading = null;
    private final float[] rotationMatrix = null;
    private final float[] orientationAngles = null;
    private org.phenoapps.survey.databinding.FragmentSatellitePlotBinding mBinding;
    private final kotlin.Lazy sensorManager$delegate = null;
    private org.phenoapps.survey.NmeaParser parser;
    private java.util.HashMap _$_findViewCache;
    
    private final com.google.firebase.analytics.FirebaseAnalytics getMFirebaseAnalytics() {
        return null;
    }
    
    @java.lang.Override()
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.Sensor p0, int p1) {
    }
    
    @java.lang.Override()
    public void onSensorChanged(@org.jetbrains.annotations.NotNull()
    android.hardware.SensorEvent event) {
    }
    
    private final android.hardware.SensorManager getSensorManager() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    public final void rotateView() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    public SatViewFragment() {
        super();
    }
}