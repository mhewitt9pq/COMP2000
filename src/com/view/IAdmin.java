package com.view;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

import com.model.Item;
public class IAdmin {

    public JPanel panel1;
    public JList lstStock;
    private JButton btnExit;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnAdd;
    public JPanel mainPanel;
    public JOptionPane popUpOption;
    public JFrame popUp = new JFrame();

    public String separator = "\\,";
    File text = new File("Resources\\Stock.txt");

    public IAdmin(JFrame aFrame, JList itemList)
    {
        lstStock.setModel(new DefaultListModel());

        //No close on the popup
        popUp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        loadData();
    }
    public void showAdmin()
    {
        JFrame frame = new JFrame("Admin");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    private void loadData()
    {

        Item newItem = new Item();
        //Loading stock from file
        newItem.loadFile();
        //Creating array of stock items
        Item[] tArray = new Item[0];
        tArray = newItem.stock.toArray(tArray);

        DefaultListModel lstModel = new DefaultListModel();

        int length = tArray.length;
        for (int i = 0; i < length; i++)

        {

            lstModel.addElement(tArray[i].getCode() +"," + tArray[i].getName() + "," + tArray[i].getPrice() + "," + tArray[i].getQuantity());
        }
        lstStock.setModel(lstModel);
    }

    public void addStock(){
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtQuantity = new JTextField();
        JTextField txtPrice = new JTextField();

        Object[] message = {
                "Item code:  ", txtCode,
                "Item Name:  ", txtName,
                "Stock:  ", txtQuantity,
                "Price:  £", txtPrice

        };

        int op = popUpOption.showConfirmDialog(popUp, message, "Add an item", JOptionPane.INFORMATION_MESSAGE);

        //If the option is yes
        if(op == popUpOption.OK_OPTION){
            //And if all fields are not empty
            if(txtCode != null && txtName != null && txtQuantity != null && txtPrice != null){
                //Add a new item passing through data in text fields
                addItem(txtCode.getText(), txtName.getText(), txtQuantity.getText(), txtPrice.getText());
                //Load file
                loadData();
                //Console message for testing
                System.out.println("Product added");
            }
            //Error handling
            else{
                popUpOption.showMessageDialog(popUp, "All information required!", "Attention", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //Error handling
        else{
            popUpOption.showMessageDialog(popUp, "Product addtion failed!" , "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Function to add an object with the attributes passed into it.
    public void addItem(String inCode, String inName, String inQuantity, String inPrice)
    {
        //Creating new item object
        Item newItem = new Item();

        //Loading data
        newItem.loadFile();

        //Creating adding attributes to new item using setters
        newItem.setCode(Integer.parseInt(inCode));
        newItem.setName(inName);
        newItem.setQuantity(Integer.parseInt(inQuantity));
        newItem.setPrice(inPrice);

        //Adding new item to stock
        newItem.addNewItem(newItem);

        //Saves the new item to the stock text file
    }
    public void updateFile(Item tempItem)
    {
        //Creating a temporary stock array to duplicate the items to store
        ArrayList<Item> tempStock = new ArrayList<>();

        //Setting the temp stock as the current stock of item passed in
        tempStock = tempItem.stock;
    }
}
