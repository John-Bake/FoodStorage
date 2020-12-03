package com.example.foodstorageapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

public class TestData {
    ArrayList<StorageItem> testData = new ArrayList<StorageItem>();

    public TestData() {
        StorageItem item1 = new StorageItem();

        //add first storage item to the arraylist
        //Green beans, new can
        item1.setName("Green Beans");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        Date dateStored = new Date(2020, 01, 01);
        item1.setDateStored(dateStored);

        testData.add(item1);

        //add second storage item to the arraylist
        //Green beans, will expire next month
        item1.setName("Green Beans");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        Date dateStored2 = new Date(2016, 01, 01);
        item1.setDateStored(dateStored2);

        testData.add(item1);

        //add third storage item to the arraylist
        //Green beans, expired almost 2 years ago
        item1.setName("Green Beans");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        Date dateStored3 = new Date(2014, 01, 01);
        item1.setDateStored(dateStored3);

        testData.add(item1);

        //add fourth storage item to the arraylist
        //Peas to see if it will group with the other vegetables
        item1.setName("Peas");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        Date dateStored4 = new Date(2020, 01, 01);
        item1.setDateStored(dateStored4);

        testData.add(item1);

        //add fifth storage item to the arraylist
        //Navy Beans, will expire next month
        item1.setName("Navy Beans, Dry");
        item1.setQuantity((float) 20.0);
        item1.setUnitOfMeasure("lb");
        item1.setStorageMedium("bag");
        item1.setShelfLifeInMonths(36);
        item1.setTypeOfFood("protein");
        item1.setLocation("Pantry");

        Date dateStored5 = new Date(2018, 01, 01);
        item1.setDateStored(dateStored5);

        testData.add(item1);

        //add sixth storage item to the arraylist
        //Tuna, new
        item1.setName("Tuna");
        item1.setQuantity((float) 6.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("protein");
        item1.setLocation("Pantry");

        Date dateStored6 = new Date(2020, 01, 01);
        item1.setDateStored(dateStored6);

        testData.add(item1);

        //add seventh storage item to the arraylist
        //Tuna, new
        item1.setName("Tuna");
        item1.setQuantity((float) 6.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("protein");
        item1.setLocation("Pantry");

        Date dateStored7 = new Date(2020, 01, 01);
        item1.setDateStored(dateStored7);

        testData.add(item1);

        //add eigth storage item to the arraylist
        //Tuna, new
        item1.setName("Tuna");
        item1.setQuantity((float) 6.0);
        item1.setUnitOfMeasure("oz");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("protein");
        item1.setLocation("Pantry");

        Date dateStored8 = new Date(2020, 01, 01);
        item1.setDateStored(dateStored8);

        testData.add(item1);

        //add ninth storage item to the arraylist
        //water, will expire next month
        item1.setName("Water");
        item1.setQuantity((float) 1.5);
        item1.setUnitOfMeasure("gal");
        item1.setStorageMedium("24 8oz bottles");
        item1.setShelfLifeInMonths(12);
        item1.setTypeOfFood("water");
        item1.setLocation("Garage");

        Date dateStored9 = new Date(2020, 01, 01);
        item1.setDateStored(dateStored9);

        testData.add(item1);

        //add tenth storage item to the arraylist
        //water, new
        item1.setName("Water");
        item1.setQuantity((float) 1.5);
        item1.setUnitOfMeasure("gal");
        item1.setStorageMedium("24 8oz bottles");
        item1.setShelfLifeInMonths(12);
        item1.setTypeOfFood("water");
        item1.setLocation("Garage");

        Date dateStored10 = new Date(2020, 11, 01);
        item1.setDateStored(dateStored10);

        testData.add(item1);
    }

    public StorageItem getOneItem() {
        Random rand = new Random();
        int itemToReturn = rand.nextInt(testData.size());
        return testData.get(itemToReturn);
    }

    public ArrayList<StorageItem> getAllItems() {
        return testData;
    }
}
