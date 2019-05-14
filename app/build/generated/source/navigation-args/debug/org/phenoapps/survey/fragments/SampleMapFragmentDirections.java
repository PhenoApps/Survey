package org.phenoapps.survey.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import org.phenoapps.survey.MainNavigationDirections;

public class SampleMapFragmentDirections {
  private SampleMapFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalSatellitePlotFragment() {
    return MainNavigationDirections.actionGlobalSatellitePlotFragment();
  }
}
