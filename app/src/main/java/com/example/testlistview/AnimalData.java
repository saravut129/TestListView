package com.example.testlistview;

import com.example.testlistview.Model.Animal;

import java.util.ArrayList;

/**
 * Created by Admin on 29/10/2560.
 */

public class AnimalData {
    private static AnimalData sInstance;

    public ArrayList<Animal> animalList;

    public static AnimalData getsInstance(){
        if(sInstance==null){
            sInstance = new AnimalData();
        }
        return sInstance;
    }
}
//OOP design pattern