package org.phenoapps.survey.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JA\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u00122\u0006\u0010\u0007\u001a\u00020\bJ%\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0019\"\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lorg/phenoapps/survey/data/SampleRepository;", "", "sampleDao", "Lorg/phenoapps/survey/data/SampleDao;", "(Lorg/phenoapps/survey/data/SampleDao;)V", "createSample", "", "eid", "", "sampleName", "", "lat", "", "lng", "person", "plot", "(ILjava/lang/String;DDLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lorg/phenoapps/survey/data/Sample;", "getPlot", "getPlotNames", "updateSamples", "s", "", "([Lorg/phenoapps/survey/data/Sample;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class SampleRepository {
    private final org.phenoapps.survey.data.SampleDao sampleDao = null;
    private static volatile org.phenoapps.survey.data.SampleRepository instance;
    public static final org.phenoapps.survey.data.SampleRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createSample(int eid, @org.jetbrains.annotations.NotNull()
    java.lang.String sampleName, double lat, double lng, @org.jetbrains.annotations.NotNull()
    java.lang.String person, @org.jetbrains.annotations.NotNull()
    java.lang.String plot, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p6) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSamples(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Sample[] s, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> getPlot(int eid, @org.jetbrains.annotations.NotNull()
    java.lang.String plot) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getPlotNames(int eid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> getAll(int eid) {
        return null;
    }
    
    private SampleRepository(org.phenoapps.survey.data.SampleDao sampleDao) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/phenoapps/survey/data/SampleRepository$Companion;", "", "()V", "instance", "Lorg/phenoapps/survey/data/SampleRepository;", "getInstance", "sampleDao", "Lorg/phenoapps/survey/data/SampleDao;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final org.phenoapps.survey.data.SampleRepository getInstance(@org.jetbrains.annotations.NotNull()
        org.phenoapps.survey.data.SampleDao sampleDao) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}