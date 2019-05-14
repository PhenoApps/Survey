package org.phenoapps.survey.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ8\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u0010J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\n2\u0006\u0010!\u001a\u00020\u0010J\u001f\u0010#\u001a\u00020\u001a2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130%\"\u00020\u0013\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lorg/phenoapps/survey/viewmodels/SampleListViewModel;", "Landroidx/lifecycle/ViewModel;", "eid", "", "repo", "Lorg/phenoapps/survey/data/SampleRepository;", "expRepo", "Lorg/phenoapps/survey/data/ExperimentRepository;", "(ILorg/phenoapps/survey/data/SampleRepository;Lorg/phenoapps/survey/data/ExperimentRepository;)V", "experiments", "Landroidx/lifecycle/LiveData;", "", "Lorg/phenoapps/survey/data/Experiment;", "getExperiments", "()Landroidx/lifecycle/LiveData;", "plotNames", "", "getPlotNames", "samples", "Lorg/phenoapps/survey/data/Sample;", "getSamples", "viewModelJob", "Lkotlinx/coroutines/Job;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "addSample", "", "e", "name", "lat", "", "lng", "person", "plot", "plots", "update", "s", "", "([Lorg/phenoapps/survey/data/Sample;)V", "app_debug"})
public final class SampleListViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.Job viewModelJob = null;
    private final kotlinx.coroutines.CoroutineScope viewModelScope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> samples = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Experiment>> experiments = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> plotNames = null;
    private final int eid = 0;
    private final org.phenoapps.survey.data.SampleRepository repo = null;
    private final org.phenoapps.survey.data.ExperimentRepository expRepo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> getSamples() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Experiment>> getExperiments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getPlotNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> plots(@org.jetbrains.annotations.NotNull()
    java.lang.String plot) {
        return null;
    }
    
    public final void addSample(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Experiment e, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double lat, double lng, @org.jetbrains.annotations.NotNull()
    java.lang.String person, @org.jetbrains.annotations.NotNull()
    java.lang.String plot) {
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Sample... s) {
    }
    
    public SampleListViewModel(int eid, @org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.SampleRepository repo, @org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.ExperimentRepository expRepo) {
        super();
    }
}