package th.ac.cmu.camt.sodiumconqueror.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import th.ac.cmu.camt.sodiumconqueror.fragment.GenericFood.GenericSlideTabFragment1;
import th.ac.cmu.camt.sodiumconqueror.fragment.GenericFood.GenericSlideTabFragment3;

/**
 * Created by Chart on 20/7/2559.
 */
public class ViewPagerAdapterGeneric extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapterGeneric(FragmentManager fm,CharSequence mTitles[],int mNumbOfTabsumb){
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            GenericSlideTabFragment1 tab1 = new GenericSlideTabFragment1();
            return tab1;
        }else {
            GenericSlideTabFragment3 tab3 = new GenericSlideTabFragment3();
            return tab3;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
