package org.phenoapps.survey.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentListSampleBinding extends ViewDataBinding {
  @NonNull
  public final TextView accHeader;

  @NonNull
  public final TextView accTextView;

  @NonNull
  public final TextView altHeader;

  @NonNull
  public final TextView altTextView;

  @NonNull
  public final TextView brgHeader;

  @NonNull
  public final TextView brgTextView;

  @NonNull
  public final TextView latHeader;

  @NonNull
  public final TextView latTextView;

  @NonNull
  public final TextView lngHeader;

  @NonNull
  public final TextView lngTextView;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView satTextView;

  @NonNull
  public final TextView satsHeader;

  @NonNull
  public final TextView spdHeader;

  @NonNull
  public final TextView spdTextView;

  @NonNull
  public final Button submitSample;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView utcHeader;

  @NonNull
  public final TextView utcTextView;

  @Bindable
  protected boolean mMapVisible;

  protected FragmentListSampleBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView accHeader, TextView accTextView, TextView altHeader, TextView altTextView,
      TextView brgHeader, TextView brgTextView, TextView latHeader, TextView latTextView,
      TextView lngHeader, TextView lngTextView, RecyclerView recyclerView, TextView satTextView,
      TextView satsHeader, TextView spdHeader, TextView spdTextView, Button submitSample,
      TextView textView20, TextView utcHeader, TextView utcTextView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accHeader = accHeader;
    this.accTextView = accTextView;
    this.altHeader = altHeader;
    this.altTextView = altTextView;
    this.brgHeader = brgHeader;
    this.brgTextView = brgTextView;
    this.latHeader = latHeader;
    this.latTextView = latTextView;
    this.lngHeader = lngHeader;
    this.lngTextView = lngTextView;
    this.recyclerView = recyclerView;
    this.satTextView = satTextView;
    this.satsHeader = satsHeader;
    this.spdHeader = spdHeader;
    this.spdTextView = spdTextView;
    this.submitSample = submitSample;
    this.textView20 = textView20;
    this.utcHeader = utcHeader;
    this.utcTextView = utcTextView;
  }

  public abstract void setMapVisible(boolean mapVisible);

  public boolean getMapVisible() {
    return mMapVisible;
  }

  @NonNull
  public static FragmentListSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_list_sample, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentListSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentListSampleBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_list_sample, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentListSampleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_list_sample, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentListSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentListSampleBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.fragment_list_sample, null, false, component);
  }

  public static FragmentListSampleBinding bind(@NonNull View view) {
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
  public static FragmentListSampleBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentListSampleBinding)bind(component, view, org.phenoapps.survey.R.layout.fragment_list_sample);
  }
}
