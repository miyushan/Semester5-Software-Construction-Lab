
package com.company;
        import java.io.*;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.*;

public class Contact_list {

    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        Scanner in = null;

        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (Objects.requireNonNull(in).hasNextLine()) {
            String value = in.nextLine();
            // System.out.println(value);


            int i = 0;
            while (!Character.isDigit(value.charAt(i))) {
                i++;
            }

            String name = value.substring(0, i);
            name=name.replaceAll(":"," ");
            String[]names =name.split(" ");
            //System.out.println(name); // Print the all names only



            String number = value.substring(i);
            // number=number.replaceAll("-",""); //If number is input without "-"
            String[]numbers =number.split(" ");
            //System.out.println(number);  // Print the all numbers only



            if(args.length>2) {

                if(args[1].equals(names[0]) && args[2].equals(names[1])||args[1].equals(names[0]) && args[2].equals(numbers[1])) {
                    if (args[1].equals(names[0]) && args[2].equals(names[1])) {
                        System.out.printf("%-15s %15s %n", name, number);
                    }

                    if (args[1].equals(names[0]) && args[2].equals(numbers[1])) {
                        System.out.printf("%-15s %15s %n", name, number);
                    }
                }



                else if (!args[1].equals(names[0]) && !args[2].equals(names[1]) && !args[3].equals(numbers[2])){
                    FileWriter file_write = null;
                    try {
                        file_write = new FileWriter(args[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter printwriter = new PrintWriter(file_write);
                    printwriter.printf(name+":"+number);
                }


                else if (!args[1].equals(names[0]) && !args[2].equals(numbers[1])){
                    FileWriter filewrite = null;
                    try {
                        filewrite = new FileWriter(args[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter printwriter = new PrintWriter(filewrite);
                    printwriter.printf(name+":"+number);
                }



                else if (!args[1].equals(names[0]) && !args[2].equals(names[1]) && args[3].equals(numbers[2])){
                    System.out.println("Wrong input");
                    break;
                }


                else if (!args[1].equals(names[0]) && args[2].equals(numbers[1]) ){
                    System.out.println("Wrong input");
                    break;
                }



            }
            else if(args.length==2) {
                if (args[1].equals(numbers[0])){
                    System.out.printf( "%-15s %15s %n",number,name);
                }

                else if  (args[1].equals(names[0])) {
                    System.out.printf( "%-15s %15s %n",number,name);

                }

                else{
                    System.out.println("Wrong input");
                    break;
                }


            }





//                if (args[1].equals(numbers[0])){
//                     System.out.printf( "%-15s %15s %n",number,name);
//                }




        }

    }

}