package jide.delano.androidtunes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
    String classics = "search?term=classick&amp;media=music&amp;entity=song&amp;limit=50";
    @GET(classics)//Classic
    Call<SongResults> getClassicMusic();

    //https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
    String pops = "search?term=pop&amp;media=music&amp;entity=song&amp;limit=50";
    @GET(pops)//pop
    Call<SongResults> getPopMusic();


    //https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
    String rocks = "search?term=rock&amp;media=music&amp;entity=song&amp;limit=50";
    @GET(rocks)//Rock
    Call<SongResults> getRockMusic();
}
