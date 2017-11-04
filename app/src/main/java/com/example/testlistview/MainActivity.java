package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.Adapter.AnimalListAdapter;
import com.example.testlistview.Model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    //private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list_view);

        //mData = new ArrayList<>();
        final AnimalData animalData = AnimalData.getsInstance();
        animalData.animalList = new ArrayList<>();

        String dCat = getString(R.string.details_cat);
        String dDog = getString(R.string.details_dog);
        String dDolphin = getString(R.string.details_dolphin);
        String dKoala = getString(R.string.details_koala);
        String dLion = getString(R.string.details_lion);
        String dOwl = getString(R.string.details_owl);
        String dPenguin = getString(R.string.details_penguin);
        String dPig = getString(R.string.details_pig);
        String dRabbit = getString(R.string.details_rabbit);
        String dTiger = getString(R.string.details_tiger);


        animalData.animalList.add(new Animal("แมว(Cat)", R.drawable.cat, dCat));
        animalData.animalList.add(new Animal("สุนัข(Dog)", R.drawable.dog, dDog));
        animalData.animalList.add(new Animal("โลมา(Dolphin)", R.drawable.dolphin, dKoala));
        animalData.animalList.add(new Animal("หมีโคล่า(Koala)", R.drawable.koala, dKoala));
        animalData.animalList.add(new Animal("สิงโต(Lion)", R.drawable.lion, dLion));
        animalData.animalList.add(new Animal("นกฮูก(Owl)", R.drawable.owl, dOwl));
        animalData.animalList.add(new Animal("เพนกวิน(Penguin)", R.drawable.penguin, dPenguin));
        animalData.animalList.add(new Animal("หมู(Pig)", R.drawable.pig, dPig));
        animalData.animalList.add(new Animal("กระต่าย(Rabbit)", R.drawable.rabbit, dRabbit));
        animalData.animalList.add(new Animal("เสือ(Tiger)", R.drawable.tiger, dTiger));

        AnimalListAdapter adapter = new AnimalListAdapter(this, R.layout.item, animalData.animalList);//ตัวเชื่อมโยง xml กับ java (Adapter)
        mListView.setAdapter(adapter); //ทำการเชื่อม ListView กับ Adapter

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Animal animalName = animalData.animalList.get(i);
                Toast.makeText(MainActivity.this, animalName.name, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetailsActivity.class);
                ///intent.putExtra("name", animalName.name);
                //intent.putExtra("picture", animalName.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
    }
}
