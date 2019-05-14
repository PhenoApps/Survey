package org.phenoapps.survey.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMapPlotsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final Button startPlot;

  @Bindable
  protected boolean mMapVisible;

  protected FragmentMapPlotsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout linearLayout, Button startPlot) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linearLayout = linearLayout;
    this.startPlot = startPlot;
  }

  public abstract void setMapVisible(boolean mapVisible);

  public boolean getMapVisible() {
    return mMapVisible;
  }

  @NonNull
  public static FragmentMapPlotsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_map_plots, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMapPlotsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMapPlotsBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_map_plots, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMapPlotsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_map_plots, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMapPlotsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMapPlotsBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_map_plots, null, false, component);
  }

  public static FragmentMapPlotsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentMapPlotsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMapPlotsBinding)bind(component, view, org.phenoapps.survey.R.layout.fragment_map_plots);
  }
}
