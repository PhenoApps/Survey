package org.phenoapps.survey.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.phenoapps.survey.viewmodels.SampleViewModel;

public abstract class ListItemSampleBinding extends ViewDataBinding {
  @NonNull
  public final TextView sampleName;

  @Bindable
  protected View.OnClickListener mClickListener;

  @Bindable
  protected SampleViewModel mViewModel;

  protected ListItemSampleBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView sampleName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.sampleName = sampleName;
  }

  public abstract void setClickListener(@Nullable View.OnClickListener clickListener);

  @Nullable
  public View.OnClickListener getClickListener() {
    return mClickListener;
  }

  public abstract void setViewModel(@Nullable SampleViewModel viewModel);

  @Nullable
  public SampleViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ListItemSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_sample, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ListItemSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ListItemSampleBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.list_item_sample, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemSampleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_sample, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ListItemSampleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ListItemSampleBinding>inflateInternal(inflater, org.phenoapps.survey.R.layout.list_item_sample, null, false, component);
  }

  public static ListItemSampleBinding bind(@NonNull View view) {
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
  public static ListItemSampleBinding bind(@NonNull View view, @Nullable Object component) {
    return (ListItemSampleBinding)bind(component, view, org.phenoapps.survey.R.layout.list_item_sample);
  }
}
