package com.example.foodstorageapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private static String TAG = "DashboardActivity";

    private float[] yData = {25, 10, 48};
    private String[] xData = {"Grains", "Fruits", "Water"};
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dashboard);
        Log.d(TAG, "onCreate: starting to create the chart");

//        String StorageItem;
//        String unitOfMeasure;
//        float quantity;
//        String typeOfFood;

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

        // I can add more options, see documentation
        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value Selected from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("y: ");
                String food = e.toString().substring(pos1 + 3);

                for (int i = 0; i < yData.length; i++) {
                    if (yData[i] == Float.parseFloat(food)) {
                        pos1 = i;
                        break;
                    }
                }
                String foodtype = xData[pos1];
//                Toast.makeText(Dashboard.this, "Food Type " + foodtype + "\n" + "Quantity: " +
//                        food + " lb", Toast.LENGTH_LONG).show();

                TextView textView = (TextView) findViewById((R.id.showdata));
                textView.setText(("Food Type: " + foodtype + "\n" + "Quantity: " +
                            food + " lb." + "\n" + "Expiration Date: " + "01/15/2021"));

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

        for (int i = 0; i < yData.length; i++) {
            yEntrys.add(new PieEntry(yData[i], i));
        }

        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Food Type ");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

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

//        void getStorageItem () {
//        }
//
//        void getQuantity () {
//        }
//
//        void getTypeOfFood () {
//        }
//
//        void getExpireNotices () {
//        }

}
