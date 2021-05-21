package lab_04_2018e102;

import java.util.*;

/**
 *Author: 2018/E/102
 *This program is used to sort given strings by length and alphabetical order
 */

public class SortStrings {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner class to get inputs
        List<String> names = new ArrayList<>(); //declare an Arraylist to store inputs as an array

        int length;
        String temp;

        System.out.print("\nHow many strings do you want to sort:\t");
        length = input.nextInt();   //number of strings want to sort

        System.out.println("\nEnter your strings here");

        //giving inputs as user input
        for (int i = 0; i <length ; i++) {

            System.out.print("Name " + (i+1) + " :\t");
            temp = input.next();    //get input strings
            names.add(temp);        //store data to arraylist

        }

        System.out.println("\nUnsorted array:");
        print(names);   //print initial array
        System.out.println("\nSorted array:");
        sort(names);    //print sorted array
    }

    /**
     * This method is used to sort ArrayList by length and alphabetical order
     * @param arr
     */
    static void sort(List<String> arr){
        Collections.sort(arr);  //sort by first character of the name
        Collections.sort(arr,Comparator.comparing(String::length));     //sort by length of the name
        print(arr);
    }

    /**
     *This method is used to print elements of ArrayList
     * @param arr
     */
    static void print(List<String> arr){
        for (Object name : arr) {
            System.out.println(name);
        }
    }

}
