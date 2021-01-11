package com.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class StoreStock {

    //Storing the file location
    File text = new File("/Resources/Stock.txt");

    //Creating the array of stock items
    private ArrayList<Item> Stock = new ArrayList<>();


    public StoreStock(){
        addStock();
    }

    private void addStock()
    {
        //Using the scanner to read the data in the file
        try (Scanner scanner = new Scanner(text)){
            //While there is a line found in the file
            while (scanner.hasNextLine())
            {
                //Getting each item generated and storing it in the arraylist
                Stock.add(getItem(scanner.nextLine()));

            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error");
        }
    }

    private Item getItem(String Line)
    {
        //Creating temporary item
        Item tItem;
        //Creating temp array to store object attributes
        //Setting the value splitter as a comma
        String[] tArray = Line.split(",");
        //Stores each value on the line as an attribute of the temp object. Does some conversions to appropriate data type.
        tItem = new Item(tArray[0], Integer.parseInt(tArray[1]), Integer.parseInt(tArray[2]), Float.parseFloat(tArray[3]));
        //Returns the temporary object
        return tItem;

    }

}
