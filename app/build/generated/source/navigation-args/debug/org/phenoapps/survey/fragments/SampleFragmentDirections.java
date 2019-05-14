package org.phenoapps.survey.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import org.phenoapps.survey.MainNavigationDirections;

public class SampleFragmentDirections {
  private SampleFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalSatellitePlotFragment() {
    return MainNavigationDirections.actionGlobalSatellitePlotFragment();
  }
}
