package org.phenoapps.survey.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import org.phenoapps.survey.MainNavigationDirections;
import org.phenoapps.survey.R;
import org.phenoapps.survey.data.Experiment;

public class SampleListFragmentDirections {
  private SampleListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSampleListFragmentToSampleFragment() {
    return new ActionOnlyNavDirections(R.id.action_sample_list_fragment_to_sample_fragment);
  }

  @NonNull
  public static ActionMapLocations actionMapLocations(@NonNull Experiment experiment) {
    return new ActionMapLocations(experiment);
  }

  @NonNull
  public static NavDirections actionGlobalSatellitePlotFragment() {
    return MainNavigationDirections.actionGlobalSatellitePlotFragment();
  }

  public static class ActionMapLocations implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMapLocations(@NonNull Experiment experiment) {
      if (experiment == null) {
        throw new IllegalArgumentException("Argument \"experiment\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("experiment", experiment);
    }

    @NonNull
    public ActionMapLocations setExperiment(@NonNull Experiment experiment) {
      if (experiment == null) {
        throw new IllegalArgumentException("Argument \"experiment\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("experiment", experiment);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("experiment")) {
        Experiment experiment = (Experiment) arguments.get("experiment");
        if (Parcelable.class.isAssignableFrom(Experiment.class) || experiment == null) {
          __result.putParcelable("experiment", Parcelable.class.cast(experiment));
        } else if (Serializable.class.isAssignableFrom(Experiment.class)) {
          __result.putSerializable("experiment", Serializable.class.cast(experiment));
        } else {
          throw new UnsupportedOperationException(Experiment.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_map_locations;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Experiment getExperiment() {
      return (Experiment) arguments.get("experiment");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMapLocations that = (ActionMapLocations) object;
      if (arguments.containsKey("experiment") != that.arguments.containsKey("experiment")) {
        return false;
      }
      if (getExperiment() != null ? !getExperiment().equals(that.getExperiment()) : that.getExperiment() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getExperiment() != null ? getExperiment().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMapLocations(actionId=" + getActionId() + "){"
          + "experiment=" + getExperiment()
          + "}";
    }
  }
}
