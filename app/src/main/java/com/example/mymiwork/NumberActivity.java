package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

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
        words.add(new Word("one", "một", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "hai", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "ba", R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four", "bốn", R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five", "năm", R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six", "sáu", R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "bảy", R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight", "tám", R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine", "chín", R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten", "mười", R.drawable.number_ten,R.raw.number_ten));

        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        // Log.v("NumberActivity", "Truoc khi goi adapter = new ...");
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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
               // Toast.makeText(NumberActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                Log.v("NumbersActivity", "Current word: " + word);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getmSoundResourceID());
                mMediaPlayer.setVolume((float)1,(float)1);
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
