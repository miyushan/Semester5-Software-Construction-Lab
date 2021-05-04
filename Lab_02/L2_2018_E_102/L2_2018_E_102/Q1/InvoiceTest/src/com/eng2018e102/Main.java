package com.eng2018e102;

/**
 * Author: 2018/E/102
 */

/**
 * This class is used to get values of the application data and invoice imount
 */
class Invoice{
    private String number;
    private String description;
    private int quantity;
    private double prizePItem;

    //constructor
    Invoice(){
        number = "aA72021";
        description = "Exercise book";
        quantity = 3;
        prizePItem = 48.50;
    }

    //setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrizePItem(double prizePItem) {
        this.prizePItem = prizePItem;
    }


    //getters
    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrizePItem() {
        return prizePItem;
    }

    public String getNumber() {
        return number;
    }

    //use to get invoice amount
    public double getInvoiceAmount(){
        if(quantity<0){
            quantity = 0;
        }
        if(prizePItem<0){
            prizePItem = 0;
        }
        return quantity*prizePItem;
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println("\nFrom Constructor");
        Invoice piece1 = new Invoice();
        //check the results for the constructor
        System.out.println("Description:\t"+piece1.getDescription());
        System.out.println("Quantity:\t"+piece1.getQuantity());
        System.out.println("Prize per item:\t"+piece1.getPrizePItem());
        System.out.println("Number:\t"+piece1.getNumber());
        System.out.println("InvoiceAmount:\t"+piece1.getInvoiceAmount());


        System.out.println("\nFrom Input values");
        Invoice piece2 = new Invoice();
        //give values for the data
        piece2.setNumber("bB72019");
        piece2.setDescription("A pen");
        piece2.setQuantity(2);
        piece2.setPrizePItem(22);
        System.out.println("Description: \t"+piece2.getDescription());
        System.out.println("Quantity:\t"+piece2.getQuantity());
        System.out.println("Prize per item:\t"+piece2.getPrizePItem());
        System.out.println("Number:\t"+piece2.getNumber());
        System.out.println("InvoiceAmount:\t"+piece2.getInvoiceAmount());


        System.out.println("\nCheck errors");
        Invoice piece3 = new Invoice();
        //Check errors
        piece3.setNumber("cC72020");
        piece3.setDescription("Pencil");
        piece3.setQuantity(-2);
        piece3.setPrizePItem(15.7);
        System.out.println("Description:  \t"+piece3.getDescription());
        System.out.println("Quantity:\t"+piece3.getQuantity());
        System.out.println("Prize per item:\t"+piece3.getPrizePItem());
        System.out.println("Number:\t"+piece3.getNumber());
        System.out.println("InvoiceAmount:\t"+piece3.getInvoiceAmount());

    }
}
