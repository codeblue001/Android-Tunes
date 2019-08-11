package jide.delano.androidtunes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder> {
    //Declare variables
    private SongResults dataSet;

    public void setDataSet(SongResults dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the item layout
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.onBindViewHolder(
                dataSet.results.get(position)
        );

    }

    @Override
    public int getItemCount() {
        return dataSet != null ?
                dataSet.results.size()
                :
                0;
    }
}
