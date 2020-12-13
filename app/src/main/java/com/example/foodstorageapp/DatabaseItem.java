package com.example.foodstorageapp;

import java.time.LocalDate;

public class DatabaseItem {
    public String name;
    public String storageMedium;
    public String typeOfFood;
    public String unitOfMeasure;
    public String location;
    public Float quantity; //Size of container
    public int shelfLifeInMonths;
    public String dateStored;

    public DatabaseItem() {}
    public DatabaseItem(StorageItem item) {
        this.name = item.getName();
        this.storageMedium = item.getStorageMedium();
        this.typeOfFood = item.getTypeOfFood();
        this.unitOfMeasure = item.getUnitOfMeasure();
        this.location = item.getLocation();
        this.quantity = item.getQuantity();
        this.shelfLifeInMonths = item.getShelfLifeInMonths();
        this.dateStored = item.getDateStored().toString();
    }
}
