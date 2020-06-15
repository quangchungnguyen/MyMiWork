package com.example.mymiwork;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private  int mCategoryColor;
    public WordAdapter(Activity context, ArrayList<Word> words, int CategoryColor) {
        super(context, 0, words);
        mCategoryColor = CategoryColor;
        Log.v("WordAdapter","Sau khi chay public WordAdapter .....");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        TextView default_Translation = (TextView) listItemView.findViewById(R.id.default_Translation);
        default_Translation.setText((currentWord.getmDefaultTranslation()));

        TextView miwork_Translation = (TextView) listItemView.findViewById(R.id.miwork_Translation);
        miwork_Translation.setText(currentWord.getmMiworkTranslation());

       ImageView image_OfWord = (ImageView) listItemView.findViewById(R.id.image_of_word);
       if(currentWord.hasImage()){
           image_OfWord.setImageResource(currentWord.getmImageResourceID());
           image_OfWord.setVisibility(View.VISIBLE);
       }
       else {
           image_OfWord.setVisibility(View.GONE);
       }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mCategoryColor);
        textContainer.setBackgroundColor(color);
        return listItemView;


    }

}
