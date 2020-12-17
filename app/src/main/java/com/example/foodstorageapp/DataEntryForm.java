package com.example.foodstorageapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Class and activity for displaying a form and getting user input when they want to add to their
 * food storage inventory.
 *
 * This class does not take any parameters right now. That is something for future versions.
 * Right now all input comes directly from the user.
 *
 * All data is collected and put into a foodStorageItem object.  The foodStorageItem is then given
 * to the itemWriteQuery class to save it to the database.
 *
 * The barcode scanner icon does nothing at this time.
 *
 * NEW TO THIS VERSION:
 * Toasts display when items are added to the database or the QR code is generated
 *
 * Priority changes coming up:
 * -QR code scanner will be made operational
 * -Instead of using a default value when a field is left blank, non-optional fields will reprompt
 *  the user to fill it in.
 *
 *
 * @author Nathan Kempton
 * @version 2020.12.12  1.7
 * @since 2020.11.25    1.0
 */

public class DataEntryForm extends AppCompatActivity {
    public final static String SIJSON = "com.example.testfoodstorage.StorageItemJSON";

    StorageItem newStorageItem;
    TextView textFoodName;
    TextView numberUnitSize;
    Spinner dropdownUnits;
    TextView numberNumberToAdd;
    TextView dropdownStorageMedium;
    DatePicker picker;
    TextView numberShelfLifeInMonths;
    Spinner monthYearSpinner;
    TextView textFoodType;
    TextView textLocation;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_data_entry_form);

        if(getIntent().getExtras() != null) {
            String jsonString = getIntent().getStringExtra(SIJSON);
            newStorageItem.fromString(jsonString);
        }
        Log.i("OnCreate", "Finish intents");

        //Assign the form fields to variables
        textFoodName = findViewById(R.id.editTextFoodName);
        numberUnitSize = findViewById(R.id.editTextNumberUnitSize);
        dropdownUnits = findViewById(R.id.editTextUnits);
        numberNumberToAdd = findViewById(R.id.editTextNumberToAdd);
        dropdownStorageMedium = findViewById(R.id.editTextStorageMedium);
        picker = (DatePicker)findViewById(R.id.datePicker1);
        numberShelfLifeInMonths = findViewById(R.id.editTextNumberShelfLifeInMonths);
        monthYearSpinner = findViewById(R.id.spinnerMonthYear);
        textFoodType = findViewById(R.id.editTextFoodType);
        textLocation = findViewById(R.id.editTextLocation);
        Log.i("OnCreate", "finish assigning form variables");

        //For each class variable, assign it to the appropriate field if it exists
        if(!newStorageItem.getName().equals(" ")){
            textFoodName.setText(newStorageItem.getName());
        }
        if(newStorageItem.getQuantity()!=0){
            numberUnitSize.setText(newStorageItem.getQuantity().toString());
        }
        if(!newStorageItem.getUnitOfMeasure().equals(" ")) {
            int pos = 0;
            int itemCount = dropdownUnits.getCount();
            for(int a = 0; a < itemCount; a++){
                if(newStorageItem.getUnitOfMeasure().equals(dropdownUnits.getItemAtPosition(a).toString())) {
                    pos = a;
                    a = itemCount;
                }
            }
            dropdownUnits.setSelection(pos);
        }
        if(!newStorageItem.getStorageMedium().equals(" ")){
            dropdownStorageMedium.setText(newStorageItem.getStorageMedium());
        }
        if(newStorageItem.getShelfLifeInMonths()!=0){
            if(newStorageItem.getShelfLifeInMonths()%12 == 0) {
                //if it is measured in years instead of months
                numberShelfLifeInMonths.setText(Integer.toString((newStorageItem.getShelfLifeInMonths()/12)));
                monthYearSpinner.setSelection(0);
            }
            else {
                //if it is measured in months instead of years
                numberShelfLifeInMonths.setText(Integer.toString(newStorageItem.getShelfLifeInMonths()));
                monthYearSpinner.setSelection(1);
            }
        }
        if(!newStorageItem.getTypeOfFood().equals(" ")){
            textFoodType.setText(newStorageItem.getTypeOfFood());
        }
        if(!newStorageItem.getLocation().equals(" ")){
            textLocation.setText(newStorageItem.getLocation());
        }
        if(!newStorageItem.getDateStored().toString().equals("1800-01-01")){
            //default initialized value is Jan 1, 1800, so if it is initialized use it
            //Local date does months from 1-12 but DatePicker does 0-11
            picker.init(newStorageItem.getDateStored().getYear(),
                    newStorageItem.getDateStored().getMonthValue()-1,
                    newStorageItem.getDateStored().getDayOfMonth(),
                    null);
        }

        //number of items to add/remove will not be sent to the activity, default to add 1
        numberNumberToAdd.setText("1");
        Log.i("OnCreate", "Finished assigning field variables");
    }

    //Constructor allowing for a StorageItem to be passed to the class
    public DataEntryForm(StorageItem startingData) {
        newStorageItem = startingData;
    }

    //Default constructor that creates a blank StorageItem to use
    @RequiresApi(api = Build.VERSION_CODES.O)
    public  DataEntryForm() {
        newStorageItem = new StorageItem();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void clickedAddButton(View view) throws ParseException {
        //gather the form data

        Log.i("OnClick", "starting On Click");

        //set up some default values to use if a field was left blank
        String foodName = "Some Random Food";
        Float containerSize = (float) 0.0;
        String unitOfMeasure = "oz";
        String storageMedium = "can";
        Integer shelfLife = 0;
        String monthYearChoice = "Months";
        String foodType = "food";
        String location = "somewhere";

        //convert the form data to forms that we can use
        //did checks to make sure data was entered in because it can crash the app otherwise
        if(textFoodName.getText().toString().length() > 0) {
            foodName = textFoodName.getText().toString();
        }
        if(numberUnitSize.getText().toString().length() > 0) {
            containerSize = Float.valueOf(numberUnitSize.getText().toString());
        }
        if(dropdownUnits.getSelectedItem().toString().length() > 0) {
            unitOfMeasure = dropdownUnits.getSelectedItem().toString();
        }
        if(dropdownStorageMedium.getText().toString().length() > 0) {
            storageMedium = dropdownStorageMedium.getText().toString();
        }
        if(numberShelfLifeInMonths.getText().toString().length() > 0) {
            shelfLife = Integer.parseInt(numberShelfLifeInMonths.getText().toString());
        }
        if(monthYearSpinner.getSelectedItem().toString().length() > 0) {
            monthYearChoice = monthYearSpinner.getSelectedItem().toString();
        }
        if(monthYearChoice.equals("Years")) {
            shelfLife = shelfLife * 12;
        }
        if(textFoodType.getText().toString().length() > 0) {
            foodType = textFoodType.getText().toString();
        }
        if(textLocation.getText().toString().length() > 0) {
            location = textLocation.getText().toString();
        }

        //DatePicker uses 0-11 but LocalDate uses 1-12.  This would not only give the wrong value
        //but cause the app to crash if the month was January.
        LocalDate dateToStore = LocalDate.of(picker.getYear(), picker.getMonth()+1, picker.getDayOfMonth());


        Log.i("foodName", foodName);
        Log.i("containerSize", containerSize.toString());
        Log.i("unitOfMeasure", unitOfMeasure);
        Log.i("storageMedium", storageMedium);
        Log.i("shelfLife", shelfLife.toString());
        Log.i("monthYearChoice", monthYearChoice);
        Log.i("foodType", foodType);
        Log.i("location", location);
        Log.i("stringDateStored", dateToStore.toString());
        Log.i("dateToStore", dateToStore.toString());

        //Set the data in the storage item class
        newStorageItem.setName(foodName);
        newStorageItem.setQuantity(containerSize);
        newStorageItem.setUnitOfMeasure(unitOfMeasure);
        newStorageItem.setStorageMedium(storageMedium);
        newStorageItem.setShelfLifeInMonths(shelfLife);
        newStorageItem.setTypeOfFood(foodType);
        newStorageItem.setLocation(location);
        //    newStorageItem.setDateStored(dateToStore);

        Log.i("Name", newStorageItem.getName());
        Log.i("Quantity", Float.toString(newStorageItem.getQuantity()));
        Log.i("Unit", newStorageItem.getUnitOfMeasure());
        Log.i("Medium", newStorageItem.getStorageMedium());
        Log.i("SLIM", Integer.toString(newStorageItem.getShelfLifeInMonths()));
        Log.i("TOF", newStorageItem.getTypeOfFood());
        Log.i("Loc", newStorageItem.getLocation());
        Log.i("Date", newStorageItem.getDateStored().toString());

        //add the items to the database
        String tempString = numberNumberToAdd.getText().toString();
        int numberToAdd = 0;
        if(tempString.length() < 0) {
            numberToAdd = Integer.parseInt(tempString);
        }

        if(numberToAdd <= 0) {
            numberToAdd = 1;
        }

        DataEntry itemToSave = new DataEntry(newStorageItem);
        for(int a = 0; a < numberToAdd; a++) {
            itemToSave.saveToDatabase();
        }

        Context context = getApplicationContext();
        CharSequence text = "Added " + numberToAdd + " item to the inventory";
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void clickedGenerageQr(View view) {
        //make the QR code from the storage item
        MakeQrCode newQrCode = new MakeQrCode(newStorageItem);
        Bitmap qrBitmap = newQrCode.getBitmap();
        Log.i("clickedGenerateQR", "made bitmap");
        Log.i("clickedGenerateQR", Integer.toString(qrBitmap.getByteCount()));

        //save the image
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File(root + "/QRCodes");
        myDir.mkdirs();
        String fname = newStorageItem.getName()
                + newStorageItem.getStorageMedium()
                + newStorageItem.getDateStored().toString()
                + ".jpg";
        Log.i("save", fname);
        File file = new File(myDir, fname);
        if(file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            qrBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("save", "done saving");

        // Tell the media scanner about the new file so that it is immediately available to the user
        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });

        Log.i("media scanner", "media scanner notified");
        Context context = getApplicationContext();
        CharSequence text = "Generated QR code image named " + fname;
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();

    }

    public void clickedScanCode(View view) {
        Log.i("clickedScan", "Start");

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");

        startActivityForResult(intent, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent resultData) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("on Result", "Uri: " + uri.toString());

                Context context = getApplicationContext();

                ScanBarCode thisCode = new ScanBarCode();
                String incoming = thisCode.fromFile(uri, context);
                StorageItem fromCode = new StorageItem();
                fromCode.fromString(incoming);

                //start a new activity with the data from the QR
                DataEntryForm newDataEntryFrom = new DataEntryForm();

                Intent intent = new Intent(this, newDataEntryFrom.getClass());
                Log.i("intent second form", fromCode.makeString());
                intent.putExtra(SIJSON, fromCode.makeString());
                startActivity(intent);

            }

        }
    }

    public void goToDashboard(View theButton) {
        Intent dashboardIntent = new Intent(this, Dashboard.class);
        startActivity(dashboardIntent);
    }
}