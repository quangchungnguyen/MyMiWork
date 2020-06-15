package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "bố", R.drawable.family_father));
        words.add(new Word("mother", "mẹ",R.drawable.family_mother));
        words.add(new Word("son", "con trai",R.drawable.family_son));
        words.add(new Word("daughter", "con gái",R.drawable.family_daughter));
        words.add(new Word("older brother", "anh trai",R.drawable.family_older_brother));
        words.add(new Word("younger brother", "em trai",R.drawable.family_younger_brother));
        words.add(new Word("older sister", "chị gái",R.drawable.family_younger_sister));
        words.add(new Word("younger sister", "em gái",R.drawable.family_older_sister));
        words.add(new Word("grandmother", "bà",R.drawable.family_grandmother));
        words.add(new Word("grandfather", "ông",R.drawable.family_grandfather));

        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        // Log.v("NumberActivity", "Truoc khi goi adapter = new ...");
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
