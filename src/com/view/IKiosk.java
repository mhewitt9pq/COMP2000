package com.view;

import com.model.Item;
import com.model.StockLoad;

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

    File text = new File("Resources\\Stock.txt");

    //Creating the array of stock items
    private ArrayList<Item> Stock = new ArrayList<>();

    public IKiosk() throws IOException {
        setContentPane(KioskPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        pack();

        btnScan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tCode = txtItemCode.getText();

            }
        });
    }

}
