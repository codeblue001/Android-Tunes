package jide.delano.androidtunes;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    //Declare global variables
    TextView tvSongTitle, tvArtistName, tvSongPrice;
    CardView cardView;
    ImageView tvAlbumCover;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSongTitle = itemView.findViewById(R.id.tv_song_title);
        tvArtistName = itemView.findViewById(R.id.tv_artist_name);
        tvAlbumCover = itemView.findViewById(R.id.tv_album_cover);
        tvSongPrice = itemView.findViewById(R.id.tv_song_price);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void onBindViewHolder(SongList list) {
        tvSongTitle.setText(list.collectionName);
        tvArtistName.setText(list.artistName);
        tvSongPrice.setText(list.trackPrice);
    }
}
