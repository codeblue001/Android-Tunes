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
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Rock();
                break;
            case 1:
                fragment = new Classic();
                break;
            case 2:
                fragment = new Pop();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        //3 tabs
        return 3;
    }


}
