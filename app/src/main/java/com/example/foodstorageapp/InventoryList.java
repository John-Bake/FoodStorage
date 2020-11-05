package com.example.foodstorageapp;

import java.util.ArrayList;

public class InventoryList {

    private ArrayList<StorageItem> inventory = new ArrayList<StorageItem>();

    public InventoryList(ArrayList<StorageItem> testInventory) {
        for (StorageItem storageItem : inventory = testInventory) {
        }
        ;
    }

    public StorageItem getItem (int index) {
                //more code to go here
        //using ArrayList type as multiple threads can access simultaneously
        return inventory.get(0);
    }

    /*
    public void addItem(List<StorageItem>) {
    }
    public void removeItem(List<StorageItem>) {
    }
    */

}
