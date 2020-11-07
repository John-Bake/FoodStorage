package com.example.foodstorageapp;

import java.util.ArrayList;
import java.util.List;

public class InventoryList extends StorageItem {

    private List<StorageItem> inventory = new ArrayList<StorageItem>();

    /*public InventoryList(ArrayList<StorageItem> testInventory) {
        inventory = testInventory;
    }*/

    public StorageItem getItem (int index) {
                //more code to go here
        //using ArrayList type as multiple threads can access simultaneously

        return inventory.get(index);
    }

    public void addItem(StorageItem newItem) {
        //add an item to the inventory
        inventory.add(0,newItem);
    }

    public void removeItem(StorageItem storageItem) {
        //remove an item from the inventory
    }


}
