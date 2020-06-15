package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "Bạn đang đi đâu vậy?"));
        words.add(new Word("What is your name?", "Tên bạn là gì?"));
        words.add(new Word("My name is...", "Tên tôi là ..."));
        words.add(new Word("How are you feeling?", "Bạn cảm thấy như thế nào?"));
        words.add(new Word("I’m feeling good.", "Tôi cảm thấy ổn"));
        words.add(new Word("Are you coming?", "Bạn đang đến phải không?"));
        words.add(new Word("Yes, I’m coming.", "Vâng, Tôi đang đến."));
        words.add(new Word("I’m coming.", "Tôi đang đến"));
        words.add(new Word("Let’s go.", "Chúng ta hãy đi nào."));
        words.add(new Word("Come here", "Đến đây."));

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
    }
}
