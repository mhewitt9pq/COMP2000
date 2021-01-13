package com.controller;

import com.model.Item;
import com.view.IKiosk;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        menuController kiosk = new menuController();
        menuController.startKiosk(kiosk.oldFrame);
    }
}
