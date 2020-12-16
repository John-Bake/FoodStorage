package com.example.foodstorageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InventoryListActivity extends AppCompatActivity {

    //will replace with real data query once Item
    TestData testData = new TestData();
    InventoryList invList = new InventoryList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_inventory_list);

        for (int i = 0; i < testData.testData.size(); i++) {
            StorageItem item = testData.getOneItem(i);
            invList.addItem(item);
        }

        //help with this code from https://www.youtube.com/watch?v=VYDLTBjdliY
        ListView listView = (ListView) findViewById(R.id.items_list);

        HashMap<String, String> itemDetails = new HashMap<>();

        for (int i = 0; i < invList.getSize(); i++) {
            StorageItem item = invList.getItem(i);
            LocalDate expiry = item.getDateStored().plusMonths(item.shelfLifeInMonths);
            String qty = item.getQuantity() + " " + item.getUnitOfMeasure();

            itemDetails.put( invList.getItem(i).getName(), qty + " Exp: " + expiry);
        }

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.activity_listview, new String[]{"First Line", "Second Line"},
                new int[]{R.id.item_name, R.id.item_details});


        Iterator it = itemDetails.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        listView.setAdapter(adapter);
    }


    //Setting menu to add later
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSettings() {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }*/
}
