package com.mcltechnologies.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;


public class CustomListItem extends RelativeLayout {
    private static final String TAG = CustomListItem.class.getSimpleName();
    private static final int[] STATE_ELEMENT_CHECKED = {R.attr.state_element_checked};

    private boolean checked = false;

    public CustomListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "item clicked!");
                checked = !checked;
                refreshDrawableState();
            }
        });
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        if (checked) {
            final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, STATE_ELEMENT_CHECKED);
            return drawableState;
        } else {
            return super.onCreateDrawableState(extraSpace);
        }
    }
}
