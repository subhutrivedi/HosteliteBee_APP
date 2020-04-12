package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Add extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViewById(R.id.buttonH).setOnClickListener(this);
       // findViewById(R.id.buttonM).setOnClickListener(this);
        //findViewById(R.id.buttonL).setOnClickListener(this);
        //findViewById(R.id.buttonS).setOnClickListener(this);
        findViewById(R.id.buttonsignout).setOnClickListener(this);

        //FirebaseUser user = mFirebaseAuth.getCurrentUser();
        mFirebaseAuth = FirebaseAuth.getInstance();

        if (mFirebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainPage.class));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonH:
                //finish();
                startActivity(new Intent(this, SavingData.class));
                break;

            /*case R.id.buttonM:
                //finish();
                startActivity(new Intent(this, SavingData.class));
                break;

            case R.id.buttonL:
                //finish();
                startActivity(new Intent(this, SavingData.class));
                break;

            case R.id.buttonS:
                //finish();
                startActivity(new Intent(this, SavingData.class));
                break;*/

            case R.id.buttonsignout:
                finish();
                mFirebaseAuth.signOut();
                startActivity(new Intent(this,MainPage.class));
                break;
        }

    }
}
