package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth mFirebaseAuth;
    Button buttonl;
    ImageButton imgA;
    ImageButton imgB;
    ImageButton imgC;
    ImageButton imgD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imgA = (ImageButton) findViewById(R.id.imgbuttonA);
        imgA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintentA = new Intent(ProfileActivity.this, HostelA.class);
                startActivity(myintentA);
            }
        });

        imgB = (ImageButton) findViewById(R.id.imgbuttonB);
        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintentB = new Intent(ProfileActivity.this, Mess.class);
                startActivity(myintentB);
            }
        });

        imgC = (ImageButton) findViewById(R.id.imgbuttonC);
        imgC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintentC = new Intent(ProfileActivity.this, Laundry.class);
                startActivity(myintentC);
            }
        });

        imgD = (ImageButton) findViewById(R.id.imgbuttonD);
        imgD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintentD = new Intent(ProfileActivity.this, Stationary.class);
                startActivity(myintentD);
            }
        });
        mFirebaseAuth = FirebaseAuth.getInstance();

        if (mFirebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainPage.class));
        }

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        buttonl = (Button) findViewById(R.id.button);
        buttonl.setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {
        if(view == buttonl) {
            mFirebaseAuth.signOut();
            startActivity(new Intent(this, MainPage.class));
        }
     }
}




