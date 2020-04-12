package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public  class MainPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        findViewById(R.id.buttonAdmin).setOnClickListener(this);
        findViewById(R.id.buttonUser).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAdmin:
                //finish();
                startActivity(new Intent(this, AdminLogin.class));
                break;

            case R.id.buttonUser:
                //finish();
                startActivity(new Intent(this, UserLogin.class));
                break;
        }
    }
}