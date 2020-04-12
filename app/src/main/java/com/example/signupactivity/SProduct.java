package com.example.signupactivity;

public class SProduct {

    private int id;
    private String title,shortdesc;
    private double rating;
    //private double price;
    private int image;

    public SProduct(int id, String title, String shortdesc, double rating, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        //this.price = price;
        this.image = image;
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
