package com.example.foodstorageapp;

import java.util.List;

public class DataEntry {
    StorageItem newItem;
    String fileName;
    List<Object> importedArray;

    public DataEntry() {}

    public DataEntry(StorageItem item) {
        newItem = item;
    }

    public void drawImputForm() {}

    public void reportSuccess() {}

    public void reportError() {}

    public String validateData(StorageItem itemToValidate) {
        return "empty method";
    }

    public StorageItem scan() {
        newItem = new StorageItem();
        return newItem;
    }

//    public List<StorageItem> importArray() {
 //       StorageItem s = new StorageItem();
  //      importedArray.add(s);
   //     return importedArray;
    //}

    public void saveToDatabase() {
        WriteQueryFactory factory = new WriteQueryFactory();
        WriteQuery saveItem = factory.getQuery(newItem);
        saveItem.makeWriteQuery();
    }
}
