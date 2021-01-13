package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import com.controller.menuController;

public class ICheckout {
    public JPanel mainPanel;
    private JButton btnCash;
    private JButton btnCard;
    private JButton btnPrint;
    private JButton btnBack;
    private JLabel lblCheckout;
    public JLabel lblTotal;
    private JLabel lblPaymentType;
    private JList lstCheckoutBasket;
    public JScrollPane scrollPane1;
    private JPanel panel1;
    //Creating a temporary list
    public JList tlstCheckoutBasket;

    File text = new File("Resources\\Stock.txt");

    public ICheckout(JList cartList, Float tTotal, JFrame kiosk, JFrame checkout){
        lstCheckoutBasket.setModel(cartList.getModel());


        tlstCheckoutBasket = cartList;

        //Setting total
        lblTotal.setText("£" + String.format("%.2f", tTotal));

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
                menuController.startKiosk(checkout);
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
                menuController.startKiosk(checkout);
            }
        });
    }
}
