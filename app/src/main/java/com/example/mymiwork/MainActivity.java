package com.example.mymiwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    // Find the View that shows the numbers category
    TextView numbers = (TextView) findViewById(R.id.category_numbers);
    // Set a click listener on that View
    numbers.setOnClickListener(new View.OnClickListener(){
        // The code in this method will be executed when the numbers View is clicked on.
        @Override
        public void onClick (View view){
        Intent numbersIntent = new Intent(MainActivity.this, NumberActivity.class);
        startActivity(numbersIntent);
    }
    });


        // Find the View that shows the family members category
        TextView family = (TextView) findViewById(R.id.category_familymembers);
        // Set a click listener on that View
        family.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick (View view){
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });


        // Find the View that shows the numbers category
        TextView colors = (TextView) findViewById(R.id.category_colors);
        // Set a click listener on that View
        colors.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick (View view){
                Intent colorsIntent = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(colorsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView pharses = (TextView) findViewById(R.id.category_phares);
        // Set a click listener on that View
        pharses.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick (View view){
                Intent pharsesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(pharsesIntent);
            }
        });


    }
}
