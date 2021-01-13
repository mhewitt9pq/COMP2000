package com.controller;

import com.view.IKiosk;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        menuController kiosk = new menuController();
        menuController.startKiosk(kiosk.oldFrame);
    }
}
