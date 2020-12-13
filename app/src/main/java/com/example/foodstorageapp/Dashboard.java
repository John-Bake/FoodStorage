package com.example.foodstorageapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.time.Period;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Class and methods for the Dashboard screen
 *
 * The class is working only with static data for now, it will be calling data from
 * storageItem class and ExpireNotice class.
 *
 * Pending changes:
 * -Be able to pass data from the classes mentioned above.
 *
 * @author Ricardo Nunez
 * @version 1.0
 * @since 2020.11.28
 */


@RequiresApi(api = Build.VERSION_CODES.O)
public class Dashboard extends AppCompatActivity {

    private static String TAG = "DashboardActivity";


    TestData testData = new TestData(); //will be changed once I can get to use the database

    //StorageItem storageItem = new StorageItem(); //Calling from database

    public float[] yData = {25, 10, 48};
    //"More than 3 Months" - "Less than 3 Months" - "Less than 1 Month"
    public String[] xData = {"Grains", "Fruits", "Water"};
    PieChart pieChart;

    //counters to use on months calculation
    int greencounter = 0;
    int yellowcounter = 0;
    int redcounter = 0;

    //inventory list
    InventoryList greenInventory = new InventoryList();
    InventoryList yellowInventory = new InventoryList();
    InventoryList redInventory = new InventoryList();

    //array list for dates
    ArrayList<LocalDate> greenDates = new ArrayList<>();
    ArrayList<LocalDate> yellowDates = new ArrayList<>();
    ArrayList<LocalDate> redDates = new ArrayList<>();


    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.nav_activity_dashboard);
        Log.d(TAG, "onCreate: starting to create the chart");


        //Calculates the expiration date based on StoreDate from the user

        for (int i = 0; i < testData.testData.size(); i++) {
            LocalDate date = LocalDate.now();
            StorageItem item = testData.getOneItem(i); //it was StorageItem item = testData.getOneItem(i)
            int months = item.getShelfLifeInMonths();
            LocalDate storedDate = item.getDateStored();

            LocalDate expirationDate = storedDate.plusMonths(months);

            Period period = Period.between( date, expirationDate);

            long remainingMonths = period.toTotalMonths();

            //counts to find where in the pie chart lands, green, yellow or red
            // then adds the inventory item and adds the expiration date
            if (remainingMonths < 1){
                redcounter++;
                redInventory.addItem(item);
                redDates.add(expirationDate);
            }else if (remainingMonths >= 1 && remainingMonths < 3){
                yellowcounter++;
                yellowInventory.addItem(item);
                yellowDates.add(expirationDate);
            }else {
                greencounter++;
                greenInventory.addItem(item);
                greenDates.add(expirationDate);
            }

        }

        pieChart = (PieChart) findViewById(R.id.idPieChart);

        Log.d(TAG, "getStorageItem started");

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        pieChart.setRotationEnabled(true);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Food " + "\n" + "Expiration");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawEntryLabels(true);
        pieChart.setEntryLabelTextSize(20);
        pieChart.animateXY(3000, 3000);

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value Selected from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = h.toString().indexOf("x: ");
                Character label = h.toString().substring(pos1 + 3).charAt(0);
                String result = "";

                if (label == '0')
                {
                    // green pie slice
                    for (int i = 0; i < greenInventory.getSize(); i++) {
                        StorageItem item = greenInventory.getItem(i);
                        result += item.getName() + " " + item.getQuantity() +
                                " " + item.getUnitOfMeasure() + " Exp: " + greenDates.get(i);
                        result += "\n";
                    }
                }
                else if (label == '1')
                {
                    // yellow pie slice
                    for (int i = 0; i < yellowInventory.getSize(); i++) {
                        StorageItem item = yellowInventory.getItem(i);
                        result += item.getName() + " " + item.getQuantity() +
                                " " + item.getUnitOfMeasure() + " Exp: " + yellowDates.get(i);
                        result += "\n";
                    }
                }
                else
                {
                    // red pie slice
                    for (int i = 0; i < redInventory.getSize(); i++) {
                        StorageItem item = redInventory.getItem(i);
                        result += item.getName() + " " + item.getQuantity() +
                                " " + item.getUnitOfMeasure() + " Exp: " + redDates.get(i);
                        result += "\n";
                    }
                }

                TextView textView = (TextView) findViewById(R.id.showdata);
                textView.setText(result);

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }


    private void addDataSet() {
        Log.d(TAG,"addDataSet started");

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        yEntrys.add(new PieEntry(greencounter, 0));
        yEntrys.add(new PieEntry(yellowcounter, 1));
        yEntrys.add(new PieEntry(redcounter, 2));

        xEntrys.add("More than 3 Months");
        xEntrys.add("Less than 3 Months & more than 1 Month");
        xEntrys.add("Less than 1 Month");

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Chart");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);
        pieDataSet.setDrawValues(false);

        //color for dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN); // expires more than 3 months
        colors.add(Color.YELLOW); //expires in less than 3 month but > than 1 month
        colors.add(Color.RED);  // expires in less than 1 month

        pieDataSet.setColors(colors);

        //add the legend to the chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }
}
