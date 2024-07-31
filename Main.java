package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        SimManager sim = new SimManager();

        //Customer Data Verification
        sim.loadCustomer();

        //Lane Data Verification
        sim.loadLaneData();

    }
}
