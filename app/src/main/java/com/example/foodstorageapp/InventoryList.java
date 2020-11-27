package com.example.foodstorageapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InventoryList extends StorageItem {

    /**
     * The ArrayList to store all the inventory items in
     */
    private List<StorageItem> inventory = new ArrayList<StorageItem>();

    /*public InventoryList(ArrayList<StorageItem> testInventory) {
        inventory = testInventory;
    }*/

    /**
     * This function gets an item from the inventory list
     * @param index where in the inventory array the item is
     * @return the storage item from the inventory array.
     */
    public StorageItem getItem (int index) {
                //more code to go here
        //using ArrayList type as multiple threads can access simultaneously

        return inventory.get(index);
    }

    /**
     * This function adds an item to the inventory list
     * @param newItem the item to be added to the inventory list
     */

    public void addItem(StorageItem newItem) {
        //add an item to the inventory
        inventory.add(0,newItem);
    }

    /**
     * This function removes and item from the inventory list
     * @param storageItem the item to be removed
     */
    public void removeItem(StorageItem storageItem) {
        //remove an item from the inventory
    }


}
