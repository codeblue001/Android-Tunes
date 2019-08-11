package jide.delano.androidtunes;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Classic extends Fragment {
    RecyclerView classic_recycler;
    CustomAdaptor customAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        classic_recycler = getView().findViewById(R.id.classic_recycleView);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classic, container, false);
        return view;
    }

}
