package com.controller;

import com.model.StockLoad;
import com.view.IKiosk;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IKiosk kiosk = new IKiosk();
        StockLoad stockLoad = new StockLoad();
        stockLoad.loadFile();

    }
}
