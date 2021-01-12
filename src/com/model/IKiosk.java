package com.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IKiosk extends JFrame{

    private JPanel KioskPanel;
    private JTextField txtItemCode;
    private JButton btnScan;
    private JButton btnAddProduct;
    private JLabel lblCheckout;
    private JLabel lblStock;
    private JButton BtnAdminLogin;
    private JButton btnCheckout;
    private JLabel lblTotal;
    private JLabel lblBasket;
    private JList lstStock;
    private JList lstBasket;
    private JTextField txtAdminUsername;
    private JTextField txtAdminPass;

    File text = new File("Resources/Stock.txt");

    //Creating the array of stock items
    private ArrayList<Item> Stock = new ArrayList<>();


    public IKiosk() throws IOException {
        setContentPane(KioskPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        pack();
        StoreStock();


        btnScan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tCode = txtItemCode.getText();


            }
        });
    }


    public void StoreStock(){
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
            scanner.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error file not found");
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
