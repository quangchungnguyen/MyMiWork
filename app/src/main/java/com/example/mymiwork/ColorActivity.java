package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
private  MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "đỏ", R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green", "xanh lá", R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "nâu",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("grey", "xám",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "đen",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "trắng",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow", "vàng lạt",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "vàng đậm",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        //Log.v("NumberActivity", "Truoc khi goi adapter = new ...");
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                //Log.v("numberactivity","test 1");
                //Toast.makeText(ColorActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();
               Word word = words.get(position);
                releaseMediaPlayer();
                // mMediaPlayer.setVolume(volume1,volume1);
                mMediaPlayer = MediaPlayer.create(ColorActivity.this, word.getmSoundResourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);

            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
