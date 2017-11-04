package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.Model.Animal;

import org.w3c.dom.Text;

public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        ImageView animalImageView = (ImageView)findViewById(R.id.image_view);
        TextView nameTextView = (TextView) findViewById(R.id.name_textView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        AnimalData animalData = AnimalData.getsInstance();
        Animal animal = animalData.animalList.get(position);

        nameTextView.setText(animal.details); //animal.name
        animalImageView.setImageResource(animal.picture);

        getSupportActionBar().setTitle(animal.name);

        /*String name = intent.getStringExtra("name");
        int picture = intent.getIntExtra("picture", 0);

        nameTextView.setText(name);
        animalImageView.setImageResource(picture);

        getSupportActionBar().setTitle(name);*/
    }
}
