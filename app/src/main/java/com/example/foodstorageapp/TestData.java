package com.example.foodstorageapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.time.ZonedDateTime;
import java.time.LocalDate;

import static java.time.Month.*;

/**
 * Class to simulate getting data from the database for testing purposes until the database
 * is ready.  For our test we just have 10 items in our database.
 * This class has two public methods.
 * getOneItem() returns one StorageItem
 * getAllItems() returns an ArrayList of StorageItem
 *
 * @author Nathan Kempton
 * @version 2020/12/02  1.0
 * @since 2020/12/02
 */

@RequiresApi(api = Build.VERSION_CODES.O)
public class TestData {
    ArrayList<StorageItem> testData = new ArrayList<StorageItem>();
    LocalDate date = LocalDate.now();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TestData() {
        StorageItem item1 = new StorageItem();
        StorageItem item2 = new StorageItem();
        StorageItem item3 = new StorageItem();
        StorageItem item4 = new StorageItem();
        StorageItem item5 = new StorageItem();
        StorageItem item6 = new StorageItem();
        StorageItem item7 = new StorageItem();
        StorageItem item8 = new StorageItem();
        StorageItem item9 = new StorageItem();
        StorageItem item10 = new StorageItem();

        //add first storage item to the arraylist
        //Green beans, new can
        item1.setName("Green Beans");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        LocalDate dateStored = LocalDate.of(2020, JANUARY, 01);
        item1.setDateStored(dateStored);

        testData.add(item1);

        //add second storage item to the arraylist
        //Green beans, will expire next month
        item2.setName("Peas");
        item2.setQuantity((float) 12.0);
        item2.setUnitOfMeasure("oz");
        item2.setStorageMedium("can");
        item2.setShelfLifeInMonths(60);
        item2.setTypeOfFood("vegetables");
        item2.setLocation("Pantry");

        LocalDate dateStored2 = LocalDate.of(2016, 01, 01);
        item2.setDateStored(dateStored2);

        testData.add(item2);

        //add third storage item to the arraylist
        //Green beans, expired almost 2 years ago
        item3.setName("Carrots");
        item3.setQuantity((float) 12.0);
        item3.setUnitOfMeasure("oz");
        item3.setStorageMedium("can");
        item3.setShelfLifeInMonths(60);
        item3.setTypeOfFood("vegetables");
        item3.setLocation("Pantry");

        LocalDate dateStored3 = LocalDate.of(2018, 01, 01);
        item3.setDateStored(dateStored3);

        testData.add(item3);

        //add fourth storage item to the arraylist
        //Peas to see if it will group with the other vegetables
        item4.setName("Pears");
        item4.setQuantity((float) 12.0);
        item4.setUnitOfMeasure("oz");
        item4.setStorageMedium("can");
        item4.setShelfLifeInMonths(60);
        item4.setTypeOfFood("vegetables");
        item4.setLocation("Pantry");

        LocalDate dateStored4 = LocalDate.of(2020, 10, 01);
        item4.setDateStored(dateStored4);

        testData.add(item4);

        //add fifth storage item to the arraylist
        //Navy Beans, will expire next month
        item5.setName("Navy Beans, Dry");
        item5.setQuantity((float) 20.0);
        item5.setUnitOfMeasure("lb");
        item5.setStorageMedium("bag");
        item5.setShelfLifeInMonths(36);
        item5.setTypeOfFood("protein");
        item5.setLocation("Pantry");

        LocalDate dateStored5 = LocalDate.of(2018, 01, 01);
        item5.setDateStored(dateStored5);

        testData.add(item5);

        //add sixth storage item to the arraylist
        //Tuna, new
        item6.setName("Tuna");
        item6.setQuantity((float) 6.0);
        item6.setUnitOfMeasure("oz");
        item6.setStorageMedium("can");
        item6.setShelfLifeInMonths(60);
        item6.setTypeOfFood("protein");
        item6.setLocation("Pantry");

        LocalDate dateStored6 = LocalDate.of(2020, 01, 01);
        item6.setDateStored(dateStored6);

        testData.add(item6);

        //add seventh storage item to the arraylist
        //Tuna, new
        item7.setName("Rice");
        item7.setQuantity((float) 6.0);
        item7.setUnitOfMeasure("oz");
        item7.setStorageMedium("can");
        item7.setShelfLifeInMonths(60);
        item7.setTypeOfFood("protein");
        item7.setLocation("Pantry");

        LocalDate dateStored7 = LocalDate.of(2020, 8, 01);
        item7.setDateStored(dateStored7);

        testData.add(item7);

        //add eigth storage item to the arraylist
        //Tuna, new
        item8.setName("Deer");
        item8.setQuantity((float) 6.0);
        item8.setUnitOfMeasure("oz");
        item8.setStorageMedium("can");
        item8.setShelfLifeInMonths(60);
        item8.setTypeOfFood("protein");
        item8.setLocation("Pantry");

        LocalDate dateStored8 = LocalDate.of(2017, 1, 1);
        item8.setDateStored(dateStored8);

        testData.add(item8);

        //add ninth storage item to the arraylist
        //water, will expire next month
        item9.setName("Water");
        item9.setQuantity((float) 1.5);
        item9.setUnitOfMeasure("gal");
        item9.setStorageMedium("24 8oz bottles");
        item9.setShelfLifeInMonths(4);
        item9.setTypeOfFood("water");
        item9.setLocation("Garage");

        LocalDate dateStored9 = LocalDate.of(2020, 11, 3);
        item9.setDateStored(dateStored9);

        testData.add(item9);

        //add tenth storage item to the arraylist
        //water, new
        item10.setName("Juice");
        item10.setQuantity((float) 1.5);
        item10.setUnitOfMeasure("gal");
        item10.setStorageMedium("24 8oz bottles");
        item10.setShelfLifeInMonths(3);
        item10.setTypeOfFood("water");
        item10.setLocation("Garage");

        LocalDate dateStored10 = LocalDate.of(2020, 11, 01);
        item10.setDateStored(dateStored10);

        testData.add(item10);
    }

    public StorageItem getOneItem(int i) {
        //Random rand = new Random();
        //int itemToReturn = rand.nextInt(testData.size());
        return testData.get(i);
    }

    public ArrayList<StorageItem> getAllItems() {
        return testData;
    }
}
