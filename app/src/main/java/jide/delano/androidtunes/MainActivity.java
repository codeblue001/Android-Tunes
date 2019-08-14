package jide.delano.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    //Declare variables for TabLayout, viewpaper and recycler view
    TabLayout tabLayout;
    ViewPager viewPager;
    List<SongList> dataSet = new ArrayList<>();
    RecyclerView recyclerView;
    SongResults songResults;//

    private static final String TAG = "MainActivity";


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

        addTabs();
        //Add adapter
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdaptor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Add custom Adaptor
//        CustomAdaptor  customAdaptor = new CustomAdaptor();
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
//        recyclerView.setAdapter(customAdaptor);
        initRetrofit();

        selectedListener();

    }

    //Add tabs
    public void addTabs() {
        //Add icons to Tablayout
        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);

        //add text to TabLayout
        /*
        tabLayout.addTab(tabLayout.newTab().setText("Rock"));
        tabLayout.addTab(tabLayout.newTab().setText("Classic"));
        tabLayout.addTab(tabLayout.newTab().setText("Pop"));
        */
    }

    public void selectedListener() {
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


    //Init Retrofit
    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getRockMusic().enqueue(new Callback<SongResults>() {
            @Override
            public void onResponse(Call<SongResults> call, Response<SongResults> response) {
                Toast.makeText(getApplicationContext(), "Rock and Roll", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SongResults> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Epic Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}