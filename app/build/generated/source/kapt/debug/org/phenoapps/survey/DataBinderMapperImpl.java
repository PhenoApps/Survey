package org.phenoapps.survey;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.phenoapps.survey.databinding.ActivityMainBindingImpl;
import org.phenoapps.survey.databinding.ActivityMainBindingLandImpl;
import org.phenoapps.survey.databinding.FragmentExperimentBindingImpl;
import org.phenoapps.survey.databinding.FragmentExperimentBindingLandImpl;
import org.phenoapps.survey.databinding.FragmentListSampleBindingImpl;
import org.phenoapps.survey.databinding.FragmentMapPlotsBindingImpl;
import org.phenoapps.survey.databinding.FragmentMapPlotsBindingLandImpl;
import org.phenoapps.survey.databinding.FragmentSampleBindingImpl;
import org.phenoapps.survey.databinding.FragmentSatellitePlotBindingImpl;
import org.phenoapps.survey.databinding.FragmentSatellitePlotBindingLandImpl;
import org.phenoapps.survey.databinding.ListItemExperimentBindingImpl;
import org.phenoapps.survey.databinding.ListItemSampleBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTEXPERIMENT = 2;

  private static final int LAYOUT_FRAGMENTLISTSAMPLE = 3;

  private static final int LAYOUT_FRAGMENTMAPPLOTS = 4;

  private static final int LAYOUT_FRAGMENTSAMPLE = 5;

  private static final int LAYOUT_FRAGMENTSATELLITEPLOT = 6;

  private static final int LAYOUT_LISTITEMEXPERIMENT = 7;

  private static final int LAYOUT_LISTITEMSAMPLE = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.fragment_experiment, LAYOUT_FRAGMENTEXPERIMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.fragment_list_sample, LAYOUT_FRAGMENTLISTSAMPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.fragment_map_plots, LAYOUT_FRAGMENTMAPPLOTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.fragment_sample, LAYOUT_FRAGMENTSAMPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.fragment_satellite_plot, LAYOUT_FRAGMENTSATELLITEPLOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.list_item_experiment, LAYOUT_LISTITEMEXPERIMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.phenoapps.survey.R.layout.list_item_sample, LAYOUT_LISTITEMSAMPLE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          if ("layout-land/activity_main_0".equals(tag)) {
            return new ActivityMainBindingLandImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEXPERIMENT: {
          if ("layout-land/fragment_experiment_0".equals(tag)) {
            return new FragmentExperimentBindingLandImpl(component, view);
          }
          if ("layout/fragment_experiment_0".equals(tag)) {
            return new FragmentExperimentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_experiment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLISTSAMPLE: {
          if ("layout/fragment_list_sample_0".equals(tag)) {
            return new FragmentListSampleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_list_sample is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAPPLOTS: {
          if ("layout-land/fragment_map_plots_0".equals(tag)) {
            return new FragmentMapPlotsBindingLandImpl(component, view);
          }
          if ("layout/fragment_map_plots_0".equals(tag)) {
            return new FragmentMapPlotsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_map_plots is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSAMPLE: {
          if ("layout/fragment_sample_0".equals(tag)) {
            return new FragmentSampleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sample is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSATELLITEPLOT: {
          if ("layout/fragment_satellite_plot_0".equals(tag)) {
            return new FragmentSatellitePlotBindingImpl(component, view);
          }
          if ("layout-land/fragment_satellite_plot_0".equals(tag)) {
            return new FragmentSatellitePlotBindingLandImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_satellite_plot is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMEXPERIMENT: {
          if ("layout/list_item_experiment_0".equals(tag)) {
            return new ListItemExperimentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_experiment is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMSAMPLE: {
          if ("layout/list_item_sample_0".equals(tag)) {
            return new ListItemSampleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_sample is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "mapVisible");
      sKeys.put(2, "viewModel");
      sKeys.put(3, "clickListener");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(12);

    static {
      sKeys.put("layout/activity_main_0", org.phenoapps.survey.R.layout.activity_main);
      sKeys.put("layout-land/activity_main_0", org.phenoapps.survey.R.layout.activity_main);
      sKeys.put("layout-land/fragment_experiment_0", org.phenoapps.survey.R.layout.fragment_experiment);
      sKeys.put("layout/fragment_experiment_0", org.phenoapps.survey.R.layout.fragment_experiment);
      sKeys.put("layout/fragment_list_sample_0", org.phenoapps.survey.R.layout.fragment_list_sample);
      sKeys.put("layout-land/fragment_map_plots_0", org.phenoapps.survey.R.layout.fragment_map_plots);
      sKeys.put("layout/fragment_map_plots_0", org.phenoapps.survey.R.layout.fragment_map_plots);
      sKeys.put("layout/fragment_sample_0", org.phenoapps.survey.R.layout.fragment_sample);
      sKeys.put("layout/fragment_satellite_plot_0", org.phenoapps.survey.R.layout.fragment_satellite_plot);
      sKeys.put("layout-land/fragment_satellite_plot_0", org.phenoapps.survey.R.layout.fragment_satellite_plot);
      sKeys.put("layout/list_item_experiment_0", org.phenoapps.survey.R.layout.list_item_experiment);
      sKeys.put("layout/list_item_sample_0", org.phenoapps.survey.R.layout.list_item_sample);
    }
  }
}
