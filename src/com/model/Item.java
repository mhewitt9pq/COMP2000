package com.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Item {

    private String name;

    private int code;

    private int quantity;

    private double price;


    public Item (int inCode, String inName, int inQuantity, double inPrice){
        this.name = inName;
        this.code = inCode;
        this.quantity = inQuantity;
        this.price = inPrice;

    }

    //Method to get all info about item excluding the code and return as string. To display on the kiosk.
    public String allInfo()
    {
        String info = new String (name + " £" + price + " (" + quantity + " in stock)" );
        return info;
    }

    public String basketInfo(){
        String basketInfo = new String (name + " £" + price);
        return basketInfo;
    }

    //Getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String inName){
        this.name = inName;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int inQuantity){
        this.quantity = inQuantity;
    }

    public int getCode(){
        return this.code;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double inPrice){
        this.price = inPrice;
    }
}
