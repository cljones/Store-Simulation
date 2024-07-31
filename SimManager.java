package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SimManager {
    public void loadCustomer() throws Exception {
        OrderedCustomerList orderList = new OrderedCustomerList();
        BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Owner\\Desktop\\Java_Projects\\StoreSimulation\\src\\com\\company\\customerData.txt"));
//        BufferedReader read = new BufferedReader(new FileReader("customerData.txt"));
        Customer customer;
        double arrivalTime;
        int orderSize;
        double itemSelectionTime;

        //Loading Customers
        System.out.println("\nCustomer Data");
        try{
            while(true){
                String str = read.readLine();
                String[] tokens = str.split("\t");

                arrivalTime = Double.parseDouble(tokens[0]);
                orderSize = Integer.parseInt(tokens[1]);
                itemSelectionTime = Double.parseDouble(tokens[2]);

                customer = new Customer(orderSize, itemSelectionTime, arrivalTime);
                orderList.insert(customer);

                //System.out.println("The first customer is: \n"+orderList.getNext()+"\n");

            }

        }catch(Exception e){

        } finally {
            read.close();
        }
        orderList.listDump();

    }

    public void loadLaneData(){
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Double> data = new ArrayList<>();
        ArrayList<Double> checkoutTimeListR = new ArrayList<>();
        ArrayList<Double> processTimeListR = new ArrayList<>();
        ArrayList<Double> checkoutTimeListE = new ArrayList<>();
        ArrayList<Double> processTimeListE = new ArrayList<>();

        int[] regLanes;
        int[] exLanes;

        //Reading in the lane data
        try {
            File file = new File("C:\\Users\\Owner\\Desktop\\Java_Projects\\StoreSimulation\\src\\com\\company\\CheckoutLanes.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                if(scanner.hasNextInt()){
                    int numbers = scanner.nextInt();
                    intList.add(numbers);

                } else{
                    double first = scanner.nextDouble();
                    double second = scanner.nextDouble();
                    data.add(first);
                    data.add(second);

                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        //Regular Lane Data fill
        int regNum = intList.get(0);
        int exNum = intList.get(1);


        for(int i = 0; i < regNum*2; i++){
            if(i%2==0){
                checkoutTimeListR.add(data.get(i));
            }else{
                processTimeListR.add(data.get(i));
            }
        }



        //Express Lane Data fill
        for(int i = regNum*2; i < data.size(); i++){
            if(i % 2 == 0){
                checkoutTimeListE.add(data.get(i));
            }else{
                processTimeListE.add(data.get(i));
            }
        }

        regLanes = new int[regNum];
        exLanes = new int[exNum];

        for(int i = 0; i<regNum; i++){
            regLanes[i]=i;
        }

        for(int i = 0; i<exNum; i++){
            exLanes[i]=i;
        }

//        for(int i = 0; i<regLanes.length; i++){
//            System.out.print(regLanes[i]);
//        }
//
//        System.out.println();
//
//        for(int i = 0; i<exLanes.length; i++){
//            System.out.print(exLanes[i]);
//        }

        //Lane creation
        System.out.println("\n"+regNum+"\nRegular Lane Event Times\nCheckout Times\t\tProcess Time");
        System.out.println(checkoutTimeListR+"\t"+processTimeListR);
        System.out.println(exNum+"\nExpress Lane Event Times\nCheckout Times\t\tProcess Time");
        System.out.println(checkoutTimeListE+"\t\t\t\t"+processTimeListE);
    }

    public void shoppingDoneEvent(){

    }

    public void checkoutDoneEvent(){

    }

//    public void runSimulation() throws Exception {
//        loadCustomer();
//        loadLaneData();
//
//    }
}
