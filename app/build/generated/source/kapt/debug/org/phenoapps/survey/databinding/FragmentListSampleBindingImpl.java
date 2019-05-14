package org.phenoapps.survey.databinding;
import org.phenoapps.survey.R;
import org.phenoapps.survey.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentListSampleBindingImpl extends FragmentListSampleBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.utcHeader, 1);
        sViewsWithIds.put(R.id.utcTextView, 2);
        sViewsWithIds.put(R.id.satsHeader, 3);
        sViewsWithIds.put(R.id.satTextView, 4);
        sViewsWithIds.put(R.id.submitSample, 5);
        sViewsWithIds.put(R.id.latHeader, 6);
        sViewsWithIds.put(R.id.latTextView, 7);
        sViewsWithIds.put(R.id.lngHeader, 8);
        sViewsWithIds.put(R.id.lngTextView, 9);
        sViewsWithIds.put(R.id.altHeader, 10);
        sViewsWithIds.put(R.id.altTextView, 11);
        sViewsWithIds.put(R.id.accHeader, 12);
        sViewsWithIds.put(R.id.accTextView, 13);
        sViewsWithIds.put(R.id.brgHeader, 14);
        sViewsWithIds.put(R.id.brgTextView, 15);
        sViewsWithIds.put(R.id.spdHeader, 16);
        sViewsWithIds.put(R.id.spdTextView, 17);
        sViewsWithIds.put(R.id.textView20, 18);
        sViewsWithIds.put(R.id.recyclerView, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentListSampleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentListSampleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.Button) bindings[5]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.mapVisible == variableId) {
            setMapVisible((boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMapVisible(boolean MapVisible) {
        this.mMapVisible = MapVisible;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mapVisible
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}