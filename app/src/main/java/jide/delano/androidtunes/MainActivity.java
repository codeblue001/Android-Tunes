package jide.delano.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private FrameLayout frameLayout;

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

    tabLayout = findViewById(R.id.music_tab_layout);
    frameLayout = findViewById(R.id.fragment_placeholder);

    //Add tabs to Tablayout
//        tabLayout.addTab(tabLayout.newTab().setText("Rock"));
//        tabLayout.addTab(tabLayout.newTab().setText("Classic"));
//        tabLayout.addTab(tabLayout.newTab().setText("Pop"));

        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[0]));
        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[1]));
        tabLayout.addTab(tabLayout.newTab().setIcon(ICONS[2]));

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
