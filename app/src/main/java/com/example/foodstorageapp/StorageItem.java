package com.example.foodstorageapp;

import java.time.LocalDate;

/***
 *   Class for storing the data used in a food storage item.
 *
 *   This class holds all of the data about a food storage item that the database will need.
 *   name:  Name of the item (green beans, mashed potatoes)
 *   storageMedium:  What is it stored in? (jars, cans, mylar, plastic)
 *   typeOfFood:  An optional field for the user to define a food category to make sorting easier.
 *      This is open for the user to define in whatever way they consider the most useful.  The
 *      default is to sort by food group (fruits, vegetables, meat, water) but the options can be
 *      changed if the user has a sorting method that they would prefer.
 *   quantity: How big is your container?  This is used in combination with unitOfMeasure
 *      unitOfMeasure: Used with the quantity to show the size of the container.  (oz, lb, kg, g,
 *      liter, gallon)
 *   location: An optional field to remind the user where the food is stored if they have multiple
 *      storage locations.  It does not come with defaults and relies on the user to input the
 *      locations that they will use. (pantry, garage, basement, under stairs)
 *   shelfLifeInMonths: What is the predicted shelf life?  The input form allows the user to enter
 *      this in months or years but it is always stored in months.
 *   dateStored:  What is the date for when it was added to storage.  This is used with
 *      shelfLifeInMonths to show how close to expired an item is.  This uses the java.time API
 *
 * New to this Version:
 * dateStored was changed from java.util.date to use the java.time.LocalDate (JSR-310) API
 *
 *   @author Nathan Kempton
 *   @version 2020.12.07    1.1
 *   @since 2020.11.25
 *
 *   @param None: There is currently no default constructor to set up the variables in the class.
 *      They are set using the setter methods.
 */

public class StorageItem {
    String name;
    String storageMedium;
    String typeOfFood;
    String unitOfMeasure;
    String location;
    Float quantity; //Size of container
    int shelfLifeInMonths;
    LocalDate dateStored;

    public StorageItem() {} // Needed to allow StorageItem object to be stored in database

    public StorageItem(StorageItem item) {
        this.name = item.getName();
        this.storageMedium = item.getStorageMedium();
        this.typeOfFood = item.getTypeOfFood();
        this.unitOfMeasure = item.getUnitOfMeasure();
        this.location = item.getLocation();
        this.quantity = item.getQuantity();
        this.shelfLifeInMonths = item.getShelfLifeInMonths();
        this.dateStored =item.getDateStored();
    }

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

    public LocalDate getDateStored() {
        return dateStored;
    }

    public void setDateStored(LocalDate newDateStored) {
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
