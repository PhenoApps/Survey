package org.phenoapps.survey;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MainNavigationDirections {
  private MainNavigationDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalSatellitePlotFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_satellite_plot_fragment);
  }
}
