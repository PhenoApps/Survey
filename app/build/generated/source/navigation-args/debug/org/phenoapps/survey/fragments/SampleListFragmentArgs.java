package org.phenoapps.survey.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import org.phenoapps.survey.data.Experiment;

public class SampleListFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SampleListFragmentArgs() {
  }

  private SampleListFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SampleListFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SampleListFragmentArgs __result = new SampleListFragmentArgs();
    bundle.setClassLoader(SampleListFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("experiment")) {
      Experiment experiment;
      if (Parcelable.class.isAssignableFrom(Experiment.class) || Serializable.class.isAssignableFrom(Experiment.class)) {
        experiment = (Experiment) bundle.get("experiment");
      } else {
        throw new UnsupportedOperationException(Experiment.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (experiment == null) {
        throw new IllegalArgumentException("Argument \"experiment\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("experiment", experiment);
    } else {
      throw new IllegalArgumentException("Required argument \"experiment\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Experiment getExperiment() {
    return (Experiment) arguments.get("experiment");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SampleListFragmentArgs that = (SampleListFragmentArgs) object;
    if (arguments.containsKey("experiment") != that.arguments.containsKey("experiment")) {
      return false;
    }
    if (getExperiment() != null ? !getExperiment().equals(that.getExperiment()) : that.getExperiment() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getExperiment() != null ? getExperiment().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SampleListFragmentArgs{"
        + "experiment=" + getExperiment()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SampleListFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Experiment experiment) {
      if (experiment == null) {
        throw new IllegalArgumentException("Argument \"experiment\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("experiment", experiment);
    }

    @NonNull
    public SampleListFragmentArgs build() {
      SampleListFragmentArgs result = new SampleListFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setExperiment(@NonNull Experiment experiment) {
      if (experiment == null) {
        throw new IllegalArgumentException("Argument \"experiment\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("experiment", experiment);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Experiment getExperiment() {
      return (Experiment) arguments.get("experiment");
    }
  }
}
