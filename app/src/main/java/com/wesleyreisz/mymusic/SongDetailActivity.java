package com.wesleyreisz.mymusic;


import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by gstitt on 10/18/14.
 */
public class SongDetailActivity extends FragmentActivity {
    private static final String SONG_TITLE = "SongTitle";
    private static final SimpleDateFormat df =
            new SimpleDateFormat("MMM d, yyyy (EEE)");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Intent intent = getIntent();
        String songTitle = intent.getStringExtra(SONG_TITLE);
        Log.d(songTitle, "The song title is" +songTitle);
        Song song = new MockMusicService().findOne(songTitle);

        TextView artist = (TextView)findViewById(R.id.textViewSongArtist);
        TextView title = (TextView)findViewById(R.id.textViewSongTitle);
        TextView date = (TextView)findViewById(R.id.textViewSongDate);
        artist.setText(song.getArtistName());
        title.setText(song.getSongTitle());
        date.setText(df.format(song.getSongPublishedDate()));


    }
}
