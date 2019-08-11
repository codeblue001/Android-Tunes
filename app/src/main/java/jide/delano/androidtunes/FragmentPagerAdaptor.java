package jide.delano.androidtunes;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPagerAdaptor extends FragmentPagerAdapter {

    private int numOfTabs;

    public FragmentPagerAdaptor(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Rock();
            case 1:
                return new Classic();
            case 2:
                return new Pop();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        //3 tabs
        return numOfTabs;
    }
}
