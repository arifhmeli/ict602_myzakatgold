package com.zakatapp.myzakat;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                openZakatCalculator();
            }
        });
    }

    public void openZakatCalculator(){
        Intent intent = new Intent(this, ZakatCalculator.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        int id = item.getItemId();
        //toast
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(this, "Information Page is selected.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Information.class);
                startActivity(intent);
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Zakat Calculator Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, ZakatCalculator.class);
                startActivity(intent);
                return true;
            case R.id.menu3:
                Toast.makeText(this, "About Us Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.menu4:
                Toast.makeText(this, "Help Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, Help.class);
                startActivity(intent);
                return true;
        }
                return super.onOptionsItemSelected(item);
        }
}
