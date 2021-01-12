package com.controller;

import javax.swing.*;
import com.view.IKiosk;
import com.model.Item;

import java.io.FileNotFoundException;
import java.io.IOException;

public class menuController {
    public JFrame oldFrame;
    public static void openKiosk() throws IOException {

        Item data = new Item();
        data.loadFile();
    }
}
