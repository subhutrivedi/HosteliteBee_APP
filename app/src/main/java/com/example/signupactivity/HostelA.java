package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HostelA extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel2);
        findViewById(R.id.buttonold).setOnClickListener(this);
        findViewById(R.id.buttonnew).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonold:
                startActivity(new Intent(this, Hostel.class));
                break;

            case R.id.buttonnew:
                startActivity(new Intent(this, NewHostel.class));
                break;
        }
    }
}
