package com.example.foodstorageapp;

public class ReadQueryFactory {
    public ReadQuery getQuery() {
        return new ItemReadQuery();
    }
}
