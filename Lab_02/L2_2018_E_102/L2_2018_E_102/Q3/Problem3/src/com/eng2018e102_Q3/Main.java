package com.eng2018e102_Q3;
import java.util.Scanner;

/**
 *
 * Author: 2018/E/102
 *
 */
public class Main {

    public static void printEmployeeDetails (Employee [] e){
        Scanner input = new Scanner(System.in);
        //get a name as an input
        System.out.print("\nEnter the employee name:\t");
        String EmpName = input.next();

        int j = 0;
        while(j < e.length){
            //check is the input name equal to a name in employee array.
            if (e[j].getName().equals(EmpName)) {
                System.out.println(e[j].toString());
            }
            j++;
        }

    }

    public static void main(String[] args) {
        //create an array to store data about employees
        int num = 6;
        Employee[] employees = new Employee[num];

        //input employee details
        employees[0] = new Employee("Nadeesha", 23, 90000);
        employees[1] = new Employee("Dineth", 24, 75000);
        employees[2] = new Employee("Lakindu", 23, 45000);
        employees[3] = new Employee("Isuru", 25, 95000);
        employees[4] = new Employee("Keshan", 22, 80000);
        employees[5] = new Employee("Anuvathan", 23, 60000);

        //used to get details
        printEmployeeDetails(employees);
    }
}
