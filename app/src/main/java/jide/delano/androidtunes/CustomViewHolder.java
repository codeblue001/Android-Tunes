package jide.delano.androidtunes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    //Declare global variables
    TextView tvCollectionName, tvArtistName, tvTrackPrice;
    CardView cardView;
    ImageView tvAlbumCover;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tvCollectionName= itemView.findViewById(R.id.tv_song_title);
        tvArtistName = itemView.findViewById(R.id.tv_artist_name);
        tvAlbumCover = itemView.findViewById(R.id.tv_album_cover);
        tvTrackPrice= itemView.findViewById(R.id.tv_song_price);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void onBindViewHolder(final SongList list, final CustomListener listener) {
        tvCollectionName.setText(list.getCollectionName());
        tvArtistName.setText(list.getArtistName());
        tvTrackPrice.setText(list.getTrackPrice());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(list);
            }
        });
    }
}
