package com.example.foodstorageapp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryListTest extends InventoryList {

    @Test
    public void getItem() {
        StorageItem testStoreItem = new StorageItem();
        testStoreItem.setName("apples");

        InventoryList testInventory = new InventoryList();

        testInventory.addItem(testStoreItem);

        testInventory.getItem(0);

        assertNotNull(testInventory);
    }
}