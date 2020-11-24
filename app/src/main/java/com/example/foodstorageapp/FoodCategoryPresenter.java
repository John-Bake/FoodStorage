package com.example.foodstorageapp;

import java.util.LinkedList;

public class FoodCategoryPresenter {

    void displayList(String[] args){
        LinkedList<String> typeOfFood = new LinkedList<String>();
        typeOfFood.add("Fruits");
        typeOfFood.add("Veggies");
        typeOfFood.add("Grains");
        typeOfFood.add("Protein (meat and beans)");
        typeOfFood.add("Spices");
        typeOfFood.add("Water");
        typeOfFood.add("Cleaning Supplies/Toiletries");
        //System.out.println(typeOfFood);
    }

}
