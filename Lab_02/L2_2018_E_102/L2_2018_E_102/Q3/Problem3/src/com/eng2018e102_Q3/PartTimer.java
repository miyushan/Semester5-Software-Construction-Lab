package com.eng2018e102_Q3;

public class PartTimer extends Staff{

    private double payRate;
    public int workedHours;

    public PartTimer(String name, int age, int workedHours, double payRate){
        super( name, age, payRate*workedHours);
        this.payRate = payRate;
        this.workedHours = workedHours;
    }

    public double getSalary(){
        return payRate * workedHours;
    }

    public double getPayRate(){
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public boolean equals (PartTimer obj){
        return this.payRate == obj.payRate;
    }

    @Override
    public String toString() {
        return "["+getName()+","+getAge()+","+this.getSalary()+","+getPayRate() +","+workedHours +"]";
    }

}
