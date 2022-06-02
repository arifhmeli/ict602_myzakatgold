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
import android.widget.Toast;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
                Intent intent = new Intent(Help.this, Information.class);
                startActivity(intent);
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Zakat Calculator Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(Help.this, ZakatCalculator.class);
                startActivity(intent);
                return true;
            case R.id.menu3:
                Toast.makeText(this, "About Us Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(Help.this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.menu4:
                Toast.makeText(this, "Help Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(Help.this, Help.class);
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