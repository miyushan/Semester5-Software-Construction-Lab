package lab_05;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: 2018/E/102
 * This programme is used to create a contact list. Which can able to search a contact by its name, search a contact by its number, and add new contact.
 */
public class ContactList {

    private static int temp = 0;
    private static String obj;

    public static void main(String []args) throws Exception {

        //initial print statements
        System.out.println("\n\nThis is a programme about a contact list. You can search contact by its name and also its number. And it is able to add new contacts to the list");
        System.out.println("\nDemo:\n\t1. Search a contact by its name:\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt Leota\n\t2. Search a contact by its number:\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt 7707321194\n\t3. Add a new contact:\t\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt Shakeer Miyushan 0773298953");
        System.out.print("\nInput:\t");
        Scanner sc  = new Scanner(System.in);

        String inputted = sc.nextLine();
        String[] txt = inputted.split(".txt ");

        StringBuilder filePath = new StringBuilder(txt[0]); //get the file path

        File path = new File(filePath.append(".txt").toString());

        if(!path.exists()){
            path.createNewFile();   //create a new file if file doesnt exist
        }

        FileReader readF = new FileReader(path);
        BufferedReader readB =new BufferedReader(readF);


        String input = txt[1];

        System.out.print("\nYour results:\t");

        //check, is the input only include numbers
        if(input.matches("^\\d+(\\.\\d+)?")) {
            if(input.length()==10)//check is it a valid number
                searchNumber(readB, input);
            else
                throw new Exception("Not a valid number");    //not a valid number
        }

        //check, is the input only contains letters
        else if(input.matches("^\\p{L}+(?: \\p{L}+)*$"))
            searchName(readB,input);

            //check, is the input include the letters and numbers settle as a new contact
        else if(Pattern.matches("[A-Za-z0-9 ]+",input)){
            String newContact = formatContactDetails(input,readB);
            addNewContact(newContact,path);
        }
        else{
            throw new Exception("Exception of invalid Name or invalid Number");    //not a valid input
        }
        System.out.println("\n");

    }


    /**
     * This method is used to print the final output
     * @param word: line in the .txt file
     */
    public static void print(String word){
        String item1 = word.replaceAll("[^A-Za-z ]","");
        String item2 = word.replaceAll("[^0-9-]","");
        System.out.printf("\n\t\t%-20s\t%-10s", item1, item2);

    }


    /**
     * This method is used to convert the string into phone number format
     * @param num: phone number without - signs
     * @return
     */
    public static String append(String num){

        StringBuilder readS = new StringBuilder(num);
        for (int i=3; i<readS.length()-2; i+=4){
            readS.insert(i,'-');    //insert - sign
        }
        return readS.toString();
    }


    /**
     * This method is used to check number exist
     * @param br: buffered reader text
     * @param num: input number
     * @throws Exception
     */
    public static void searchNumber(BufferedReader br, String num) throws Exception {
        while((obj=br.readLine()) != null){
            if(obj.contains(append(num))) {
                //check is there any duplicated numbers
                if(temp >= 1)
                    throw new Exception("Duplicate Numbers Exception");
                print(obj);
                temp++;
            }
        }
        //check is the entered number exist
        if(temp == 0){
            System.out.println("CONTACT NOT FOUND");
        }
    }


    /**
     * This method is used to check name and number exist
     * @param br: buffered reader text
     * @param name: input name
     * @throws Exception
     */
    public static void searchName(BufferedReader br, String name) throws Exception {
        while((obj = br.readLine()) != null){
            if(obj.contains(name)){
                print(obj);
                temp++;
            }
        }
        //check is the entered number exist
        if(temp == 0){
            System.out.println("CONTACT NOT FOUND");
        }
    }


    /**
     * This method is used to format contact details
     * @param temp: input text
     * @param br: buffered reader text
     * @return
     * @throws Exception
     */
    public static String formatContactDetails(String temp, BufferedReader br) throws Exception {

        String item1 = temp.replaceAll("[^A-Za-z ]","");
        String item2 = temp.replaceAll("[^0-9]","");

        if(item2.length() != 10)
            throw new Exception(("Not a valid number"));

        while((obj=br.readLine()) != null){
            if(obj.contains(append(item2))) {
                //check whether is there are duplicated numbers
                throw new Exception("Duplicate Numbers cant add to the list");
            }
        }
        String val = item1.substring(0,item1.length()-1);
        temp = val+": "+append(item2);
        return temp;
    }


    /**
     * This method is used to add a new contact in Alphabetic order
     * @param contact: input details
     * @param list: considering list
     * @throws Exception
     */
    public static void addNewContact(String contact, File list) throws Exception {
        FileReader ob = new FileReader(list);
        BufferedReader br =new BufferedReader(ob);
        ArrayList<String> lines =new ArrayList<>();

        String currentLine = br.readLine();

        while(currentLine != null)
        {
            lines.add(currentLine);     //create a java list of contacts
            currentLine =br.readLine();
        }

        lines.add(contact);         //add new contact to java list
        Collections.sort(lines);    //sort java list

        FileWriter writeF = new FileWriter(list);
        PrintWriter writeP = new PrintWriter(writeF);

        writeP.print("");
        for(String line:lines){
            //add all contacts text list with the new contact
            writeP.append(line);
            writeP.append(System.lineSeparator());
        }
        System.out.println("New contact is added to the list.");
        writeP.close();
    }
}
