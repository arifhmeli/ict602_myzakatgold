package com.zakatapp.myzakat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setupHyperlink();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // back arrow
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        //toast
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(this, "Information Page is selected.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboutUs.this, Information.class);
                startActivity(intent);
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Zakat Calculator Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(AboutUs.this, ZakatCalculator.class);
                startActivity(intent);
                return true;
            case R.id.menu3:
                Toast.makeText(this, "About Us Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(AboutUs.this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.menu4:
                Toast.makeText(this, "Help Page is selected.", Toast.LENGTH_SHORT).show();
                intent = new Intent(AboutUs.this, Help.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.youtube);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkTextView2 = findViewById(R.id.github);
        linkTextView2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // option menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}