package org.phenoapps.survey.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentExperimentBinding extends ViewDataBinding {
  @NonNull
  public final TextView nameHeader;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView sampleCountHeader;

  @NonNull
  public final Button submitButton;

  protected FragmentExperimentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView nameHeader, RecyclerView recyclerView, TextView sampleCountHeader,
      Button submitButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.nameHeader = nameHeader;
    this.recyclerView = recyclerView;
    this.sampleCountHeader = sampleCountHeader;
    this.submitButton = submitButton;
  }

  @NonNull
  public static FragmentExperimentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_experiment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentExperimentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentExperimentBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_experiment, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentExperimentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_experiment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentExperimentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentExperimentBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_experiment, null, false, component);
  }

  public static FragmentExperimentBinding bind(@NonNull View view) {
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
  public static FragmentExperimentBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentExperimentBinding)bind(component, view, org.phenoapps.survey.R.layout.fragment_experiment);
  }
}
