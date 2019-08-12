package jide.delano.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.FrameLayout;
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
    FrameLayout frameLayout;
    Fragment fragment;
    Pop popFragment;
    Rock rockFragment;
    Classic classicFragment;
    List<SongList> dataSet = new ArrayList<>();
    CustomAdaptor adaptor;
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


        initRetrofit();


        selectedLister();
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


    //Init Retrofit
    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getRockMusic().enqueue(new Callback<SongResults>() {
            @Override
            public void onResponse(Call<SongResults> call, Response<SongResults> response) {
                dataSet = parse(response.body());
                adaptor.setDataSet(dataSet);
            }

            @Override
            public void onFailure(Call<SongResults> call, Throwable t) {

            }
        });
    }

    private List<SongList> parse(SongResults results) {
        List<SongList> dataSet = new ArrayList<>();

        for (int i = 0; i < results.getResults().size(); i++) {
            SongList song = new SongList();
            song.setArtistName(results.getResults().get(i).getArtistName());
            song.setTrackPrice(results.getResults().get(i).getTrackPrice());
            song.setCollectionName(results.getResults().get(i).getCollectionName());
            song.setArtworkUrl60(results.getResults().get(i).getArtworkUrl60());
            dataSet.add(song);
        }

        return dataSet;
    }


}