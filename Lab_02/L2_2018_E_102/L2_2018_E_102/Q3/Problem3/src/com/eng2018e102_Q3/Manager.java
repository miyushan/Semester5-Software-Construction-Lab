package com.eng2018e102_Q3;

public class Manager extends Employee {

    private double bonus;
    public Staff[] team;
    public int level;
    private int num;
    private static int sum = 0;

    public Manager(String name, int age, double salary, double bonus, int level){
        super(name, age, salary);
        this.bonus = bonus;
        this.level = level;
        team = new Staff[num];
    }

    public void addStaff(Staff staff){
        team[sum]=staff;
        sum++;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }

    @Override
    public double getSalary() {
        return bonus + super.salary;
    }

    public boolean eqals(Manager name){
        return this.level == name.level;
    }

    @Override
    public String toString() {
        String staff=team[0].getName();
        for(int i=0; i<sum ;i++){
            staff = staff +"," + team[i].getName();
        }
        return "[" + getName() + "," + getAge() + "," + this.getSalary() + "," + getBonus() + "," +"("+ staff + ")" + "]";

    }

}

