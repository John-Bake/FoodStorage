package com.example.foodstorageapp;

import java.util.List;

public class FoodCategory {
    private String name;
    private List<StorageItem> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StorageItem> getItems() {
        return items;
    }

    public void setItems(List<StorageItem> items) {
        this.items = items;
    }
}
