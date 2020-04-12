package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Stationary extends AppCompatActivity {

    RecyclerView recyclerView;
    SProductAdapter adapter;

    List<SProduct> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary);
        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new SProduct(
                        1,
                        "Regal Stationery",
                        "Engineering,Medical Books are available                                       ",
                        4.0,
                        //60000,
                        R.drawable.regalstationers));

        productList.add(
                new SProduct(
                        1,
                        "S.P Stationers",
                        "24/7 stationery is available                                                  ",
                        4.3,
                        //60000,
                        R.drawable.spstationers));

        productList.add(
                new SProduct(
                        1,
                        "Sirvi Stationery",
                        "All kind of stationery is available                                          ",
                        4.8,
                        //60000,
                        R.drawable.sirvistationary));


        productList.add(
                new SProduct(
                        1,
                        "Lalit Stationery",
                        "All kind of stationery is available                                              ",
                        4.0,
                        //60000,
                        R.drawable.lalitstationery));

        productList.add(
                new SProduct(
                        1,
                        "Metro Stationers",
                        "All kind of stationery is available                                              ",
                        4.1,
                        R.drawable.metrostationers
                )
        );

        adapter = new SProductAdapter(this , productList);
        recyclerView.setAdapter(adapter);
    }
}
