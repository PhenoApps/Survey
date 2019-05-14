package org.phenoapps.survey.data;

import java.lang.System;

@androidx.room.Database(entities = {org.phenoapps.survey.data.Experiment.class, org.phenoapps.survey.data.Sample.class}, version = 3)
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lorg/phenoapps/survey/data/SurveyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "experimentDao", "Lorg/phenoapps/survey/data/ExperimentDao;", "sampleDao", "Lorg/phenoapps/survey/data/SampleDao;", "Companion", "app_debug"})
public abstract class SurveyDatabase extends androidx.room.RoomDatabase {
    private static volatile org.phenoapps.survey.data.SurveyDatabase instance;
    public static final org.phenoapps.survey.data.SurveyDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.phenoapps.survey.data.ExperimentDao experimentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.phenoapps.survey.data.SampleDao sampleDao();
    
    public SurveyDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/phenoapps/survey/data/SurveyDatabase$Companion;", "", "()V", "instance", "Lorg/phenoapps/survey/data/SurveyDatabase;", "buildDatabase", "ctx", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final org.phenoapps.survey.data.SurveyDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context ctx) {
            return null;
        }
        
        private final org.phenoapps.survey.data.SurveyDatabase buildDatabase(android.content.Context ctx) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}