package th.ac.cmu.camt.sodiumconqueror.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

import th.ac.cmu.camt.sodiumconqueror.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CustomViewGroupSearch extends BaseCustomViewGroup {


    TextView tvSearchFoodMg,tvSearchFood;

    public CustomViewGroupSearch(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroupSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0,
                0);
    }

    public CustomViewGroupSearch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public CustomViewGroupSearch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.custom_view_group_search, this);
    }

    private void initInstances() {

        tvSearchFoodMg = (TextView)findViewById(R.id.tvSearchMg);
        tvSearchFood = (TextView)findViewById(R.id.tvSearch);
        // findViewById here

    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec); // px
        int hight = width * 1 /7 ;
        int newheightMeasure = MeasureSpec.makeMeasureSpec(hight,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width,hight);
    }



    public void setTvSearchFoodMg(String text) {
        this.tvSearchFoodMg.setText(text);
    }


    public void setTvSearchFood(String text) {
        this.tvSearchFood.setText(text);
    }
}
