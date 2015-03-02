package com.juanlabrador.datepickerwheel;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.juanlabrador.library.WheelDatePicker;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private Button mButton;
    private WheelDatePicker mDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.datepickerwheel);
                mDatePicker.setLocale(new Locale("es", "ES"));
                mDatePicker.setVisibleItems(5);
                mDatePicker.setMinMaxYears(1970, 2015);
                mDatePicker = (WheelDatePicker) dialog.findViewById(R.id.datepicker);
                mDatePicker.setDay(10);
                mDatePicker.setMonth(8);
                mDatePicker.setYear(2013);
                mDatePicker.addDateChangedListener(new WheelDatePicker.IDateChangedListener() {
                    @Override
                    public void onChanged(WheelDatePicker sender, int oldDay, int oldMonth, int oldYear, int day, int month, int year) {

                        Toast.makeText(getApplicationContext(), "Date: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
