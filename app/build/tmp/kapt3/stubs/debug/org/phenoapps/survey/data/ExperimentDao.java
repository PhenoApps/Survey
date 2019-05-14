package org.phenoapps.survey.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J%\u0010\t\u001a\u00020\n2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000b\"\u0004\u0018\u00010\u0005H\'\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lorg/phenoapps/survey/data/ExperimentDao;", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lorg/phenoapps/survey/data/Experiment;", "insert", "", "e", "update", "", "", "([Lorg/phenoapps/survey/data/Experiment;)I", "app_debug"})
public abstract interface ExperimentDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM experiments")
    public abstract androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Experiment>> getAll();
    
    @androidx.room.Update()
    public abstract int update(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Experiment... e);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Experiment e);
}