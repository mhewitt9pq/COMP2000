package com.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class StockLoad {

    public String fileLocation = "Resources\\stock.txt";
    public String separator = "\\,";
    public final ArrayList<Item> stock = new ArrayList<>();

    public void loadFile(){
        try {
            File file = new File(fileLocation);

            Scanner scanner = new Scanner (file);

            while (scanner.hasNextLine()) {
                //Gets next line and stores as string
                String itemLine = scanner.nextLine();

                stock.add(getItem(itemLine));
            }
            scanner.close();

            System.out.println("File loaded");
        }
        catch (FileNotFoundException e){
            System.out.println("File not loaded");
            e.printStackTrace();
        }
    }
    public Item getItem(String Line)
    {
        Item tItem;
        String[] tArray = Line.split(separator);
        tItem = new Item(Integer.parseInt(tArray[0]), tArray[1], Integer.parseInt(tArray[2]), Float.parseFloat(tArray[3]));
        return tItem;

    }

}
