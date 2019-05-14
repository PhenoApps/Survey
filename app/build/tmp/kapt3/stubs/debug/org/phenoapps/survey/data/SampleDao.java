package org.phenoapps.survey.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\'J!\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0010\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lorg/phenoapps/survey/data/SampleDao;", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lorg/phenoapps/survey/data/Sample;", "eid", "", "getPlot", "plot", "", "getPlotNames", "insert", "", "s", "updateSamples", "", "([Lorg/phenoapps/survey/data/Sample;)I", "app_debug"})
public abstract interface SampleDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM samples WHERE :eid = eid")
    public abstract androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> getAll(int eid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * from samples WHERE :eid = eid and plot = :plot")
    public abstract androidx.lifecycle.LiveData<java.util.List<org.phenoapps.survey.data.Sample>> getPlot(int eid, @org.jetbrains.annotations.NotNull()
    java.lang.String plot);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT plot from samples WHERE :eid = eid")
    public abstract androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getPlotNames(int eid);
    
    @androidx.room.Update()
    public abstract int updateSamples(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Sample... s);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    org.phenoapps.survey.data.Sample s);
}