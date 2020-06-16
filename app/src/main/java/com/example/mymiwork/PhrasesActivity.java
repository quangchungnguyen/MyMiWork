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

public class PhrasesActivity extends AppCompatActivity {
private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "Bạn đang đi đâu vậy?",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "Tên bạn là gì?",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "Tên tôi là ...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "Bạn cảm thấy như thế nào?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "Tôi cảm thấy ổn",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "Bạn đang đến phải không?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "Vâng, Tôi đang đến.",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "Tôi đang đến",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "Chúng ta hãy đi nào.",R.raw.phrase_lets_go));
        words.add(new Word("Come here", "Đến đây.",R.raw.phrase_come_here));

        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        // Log.v("NumberActivity", "Truoc khi goi adapter = new ...");
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

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
                Toast.makeText(PhrasesActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                // mMediaPlayer.setVolume(volume1,volume1);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmSoundResourceID());
                mMediaPlayer.start();
            }
        });
    }
}
