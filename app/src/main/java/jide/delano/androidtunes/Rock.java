package jide.delano.androidtunes;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.service.voice.VoiceInteractionService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Rock extends Fragment {

    RecyclerView rock_recycler;
    CustomAdaptor customAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rock, container, false);
        return view;

    }

}
