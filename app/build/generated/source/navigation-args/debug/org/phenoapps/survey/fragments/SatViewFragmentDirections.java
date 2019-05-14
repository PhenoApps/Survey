package org.phenoapps.survey.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import org.phenoapps.survey.MainNavigationDirections;
import org.phenoapps.survey.R;

public class SatViewFragmentDirections {
  private SatViewFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSatellitePlotFragmentPop() {
    return new ActionOnlyNavDirections(R.id.action_satellite_plot_fragment_pop);
  }

  @NonNull
  public static NavDirections actionGlobalSatellitePlotFragment() {
    return MainNavigationDirections.actionGlobalSatellitePlotFragment();
  }
}
