package org.gitmad.topicbingo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

public class TextViewCheckable extends TextView implements Checkable {

    public TextViewCheckable(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewCheckable(Context context) {
        super(context);
    }

    private boolean mChecked = false;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        refreshDrawableState();
    }

    private static final int[] mCheckedStateSet = {
        android.R.attr.state_checked,
    };

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, mCheckedStateSet);
        }
        return drawableState;
    }    

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

}
