package th.ac.cmu.camt.sodiumconqueror.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.TypedValue;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab.SlidTabFragment1;
import th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab.SlidTabFragment2;
import th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab.SlidTabFragment3;
import th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab.SlidTabFragment4;

/**
 * Created by Chart on 18/7/2559.
 */
public class ViewPagerAdapte extends FragmentStatePagerAdapter {

    private int[] imageResId = {
            R.drawable.overall_un,
            R.drawable.food_un,
            R.drawable.fact_un,
            R.drawable.other_un
    };



    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapte(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            SlidTabFragment1 tab1 = new SlidTabFragment1();
            return tab1;
        }
        if (position == 1) {
            SlidTabFragment2 tab2 = new SlidTabFragment2();
            return tab2;
        }
        if (position == 2) {
            SlidTabFragment3 tab3 = new SlidTabFragment3();
            return tab3;
        } else {
            SlidTabFragment4 tab4= new SlidTabFragment4();
            return tab4;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable image = Contextor.getInstance().getContext().getResources().getDrawable(imageResId[position]);

        //convert dp to px
        Resources r = Contextor.getInstance().getContext().getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, r.getDisplayMetrics());

        image.setBounds(0, 0, px+5,px);  // px unit
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }


}
