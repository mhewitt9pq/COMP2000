package com.view;

import javax.swing.*;
import java.io.File;
import com.model.Item;
public class IAdmin {

    public JPanel panel1;
    public JList lstStock;
    private JButton btnExit;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnAdd;
    public JPanel mainPanel;

    public JFrame popUp = new JFrame();

    public String separator = "\\,";
    File text = new File("Resources\\Stock.txt");

    public IAdmin(JFrame aFrame, JList itemList) {

        lstStock.setModel(new DefaultListModel());

        //No close on the popup
        popUp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        loadData();
    }
    public void showAdmin(){
        JFrame frame = new JFrame("Admin");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    private void loadData(){

        Item newItem = new Item();
        //Loading stock from file
        newItem.loadFile();
        //Creating array of stock items
        Item[] tArray = new Item[0];
        tArray = newItem.stock.toArray(tArray);

        DefaultListModel lstModel = new DefaultListModel();

        int length = tArray.length;
        for (int i = 0; i < length; i++){

            lstModel.addElement(tArray[i].getCode() +"," + tArray[i].getName() + "," + tArray[i].getPrice() + "," + tArray[i].getQuantity());
        }
        lstStock.setModel(lstModel);
    }


}
