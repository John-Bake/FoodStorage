package com.example.foodstorageapp;

import java.util.Date;

public class StorageItem {
    String name;
    String storageMedium;
    String typeOfFood;
    String unitOfMeasure;
    String location;
    Float quantity;
    int shelfLifeInMonths;
    Date dateStored;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getStorageMedium() {
        return storageMedium;
    }

    public void setStorageMedium(String newStorageMedium) {
        storageMedium = newStorageMedium;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String newTypeOfFood) {
        typeOfFood = newTypeOfFood;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String newUnitOfMeasure) {
        unitOfMeasure = newUnitOfMeasure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        location = newLocation;
    }

    public Date getDateStored() {
        return dateStored;
    }

    public void setDateStored(Date newDateStored) {
        dateStored = newDateStored;
    }

    public int getShelfLifeInMonths() {
        return shelfLifeInMonths;
    }

    public void setShelfLifeInMonths(int newShelfLifeInMonths) {
        shelfLifeInMonths = newShelfLifeInMonths;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float newQuantity) {
        quantity = newQuantity;
    }
}
