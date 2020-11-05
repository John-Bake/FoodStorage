package com.example.foodstorageapp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InventoryListTest {

    @Test
    public void getItem() {
        StorageItem testStoreItem = new StorageItem();
        testStoreItem.setName("apples");

        ArrayList<StorageItem> testInventory = new ArrayList<StorageItem>();

        testInventory.add(0, testStoreItem);

        InventoryList testInvList = new InventoryList(testInventory);

        testInvList.getItem(0);

        assertNotNull(testInvList);
    }
}