package com.zakatapp.myzakat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ZakatCalculator extends AppCompatActivity{

    EditText inputWeight, inputType, inputValue;
    Button calculateButton;
    TextView totalGold, zakatPayable, goldValue, totalZakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        inputWeight=(EditText)findViewById(R.id.inputWeight);
        inputType=(EditText)findViewById(R.id.inputType);
        inputValue=(EditText)findViewById(R.id.inputValue);

        totalGold=(TextView) findViewById(R.id.totalGold);
        zakatPayable=(TextView) findViewById(R.id.zakatPayable);
        goldValue=(TextView) findViewById(R.id.goldValue);
        totalZakat=(TextView) findViewById(R.id.totalZakat);

        calculateButton= (Button) findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (inputWeight.getText().toString().isEmpty() || inputType.getText().toString().isEmpty()
                || inputValue.getText().toString().isEmpty()) {
                    Toast.makeText(v.getContext(), "Please insert all the value required.",Toast.LENGTH_SHORT).show();
                }
                else {
                double weight = Double.parseDouble(inputWeight.getText().toString());
                double type = 0;
                double value = Double.parseDouble(inputValue.getText().toString());

                if (inputType.getText().toString().equals("keep") || inputType.getText().toString().equals("Keep")){
                    type = 85;
                }
                else if (inputType.getText().toString().equals("wear") || inputType.getText().toString().equals("Wear")){
                    type = 200;
                }
                else {
                    Toast.makeText(v.getContext(), "The type of gold is not valid.",Toast.LENGTH_SHORT).show();
                }

                double resultTotalGold = weight * value;
                double resultValueGold = weight - type;
                double resultZakatPayable = resultValueGold * value;
                double resultTotalZakat = resultZakatPayable * 0.025;

                totalGold.setText("RM " + new DecimalFormat("##.##").format(resultTotalGold));
                zakatPayable.setText("RM " + new DecimalFormat("##.##").format(resultZakatPayable));
                goldValue.setText(new DecimalFormat("##.##").format(resultValueGold) + " grams");
                totalZakat.setText("RM " + new DecimalFormat("##.##").format(resultTotalZakat));
                totalGold.setVisibility(View.VISIBLE);
                zakatPayable.setVisibility(View.VISIBLE);
                goldValue.setVisibility(View.VISIBLE);
                totalZakat.setVisibility(View.VISIBLE);
            }
        }

    });

}


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        //toast
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(this, "Information Page is selected.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ZakatCalculator.this, Information.class);
                startActivity(intent);
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Zakat Calculator Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(ZakatCalculator.this, ZakatCalculator.class);
                startActivity(intent);
                return true;
            case R.id.menu3:
                Toast.makeText(this, "About Us Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(ZakatCalculator.this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.menu4:
                Toast.makeText(this, "Help Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(ZakatCalculator.this, Help.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}