package jide.delano.androidtunes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder> {
    //Declare variables
    private List<SongList> dataSet;
    private CustomListener listener;

    public void setDataSet(List<SongList> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(){
        this.listener = listener;
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
                dataSet.get(position), listener
        );
    }

    @Override
    public int getItemCount() {
        return dataSet != null ?
                dataSet.size()
                :
                0;
    }
}
