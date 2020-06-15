package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "đỏ", R.drawable.color_red));
        words.add(new Word("green", "xanh lá", R.drawable.color_green));
        words.add(new Word("brown", "nâu",R.drawable.color_brown));
        words.add(new Word("grey", "xám",R.drawable.color_gray));
        words.add(new Word("black", "đen",R.drawable.color_black));
        words.add(new Word("white", "trắng",R.drawable.color_white));
        words.add(new Word("dusty yellow", "vàng lạt",R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow", "vàng đậm",R.drawable.color_mustard_yellow));

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
    }
}
