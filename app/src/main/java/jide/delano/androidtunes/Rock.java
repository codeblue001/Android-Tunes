package jide.delano.androidtunes;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rock extends Fragment {

    RecyclerView rock_recycler;
    CustomAdaptor customAdaptor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        rock_recycler = getView().findViewById(R.id.rock_recycleView);
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rock, container, false);
        return view;
    }

    //Create Global Callback Variable
    Callback<SongResults> callback = new Callback<SongResults>() {
        @Override
        public void onResponse(Call<SongResults> call, Response<SongResults> response) {
            if (response.isSuccessful()) {
                customAdaptor = new CustomAdaptor();
                customAdaptor.setDataSet(response.body());
                rock_recycler.setAdapter(customAdaptor);
            }
        }

        @Override
        public void onFailure(Call<SongResults> call, Throwable t) {

        }
    };

    //Init Retrofit
    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getRockMusic().enqueue(callback);
    }
}
