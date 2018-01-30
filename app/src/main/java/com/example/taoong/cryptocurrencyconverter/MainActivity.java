package com.example.taoong.cryptocurrencyconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button btnConvert;
    private TextView USDvalue, BTCvalue, DOGEvalue;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();
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

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        USDvalue = (TextView) findViewById(R.id.USDvalue);
        BTCvalue = (TextView) findViewById(R.id.BTCvalue);
        DOGEvalue = (TextView) findViewById(R.id.DOGEvalue);

        btnConvert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String currency = spinner.getSelectedItem().toString();
                Double value = Double.parseDouble(editText.getText().toString());
                if (currency.equals("USD")) {
                    USDvalue.setText(Double.toString(value));
                    BTCvalue.setText(Double.toString(value * 0.000091));
                    DOGEvalue.setText(Double.toString(value * 141));
                } else if (currency.equals("BTC")) {
                    USDvalue.setText(Double.toString(value * 11049.00));
                    BTCvalue.setText(Double.toString(value));
                    DOGEvalue.setText(Double.toString(value * 1630663.68 ));
                } else if (currency.equals("DOGE")) {
                    USDvalue.setText(Double.toString(value * 0.0068));
                    BTCvalue.setText(Double.toString(value * 0.0000006));
                    DOGEvalue.setText(Double.toString(value));
                }
            }

        });
    }
}
