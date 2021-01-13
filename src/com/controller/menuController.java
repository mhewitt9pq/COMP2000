package com.controller;

import javax.swing.*;
import com.view.IKiosk;
import com.model.*;
import com.view.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class menuController{

    public JFrame oldFrame;

    public static void startKiosk(JFrame oldFrame){
        JFrame kiosk = new JFrame("KioskView");
        kiosk.setContentPane(new IKiosk(kiosk, oldFrame).KioskPanel);
        kiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kiosk.setSize(500, 500);
        kiosk.setVisible(true);
        oldFrame.setVisible(false);

        Item data = new Item();
        data.loadFile();
    }
    public static void startAdmin(JFrame kiosk, JList lstStock){
        JFrame aFrame = new JFrame("AdminView");
        aFrame.setContentPane(new IAdmin(aFrame, lstStock).panel1);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setSize(500, 500);
        aFrame.setVisible(true);
        kiosk.setVisible(false);
    }





    //Function uses switch/case statement to switch between pages with the name of the page being the case.
//    public static void pageSetup(String inName) throws IOException
//    {
//        switch (inName)
//        {
//            case "IKiosk":
//                kioskView = new IKiosk();
//                break;
//        }
//    }
//    //Function to actually change the page using the switch statement
//    public static void pageChange(JFrame currentPage, JFrame nextFrame){
//        //Hiding the current page
//        currentPage.setVisible(false);
//        //Setting position of next page to same as current one
//        nextFrame.setLocation(currentPage.getLocation());
//        //Making next page visible
//        nextFrame.setVisible(true);
//        //Getting rid of the current page
//        currentPage.dispose();
//    }

}
