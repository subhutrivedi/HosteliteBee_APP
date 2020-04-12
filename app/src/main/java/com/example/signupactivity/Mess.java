package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Mess extends AppCompatActivity {

    RecyclerView recyclerView;
    MproductAdapter adapter;

    List<MProduct> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);
        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new MProduct(
                        1,
                        "Aangan Veg Restaurant",
                        "Variety of delicious vegeterian dishes are here!!                        ",
                        4.0,
                        R.drawable.aanganvegrestaurant
                ));

        productList.add(
                new MProduct(
                        1,
                        "Food Planet",
                        "Veg and Non-Veg lovers visit here!!                                       ",
                        4.2,
                        R.drawable.foodplanet
                ));

        productList.add(
                new MProduct(
                        1,
                        "Radha Krushna Restaurant",
                        "Delicious North-Indian dishes for North-Indians!                           ",
                        4.0,
                        R.drawable.radhakrushnamess
                ));


        productList.add(
                new MProduct(
                        1,
                        "Rolls Mania",
                        "Famous for Indo-Chinese dishes!                                            ",
                        4.1,
                        R.drawable.rollsmaniamess
                ));

        productList.add(
                new MProduct(
                        1,
                        "Tirangi-Rassa-Misal                                                             ",
                        "Delicious Rajasthani dishes are here!",
                        3.9,
                        R.drawable.tirangirassamisal

                ));

        adapter = new MproductAdapter(this , productList);
        recyclerView.setAdapter(adapter);
    }
}

