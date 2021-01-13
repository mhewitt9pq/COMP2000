package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import com.controller.menuController;

public class ICheckout {
    public JPanel mainPanel;
    private JButton btnCash;
    private JButton btnCard;
    private JButton btnPrint;
    private JButton btnBack;
    private JLabel lblCheckout;
    public JLabel lblTotalTxt;
    private JLabel lblPaymentType;
    private JList lstCheckoutBasket;
    public JScrollPane scrollPane1;
    private JPanel panel1;
    private JLabel lblTotal;
    //Creating a temporary list
    public JList tlstCheckoutBasket;
    public JOptionPane checkoutPopup;
    Float tCash = 0.00f;
    Float change = 0.00f;
    String receipt;

    File text = new File("Resources\\Stock.txt");

    public ICheckout(JList cartList, Float tTotal, JFrame kiosk, JFrame checkout)
    {
        lstCheckoutBasket.setModel(cartList.getModel());


        tlstCheckoutBasket = cartList;

        //Setting total
        lblTotalTxt.setText("£" + String.format("%.2f", tTotal));

        //Adding back button function
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.startKiosk(checkout);
            }
        });

        //Functionality for the print receipt button
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                printReceipt();

            }
        });

        //Functionality for the card payment option
        btnCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.startKiosk(checkout);
            }
        });

        //Functionality for the cash payment option
        btnCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashPayment();
            }
        });
    }
    //Cash payment
    public void cashPayment()
    {
        Float tTotal = 0.00f;

        //Create popup for cash input
        JFrame cashPopup = new JFrame();

        cashPopup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Storing the cash inputted in the temporary cash variable

        tCash = Float.parseFloat(checkoutPopup.showInputDialog(cashPopup, "Please enter Cash: "));

        //Storing the temporary total from the label in the string variable
        String tSTotal = lblTotalTxt.getText();

        //Need to just get the number from the total string (same method as updateTotal on kiosk)
        tSTotal = tSTotal.replace("£", "");
        tTotal = Float.parseFloat(tSTotal);

        //If statement to check they entered right amount
        if (tCash >= tTotal) {
            change = tCash - tTotal;
            receipt = "Brandon's Bananas & More \n" +
                    "Date: " +
                    "Time: " +
                    "Receipt: \n" +
                    "Items: " + lstCheckoutBasket.getModel().toString() + "\n" +
                    "Total: " + lblTotalTxt.getText() + "\n" +
                    "Cash given: £" + tCash + "\n" +
                    "Change: " + (String.format("£" + "%.2f",change));
        } else {
            checkoutPopup.showMessageDialog(cashPopup, "Not enough money. Please enter more");
        }
    }
    public void printReceipt()
    {

        JFrame popUpFrame = new JFrame();
        popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        checkoutPopup.showMessageDialog(popUpFrame, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

}

