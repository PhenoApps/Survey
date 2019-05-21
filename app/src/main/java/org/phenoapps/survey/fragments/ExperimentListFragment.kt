package edu.ksu.wheatgenetics.survey.fragments

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.ksu.wheatgenetics.survey.adapters.ExperimentAdapter
import edu.ksu.wheatgenetics.survey.data.ExperimentRepository
import edu.ksu.wheatgenetics.survey.data.SurveyDatabase
import edu.ksu.wheatgenetics.survey.databinding.FragmentExperimentBinding
import edu.ksu.wheatgenetics.survey.viewmodels.ExperimentListViewModel
import java.text.SimpleDateFormat
import java.util.*

class ExperimentListFragment : Fragment() {

    private lateinit var mBinding: FragmentExperimentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentExperimentBinding
                .inflate(inflater, container, false)
        val adapter = ExperimentAdapter(mBinding.root.context)

        mBinding.recyclerView.adapter = adapter

        val viewModel = ViewModelProviders.of(this,
                object : ViewModelProvider.NewInstanceFactory() {

                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        @Suppress("UNCHECKED_CAST")
                        return ExperimentListViewModel(ExperimentRepository.getInstance(
                                SurveyDatabase.getInstance(requireContext()).experimentDao())) as T

                    }
                }
        ).get(ExperimentListViewModel::class.java)

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val newList = adapter.currentList.toMutableList()
                newList.removeAt(viewHolder.adapterPosition)

                viewModel.deleteExperiment(adapter.currentList[viewHolder.adapterPosition])

                adapter.submitList(newList)
            }
        }).attachToRecyclerView(mBinding.recyclerView)

        mBinding.submitButton.setOnClickListener {
            askUserNewExperimentName(mBinding.root.context, viewModel, it)
        }

        viewModel.experiments.observe(viewLifecycleOwner, Observer { result ->
            if (result != null && result.isNotEmpty()) {
                adapter.submitList(result.reversed())
                mBinding.recyclerView.smoothScrollToPosition(0)
            }
        })
        return mBinding.root
    }

    //Function that creates a Dialog with a single text entry for the user to decide a new experiment ID
    private fun askUserNewExperimentName(ctx: Context, vm: ExperimentListViewModel, v: View) {

        val input = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = "Experiment"
        }

        val builder = AlertDialog.Builder(ctx).apply {

            setView(input)

            setPositiveButton("OK") { _, _ ->
                val value = input.text.toString()
                if (value.isNotEmpty()) {
                    val cal = Calendar.getInstance()
                    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.getDefault())
                    vm.addExperiment(value, sdf.format(cal.time).toString())
                    Snackbar.make(v,
                            "New Experiment $value added.", Snackbar.LENGTH_SHORT).show()
                } else {
                    Snackbar.make(v,
                            "You must enter an experiment name.", Snackbar.LENGTH_LONG).show()
                }
            }
            setTitle("Enter a new experiment name")
        }
        builder.show()
    }
}