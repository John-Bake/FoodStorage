package com.example.foodstorageapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

/**
 * Used to make a sample storage item for when a StorageItem with dummy data is used
 */

public class MakeSampleStorageItem {
    StorageItem item1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public StorageItem create() {
        item1 = new StorageItem();
        item1.setName("Green Beans");
        item1.setQuantity((float) 12.0);
        item1.setUnitOfMeasure("lb");
        item1.setStorageMedium("can");
        item1.setShelfLifeInMonths(60);
        item1.setTypeOfFood("vegetables");
        item1.setLocation("Pantry");

        LocalDate dateStored =  LocalDate.of(2020, 01, 01);
        item1.setDateStored(dateStored);

        return item1;
    }
}
