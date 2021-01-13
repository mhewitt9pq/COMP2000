package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import com.controller.menuController;

public class ICheckout {
    public JPanel mainPanel;
    private JList lstCheckoutBasket;
    private JButton btnCash;
    private JButton btnCard;
    private JButton btnPrint;
    private JButton btnBack;
    private JLabel lblCheckout;
    private JLabel lblTotal;
    private JLabel lblPaymentType;

    File text = new File("Resources\\Stock.txt");

    public ICheckout(JList lstBasket, Float total, JFrame kiosk, JFrame checkout){




        //Adding back button function
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.startKiosk(checkout);
            }
        });

    }
}
