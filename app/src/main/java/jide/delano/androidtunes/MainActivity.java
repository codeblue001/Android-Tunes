package jide.delano.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //Declare variables for TabLayout
    private TabLayout tabLayout;

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

        //Initialize the variables for tablayout

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        ViewPager viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.music_tab_layout);


        //Define page Adapter
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdaptor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(fragmentPagerAdapter);

        addTabs();
        selectedLister();
//        setTitle();
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

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
