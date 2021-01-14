package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import com.controller.menuController;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
                cardPayment();
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

    //Card paymnt
    public void cardPayment()
    {
        //Defining values and setting formats for the datetime on receipt
        Float tTotal = 0.00f;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //Create popup for cash input
        JFrame cardPopup = new JFrame();
        cardPopup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Creating pane message and title
        int yesNo = checkoutPopup.showConfirmDialog(cardPopup, "Card verification", "Security", JOptionPane.INFORMATION_MESSAGE);
        if(yesNo==JOptionPane.YES_OPTION)
        {
            checkoutPopup.showMessageDialog(cardPopup, "Card Verified!", "Security" , JOptionPane.INFORMATION_MESSAGE);
            receipt = "----------Tescos---------- \n" +
                    "Date and Time:  " + dtf.format(now) + "\n" +
                    "Basket:  " + lstCheckoutBasket.getModel().toString() + "\n" +
                    "Total:  " + lblTotalTxt.getText() + "\n" +
                    "Card payment verified" + "\n" +
                    "Have a nice day :)";
        }
        else
        {
            checkoutPopup.showMessageDialog(cardPopup, "Card not verified. Please try again");
        }


    }

    //Cash payment
    public void cashPayment()
    {
        //Defining values and setting formats for the datetime on receipt
        Float tTotal = 0.00f;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

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
            //Calculate change
            change = tCash - tTotal;
            //Storing receipt with relevant info to be used later
            receipt = "----------Tescos---------- \n" +
                    "Date and Time:  " + dtf.format(now) + "\n" +
                    "Basket:  " + lstCheckoutBasket.getModel().toString() + "\n" +
                    "Total:  " + lblTotalTxt.getText() + "\n" +
                    "Amount paid:  £" + tCash + "\n" +
                    "Change:  " + (String.format("£" + "%.2f",change)) + "\n" +
                    "Have a nice day :)";
        }
        else
        {
            checkoutPopup.showMessageDialog(cashPopup, "Not enough money. Please enter more");
        }
    }
    public void printReceipt()
    {
        JFrame popFrame = new JFrame();
        popFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        checkoutPopup.showMessageDialog(popFrame, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

}

