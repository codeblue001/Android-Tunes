package jide.delano.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    //Declare variables for TabLayout, viewpaper and recycler view
    TabLayout tabLayout;
    ViewPager viewPager;
    androidx.fragment.app.FragmentPagerAdapter fragmentPagerAdapter;


    //Arrays for Icon
    final int[] ICONS = new int[]{
            R.drawable.ic_audiotrack_black_24dp,
            R.drawable.ic_queue_music_black_24dp,
            R.drawable.ic_radio_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the variables
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        tabLayout = findViewById(R.id.music_tab_layout);
        viewPager = findViewById(R.id.viewPager);


        //set Recycler layout Manager
//        rock_recycler.setLayoutManager(new GridLayoutManager(this, 1));
//        initRetrofit();
        addTabs();
        //Add adapter
        androidx.fragment.app.FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdaptor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        selectedLister();
    }

    //Add tabs
    public void addTabs() {
        //Add icons to Tablayout
        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[0]));
        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[1]));
        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[2]));

        //add text to TabLayout
        /*
        tabLayout.addTab(tabLayout.newTab().setText("Rock"));
        tabLayout.addTab(tabLayout.newTab().setText("Classic"));
        tabLayout.addTab(tabLayout.newTab().setText("Pop"));
        */
    }

    public void selectedLister() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getApplicationContext(), "This is BabaG", Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(tab.getPosition());//*****************Works!

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}