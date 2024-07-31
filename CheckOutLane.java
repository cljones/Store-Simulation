package com.company;

public class CheckOutLane {
    private double timeCheckoutItem;
    private double timeProcessPay;
    private double currWaiting;
    private double maxWaiting;
    private int totalCheckedOut;

    public CheckOutLane(double timeCheckoutItem, double timeProcessPay) throws Exception
    {
        if(timeCheckoutItem < 0 || timeProcessPay < 0)
            throw new Exception("Invalid time inputs");

        this.timeCheckoutItem = timeCheckoutItem;
        this.timeProcessPay = timeProcessPay;
    }

    //Getters
    public double getCurrentWaiting(){

        return currWaiting;
    }

    public double getMaxWaiting(){

        return maxWaiting;
    }

    public double getTotalCheckedout(){

        return totalCheckedOut;
    }

    //Methods for updating the statistics
    //addCustomer updates stats as emulation of adding
    //the customer to a checkout lane
    public void addCustomer(Customer c){



    }

    //removeCustomer updates stats as emulation of removing
    //customer from a checkout lane
    public void removeCustomer(Customer c){

    }

     public int avgNumWaiting(){
         return;
     }

     public double avgWaitTime(){
         return;
     }

    /**
     *
     * @return a formatted string containing all customer information
     */
    @Override
    public String toString() {
        return String.format("Reg:\t\t%d,\t\t\t\t\t%d,\t\t\t\t\t%3d, \t\t\t\t\t%3d\n"+
                "Exp:\t\t%d,\t\t\t\t\t%d,\t\t\t\t\t%3d, \t\t\t\t\t%3d\n");
    }
}
