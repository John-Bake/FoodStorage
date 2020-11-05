package com.example.foodstorageapp;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ValidateStorageItemTest {
    @Test
    public void timeToValidate() {
        StorageItem testItem = new StorageItem();
        testItem.setName(null);
        DataEntry testDataEntry = new DataEntry();
        assertEquals(testDataEntry.validateData(testItem), "fail");
    }
}
