package org.phenoapps.survey.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lorg/phenoapps/survey/viewmodels/ExperimentListViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lorg/phenoapps/survey/data/ExperimentRepository;", "(Lorg/phenoapps/survey/data/ExperimentRepository;)V", "experiments", "Landroidx/lifecycle/LiveData;", "", "Lorg/phenoapps/survey/data/Experiment;", "getExperiments", "()Landroidx/lifecycle/LiveData;", "viewModelJob", "Lkotlinx/coroutines/Job;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "addExperiment", "", "experimentId", "", "app_debug"})
public final class ExperimentListViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.Job viewModelJob = null;
    private final kotlinx.coroutines.CoroutineScope viewModelScope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Experiment>> experiments = null;
    private final org.phenoapps.survey.data.ExperimentRepository repo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Experiment>> getExperiments() {
        return null;
    }
    
    public final void addExperiment(@org.jetbrains.annotations.NotNull()
    java.lang.String experimentId) {
    }
    
    public ExperimentListViewModel(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.ExperimentRepository repo) {
        super();
    }
}