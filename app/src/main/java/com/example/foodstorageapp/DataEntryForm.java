package com.example.foodstorageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Class and activity for displaying a form and getting user input when they want to add to their
 * food storage inventory.
 *
 * This class does not take any parameters right now. That is something for future versions.
 * Right now it displays the form that the user is to fill and that is all.
 *
 * This version does not yet pass the user input to the database class.  Data is not yet collected
 * from the date spinner.  After that is collected it will be ready to call the database class.
 *
 * The barcode scanner icon does nothing at this time.
 *
 * NEW TO THIS VERSION:
 * The date had previously been a text entry box but it was replaced with a date spinner to ensure
 * that only valid dates can be entered.
 *
 * Instead of requiring the user to enter the shelf life in months, the user can choose between
 * months and years.
 *
 * Priority changes coming up:
 * -the date is collected correctly and then the database class is used to save the input from the
 * form
 * -More of the text entry boxes are replaced with spinners or other data containers
 * -Barcode scanner will be made operational
 * -class will be overloaded to accept a foodStorageItem as an input parameter and will
 * populate the from with that information to make adding repeat items or removing items easier
 *
 * @author Nathan Kempton
 * @version 1.1
 * @since 2020.11.25
 */

public class DataEntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_form);
    }

    public void clickedAddButton(View view) throws ParseException {
        StorageItem newStorageItem = new StorageItem();

        //gather the form data
        TextView textFoodName = findViewById(R.id.editTextFoodName);
        TextView numberUnitSize = findViewById(R.id.editTextNumberUnitSize);
        TextView dropdownUnits = findViewById(R.id.editTextUnits);
        TextView numberNumberToAdd = findViewById(R.id.editTextNumberToAdd);
        TextView dropdownStorageMedium = findViewById(R.id.editTextStorageMedium);
//        TextView dateDateStored = findViewById(R.id.editTextDateStored);
        TextView numberShelfLifeInMonths = findViewById(R.id.editTextNumberShelfLifeInMonths);
        TextView textFoodType = findViewById(R.id.editTextFoodType);
        TextView textLocation = findViewById(R.id.editTextLocation);


        //Set the data in the storage item class
        newStorageItem.setName(textFoodName.getText().toString());
        newStorageItem.setQuantity(Float.valueOf(numberUnitSize.getText().toString()));
        newStorageItem.setUnitOfMeasure(dropdownUnits.getText().toString());
        newStorageItem.setStorageMedium(dropdownStorageMedium.getText().toString());
        newStorageItem.setShelfLifeInMonths(Integer.parseInt(numberShelfLifeInMonths.getText().toString()));
        newStorageItem.setTypeOfFood(textFoodType.getText().toString());
        newStorageItem.setLocation(textLocation.getText().toString());

        //the date is a little more complicated
/*        String stringDateStored = dateDateStored.getText().toString();
        Date sqlDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sqlDate = simpleDateFormat.parse(stringDateStored);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newStorageItem.setDateStored(sqlDate);
*/
        //add the items to the database
        int numberToAdd = Integer.parseInt(numberNumberToAdd.getText().toString());
        if(numberToAdd <= 0) {
            numberToAdd = 1;
        }
        DataEntry itemToSave = new DataEntry();
        for(int a = 0; a < numberToAdd; a++) {
            itemToSave.saveToDatabase(newStorageItem);
        }
    }
}