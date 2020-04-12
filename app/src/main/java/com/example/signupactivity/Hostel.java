package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Hostel extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel);

        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new Product(
                        1,
                        "Bharati Vidyapeeth Old Ladies Hostel                                     ",
                        "Only for Bharati Students",
                        4.0,
                        R.drawable.bharatihostel)
        );

        productList.add(
                new Product(
                        1,
                        "S.K Boys Hostel                                                            ",
                        "Open for all Boys",
                        3.8,
                        R.drawable.skboys)
        );

        productList.add(
                new Product(
                        1,
                        "Bharati Vidyapeeth New Girls Hostel                                       ",
                        "Open for all",
                        4.5,
                        R.drawable.girlsnewhostel)
        );


        productList.add(
                new Product(
                        1,
                        "Shraddha Niketan Girls Hostel                                             ",
                        "Open for all",
                        4.3,
                        R.drawable.shradhaniketan)
        );

        productList.add(
                new Product(
                        1,
                        "Bharati Vidyapeeth Medical College Boys Hostel                              ",
                        "Only for Medical Students       " ,
                        4.8,
                        R.drawable.medicalhostel
                )
        );

        adapter = new ProductAdapter(this , productList);
        recyclerView.setAdapter(adapter);
    }
}


