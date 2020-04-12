package com.example.signupactivity;

public class SavingProduct {

    private String AddAddress, AddContact, AddAmenities, Addimg;
   // private double price;
    //private int qty;

    public SavingProduct(){

    }

    public SavingProduct(String AddAddress, String AddContact, String AddAmenities, String Addimg) {
        this.AddAddress = AddAddress;
        this.AddContact = AddContact;
        this.AddAmenities = AddAmenities;
        this.Addimg = Addimg;
        //this.qty = qty;
    }

    public String getAddAddress() {
        return AddAddress;
    }

    public String getAddContact() {
        return AddContact;
    }

    public String getAddAmenities() {
        return AddAmenities;
    }

    public String getAddimg() {
        return Addimg;
    }

}
