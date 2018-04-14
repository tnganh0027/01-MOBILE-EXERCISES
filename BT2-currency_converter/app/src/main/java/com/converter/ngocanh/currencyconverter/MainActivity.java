package com.converter.ngocanh.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.converter.ngocanh.currencyconverter.exch.CurrencyExchanger;
import com.converter.ngocanh.currencyconverter.model.SpinnerItem;
import com.converter.ngocanh.currencyconverter.util.FileHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner fromSpinner;
    private Spinner toSpinner;

    private ArrayList<SpinnerItem> spinnerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        spinnerItems = FileHandler.getSpinnerItems(this);

        loadDataToSpinners();
        setSpinnersOnClickListeners();
        decrementFirstItem();

        final TextView resultView = (TextView) findViewById(R.id.resultView);
        final EditText editAmount = (EditText) findViewById(R.id.editAmount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = spinnerItems.get(fromSpinner.getSelectedItemPosition()).getCurrencySymbol();
                String to = spinnerItems.get(toSpinner.getSelectedItemPosition()).getCurrencySymbol();
                new CurrencyExchanger(MainActivity.this, resultView, editAmount).execute(from + to);
            }
        });
    }

    private void loadDataToSpinners() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getCurrencySymbols());
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(spinnerArrayAdapter);
        toSpinner.setAdapter(spinnerArrayAdapter);
    }

    private ArrayList<String> getCurrencySymbols() {
        sortSpinnerItemsByTimesUsed();

        ArrayList<String> symbols = new ArrayList<>();
        for (SpinnerItem item : spinnerItems)
            symbols.add(item.getCurrencySymbol());

        return symbols;
    }

    private void sortSpinnerItemsByTimesUsed() {
        Collections.sort(spinnerItems, new Comparator<SpinnerItem>() {
            @Override
            public int compare(SpinnerItem one, SpinnerItem two) {
                return two.getTimesUsed() - one.getTimesUsed();
            }
        });
    }

    private void setSpinnersOnClickListeners() {
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerItems.get(position).increment();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        fromSpinner.setOnItemSelectedListener(onItemSelectedListener);
        toSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void decrementFirstItem() {
        // Without it "timesUsed" value in SpinnerItem would
        // increment every time application is launched
        spinnerItems.get(0).decrement();
        spinnerItems.get(0).decrement();
    }

    @Override
    protected void onPause() {
        FileHandler.saveSpinnerItems(this, spinnerItems);

        super.onPause();
    }

}
