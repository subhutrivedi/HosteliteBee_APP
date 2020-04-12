package com.example.signupactivity;

public class Product {

    private int id;
    private String title,shortdesc;
    private double rating;
    private int image;

    public Product(int id, String title, String shortdesc, double rating, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.image = image;
    }

    public Product(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    // public double getPrice() {
    //   return price;
    //}

    public int getImage() {
        return image;
    }
}
