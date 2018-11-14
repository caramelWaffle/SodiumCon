package th.ac.cmu.camt.sodiumconqueror.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import th.ac.cmu.camt.sodiumconqueror.fragment.ThaiFood.ThaiSlideTabFragment1;
import th.ac.cmu.camt.sodiumconqueror.fragment.ThaiFood.ThaiSlideTabFragment2;
import th.ac.cmu.camt.sodiumconqueror.fragment.ThaiFood.ThaiSlideTabFragment3;

/**
 * Created by Chart on 20/7/2559.
 */
public class ViewPagerAdapterThaiFood extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapterThaiFood(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb){
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            ThaiSlideTabFragment1 tab1 = new ThaiSlideTabFragment1();
            return tab1;
        }  if (position == 1) {
            ThaiSlideTabFragment2 tab2 = new ThaiSlideTabFragment2();
            return tab2;}
            else {
            ThaiSlideTabFragment3 tab3 = new ThaiSlideTabFragment3();
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
