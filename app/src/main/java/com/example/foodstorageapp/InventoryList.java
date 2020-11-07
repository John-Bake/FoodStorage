package com.example.foodstorageapp;

import java.util.ArrayList;

public class InventoryList extends StorageItem {

    private ArrayList<StorageItem> inventory = new ArrayList<StorageItem>();

    public InventoryList(ArrayList<StorageItem> testInventory) {
        inventory = testInventory;
    }

    public StorageItem getItem (int index) {
                //more code to go here
        //using ArrayList type as multiple threads can access simultaneously
        StorageItem retrievedItem = new StorageItem();
        retrievedItem = inventory.get(index);

        return retrievedItem;
    }

    public void addItem(ArrayList<StorageItem> inventory) {
        //add an item to the inventory
    }

    public void removeItem(ArrayList<StorageItem> inventory) {
        //remove an item from the inventory
    }


}
