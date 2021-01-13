package com.view;

import com.model.Item;
import com.view.IAdmin;
import com.controller.menuController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IKiosk extends JFrame{

    public JPanel mainPanel;
    private JTextField txtItemCode;
    private JButton btnScan;
    private JButton btnAddProduct;
    private JLabel lblCheckout;
    private JLabel lblStock;
    private JButton btnAdmin;
    private JButton btnCheckout;
    private JLabel lblTotal;
    private JLabel lblBasket;
    private JList lstStock;
    private JList lstBasket;
    public JOptionPane popup;

    File text = new File("Resources\\Stock.txt");

    //Creating the array of stock items
    private ArrayList<Item> Stock = new ArrayList<>();

    public IKiosk(JFrame kiosk, JFrame next) {

        btnScan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tCode = txtItemCode.getText();

            }
        });
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(kiosk, lstStock);
            }
        });
    }

    public void login(JFrame kiosk, JList stockList){
        JFrame popUp = new JFrame();
        popUp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JTextField txtUser = new JTextField();
        //Storing password as string in normal text as isnt recognised for some reason as a password variable.
        JTextField txtPassword = new JPasswordField();

        //Defining the login credentials
        String username = "admin";

        String password = "admin123";

        Object[] message = {
                "Username:", txtUser,
                "Password:", txtPassword,
        };

        int op = popup.showConfirmDialog(popUp, message, "Admin Login", JOptionPane.OK_CANCEL_OPTION);


        if(op == popup.OK_OPTION){
            if(txtUser.getText().equals(username) && txtPassword.getText().equals(password))
            {
                popup.showMessageDialog(popUp, "Admin Login Correct.", "Admin Login", JOptionPane.INFORMATION_MESSAGE);
                menuController.startAdmin(kiosk, lstStock);
            }
            else
            {
                popup.showMessageDialog(popUp, "Admin Login Failed", "Admin Login", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            popup.showMessageDialog(popUp, "Admin Login Failed.", "Admin Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
