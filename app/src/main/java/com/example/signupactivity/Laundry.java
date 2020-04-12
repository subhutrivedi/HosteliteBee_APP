package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Laundry extends AppCompatActivity {

    RecyclerView recyclerView;
    LProductAdapter adapter;

    List<LProduct> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary);
        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new LProduct(
                        1,
                        "Smart Laundry                                                                    ",
                        "Opens: 10:00AM                           " +
                                "Closes: 10:00PM",
                        4.1,
                        //60000,
                        R.drawable.smartlaundary));

        productList.add(
                new LProduct(
                        1,
                        "R.K Drycleaners",
                        " 24/7 availabilty                                                               ",
                        3.9,
                        //60000,
                        R.drawable.rkdrycleaners));

        productList.add(
                new LProduct(
                        1,
                        "Express Laundromat                                                                     ",
                        " Opens: 8:00AM                              " +
                                "Closes: 10:00PM                              ",
                        4.5,
                        //60000,
                        R.drawable.epresslaundromat));


        productList.add(
                new LProduct(
                        1,
                        "Jay Drycleaners",
                        "Washing and Drycleaning of all types of clothes                                    ",
                        4.0,
                        //60000,
                        R.drawable.jaydrycleaners));

        adapter = new LProductAdapter(this , productList);
        recyclerView.setAdapter(adapter);
    }
}
