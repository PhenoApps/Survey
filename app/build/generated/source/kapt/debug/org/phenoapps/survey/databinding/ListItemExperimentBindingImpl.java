package org.phenoapps.survey.databinding;
import org.phenoapps.survey.R;
import org.phenoapps.survey.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemExperimentBindingImpl extends ListItemExperimentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemExperimentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ListItemExperimentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.experimentIconText.setTag(null);
        this.experimentName.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.samplesCount.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.clickListener == variableId) {
            setClickListener((android.view.View.OnClickListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((org.phenoapps.survey.viewmodels.ExperimentViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable android.view.View.OnClickListener ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable org.phenoapps.survey.viewmodels.ExperimentViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCount((androidx.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeViewModelName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCount(androidx.databinding.ObservableField<java.lang.Integer> ViewModelCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelName(androidx.databinding.ObservableField<java.lang.String> ViewModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.databinding.ObservableField<java.lang.Integer> viewModelCount = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCountGet = 0;
        java.lang.String viewModelNameGet = null;
        android.view.View.OnClickListener clickListener = mClickListener;
        java.lang.String stringValueOfViewModelCount = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelName = null;
        java.lang.Integer viewModelCountGet = null;
        org.phenoapps.survey.viewmodels.ExperimentViewModel viewModel = mViewModel;
        java.lang.CharSequence viewModelNameSubSequenceInt0Int1 = null;

        if ((dirtyFlags & 0x14L) != 0) {
        }
        if ((dirtyFlags & 0x1bL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.count
                        viewModelCount = viewModel.getCount();
                    }
                    updateRegistration(0, viewModelCount);


                    if (viewModelCount != null) {
                        // read viewModel.count.get()
                        viewModelCountGet = viewModelCount.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.count.get())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCountGet = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCountGet);


                    // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(viewModel.count.get()))
                    stringValueOfViewModelCount = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxViewModelCountGet);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.name
                        viewModelName = viewModel.getName();
                    }
                    updateRegistration(1, viewModelName);


                    if (viewModelName != null) {
                        // read viewModel.name.get()
                        viewModelNameGet = viewModelName.get();
                    }


                    if (viewModelNameGet != null) {
                        // read viewModel.name.get().subSequence(0, 1)
                        viewModelNameSubSequenceInt0Int1 = viewModelNameGet.subSequence(0, 1);
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.experimentIconText, viewModelNameSubSequenceInt0Int1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.experimentName, viewModelNameGet);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(clickListener);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.samplesCount, stringValueOfViewModelCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.count
        flag 1 (0x2L): viewModel.name
        flag 2 (0x3L): clickListener
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}