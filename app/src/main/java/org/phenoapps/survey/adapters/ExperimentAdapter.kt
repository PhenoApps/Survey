package org.phenoapps.survey.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.survey.R
import org.phenoapps.survey.data.Experiment
import org.phenoapps.survey.databinding.ListItemExperimentBinding
import org.phenoapps.survey.viewmodels.ExperimentViewModel

class ExperimentAdapter(
        val context: Context
) : ListAdapter<Experiment, ExperimentAdapter.ViewHolder>(ExperimentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.list_item_experiment, parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        getItem(position).let { experiment ->
            with(holder) {
                itemView.tag = experiment
                bind(Navigation.createNavigateOnClickListener(
                        R.id.action_experiment_fragment_to_sample_list_fragment,
                        Bundle().apply { putParcelable("experiment", experiment) }), experiment)
            }
        }
    }

    class ViewHolder(
            private val binding: ListItemExperimentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, experiment: Experiment) {

            with(binding) {
                clickListener = listener
                viewModel = ExperimentViewModel(experiment)
                executePendingBindings()
            }
        }
    }
}

private class ExperimentDiffCallback : DiffUtil.ItemCallback<Experiment>() {

    override fun areItemsTheSame(oldItem: Experiment, newItem: Experiment): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Experiment, newItem: Experiment): Boolean {
        return oldItem.name == newItem.name
    }
}