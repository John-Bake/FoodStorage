package com.example.foodstorageapp;

import androidx.appcompat.app.AppCompatActivity;

//much of this code is modified from example on
//https://www.tutorialspoint.com/android/android_list_view.htm

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InventoryListDisplay extends AppCompatActivity {

    // Array of Storage items to be replaced with real code
    String[] storageItemsArray = {"Canned Peaches","Bag Rice","Chocolate Bars","Dried Apple Slices",
            "Canned Potato Peals","Canned Oats"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_list_display);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_inv_listview, storageItemsArray);

        ListView listView = (ListView) findViewById(R.id.inventory_list);
        listView.setAdapter(adapter);
    }
}