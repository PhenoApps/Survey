package org.phenoapps.survey;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J+\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0016\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0018H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006("}, d2 = {"Lorg/phenoapps/survey/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfig", "Landroidx/navigation/ui/AppBarConfiguration;", "getAppBarConfig", "()Landroidx/navigation/ui/AppBarConfiguration;", "appBarConfig$delegate", "Lkotlin/Lazy;", "mBinding", "Lorg/phenoapps/survey/databinding/ActivityMainBinding;", "mFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getMFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "mFirebaseAnalytics$delegate", "mSurveyDirectory", "Ljava/io/File;", "navControl", "Landroidx/navigation/NavController;", "getNavControl", "()Landroidx/navigation/NavController;", "navControl$delegate", "isExternalStorageWritable", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "resultCode", "", "permissions", "", "", "granted", "", "(I[Ljava/lang/String;[I)V", "onSupportNavigateUp", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy mFirebaseAnalytics$delegate = null;
    private org.phenoapps.survey.databinding.ActivityMainBinding mBinding;
    private final kotlin.Lazy navControl$delegate = null;
    private final kotlin.Lazy appBarConfig$delegate = null;
    private java.io.File mSurveyDirectory;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String packageName = "org.phenoapps.survey";
    public static final int REQ_EXT_STORAGE = 101;
    public static final int REQ_FINE_LOCATION = 102;
    public static final org.phenoapps.survey.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.google.firebase.analytics.FirebaseAnalytics getMFirebaseAnalytics() {
        return null;
    }
    
    private final androidx.navigation.NavController getNavControl() {
        return null;
    }
    
    private final androidx.navigation.ui.AppBarConfiguration getAppBarConfig() {
        return null;
    }
    
    private final boolean isExternalStorageWritable() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int resultCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] granted) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/phenoapps/survey/MainActivity$Companion;", "", "()V", "REQ_EXT_STORAGE", "", "REQ_FINE_LOCATION", "packageName", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}