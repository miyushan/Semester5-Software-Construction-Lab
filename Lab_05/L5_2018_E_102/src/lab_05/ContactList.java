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
        System.out.println("\nDemo:\n\t1. Search a contact by its name:\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt Sage\n\t2. Search a contact by its number:\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt 7707321194\n\t3. Add a new contact:\t\tE:\\CAMPUS\\E18_5th_Semester\\EC5080- Software Construction\\Labs\\Lab_05\\L5_2018_E_102\\src\\lab_05\\contact_list.txt Shakeer Miyushan 0773298953");
        System.out.print("\nInput:\t");
        Scanner sc  = new Scanner(System.in);

        String inputted = sc.nextLine();
        String[] txt = inputted.split(".txt ");

        StringBuilder filePath = new StringBuilder(txt[0]); //get the file path

        File path = new File(filePath.append(".txt").toString());

        //if file not exits create a new file
        if(!path.exists())
            path.createNewFile();


        FileReader fr = new FileReader(path);
        BufferedReader br =new BufferedReader(fr);



        String input=txt[1];

        System.out.print("\nRESULT:\n\n");

        //check whether input contains only numbers or not
        if(input.matches("^\\d+(\\.\\d+)?")) {
            if(input.length()==10)
                search_No(br, input);
            else
                throw new Exception("Numbers of digits not 10");
        }
        /*check whether input contains only alphabets and spaces or not
            \\p{L} : any kind of letter from any language
         */
        else if(input.matches("^\\p{L}+(?: \\p{L}+)*$"))
            search_Name(br,input);

            //if the input contains letters and numbers
        else if(Pattern.matches("[A-Za-z0-9 ]+",input)){
            String newContact = makeFormat(input,br);
            addContact(newContact,path);
        }
        else
            throw new Exception("Invalid Name or Number Exception");


        System.out.println("Thank you for using contact list app");
    }

    /**
     * print outputs in two columns
     * @param s: searched line in the text file
     */
    public static void print(String s){

        String str1 = s.replaceAll("[^A-Za-z ]","");
        String str2 = s.replaceAll("[^0-9-]","");
        System.out.printf("%-20s %-10s\n",str1,str2);

    }

    /**
     * Append '-' to get the phone number format
     * @param s: Input phone number
     * @return the phone number in text file format
     */
    public static String append(String s){
        //convert string into string builder format
        StringBuilder sb = new StringBuilder(s);
        for (int i=3;i<sb.length()-2;i+=4)
            sb.insert(i,'-');
        return sb.toString();
    }

    /**
     * search the number and print the details if it exists
     * @param br: text file in buffered reader format
     * @param input: inputted number
     * @throws Exception
     */
    public static void search_No(BufferedReader br, String input) throws Exception {
        while((obj=br.readLine())!=null){
            if(obj.contains(append(input))) {
                //check whether there are any duplicate numbers or not
                if(temp>=1)
                    throw new Exception("Stored Data Duplicate Number Exception");
                print(obj);
                temp++;
            }
        }
        //check whether the entered number found or not
        if(temp==0){
            System.out.println("No Contact Found");
        }
    }

    /**
     * search the name and print the details if it exists
     * @param br: text file in buffered reader format
     * @param input: inputted name
     * @throws Exception
     */
    public static void search_Name(BufferedReader br, String input) throws Exception {
        while((obj=br.readLine())!=null){
            if(obj.contains(input)){
                print(obj);
                temp++;
            }
        }
        //check whether the entered number found or not
        if(temp==0){
            System.out.println("No Contact Found");
        }
    }


    /**
     * Builds the necessary format for print in text file
     * @param s: inputted stream
     * @param br: text file in buffered reader format
     * @return necessary format for print in text file
     * @throws Exception
     */
    public static String makeFormat(String s, BufferedReader br) throws Exception {

        String str1 = s.replaceAll("[^A-Za-z ]","");
        String str2 = s.replaceAll("[^0-9]","");

        if(str2.length()!=10)
            throw new Exception(("Numbers of digits not 10"));

        while((obj=br.readLine())!=null){
            if(obj.contains(append(str2))) {
                //check whether there are any duplicate numbers or not
                throw new Exception("Duplicate Number Cannot Add");
            }
        }
        String dl = str1.substring(0,str1.length()-1);
        s = dl+": "+append(str2);
        return s;
    }

    /**
     * Adds a contact to the list in alphabetic order
     * @param newContact: inputted stream
     * @param file: appropriate list
     * @throws Exception
     */
    public static void addContact(String newContact, File file) throws Exception {
        FileReader fr = new FileReader(file);
        BufferedReader br =new BufferedReader(fr);
        ArrayList<String> lines =new ArrayList<>();

        String currentLine = br.readLine();
        while(currentLine!=null)
        {
            //make a java list of contacts
            lines.add(currentLine);
            currentLine =br.readLine();
        }
        //add the new contact to the java list
        lines.add(newContact);
        //sort the java list
        Collections.sort(lines);

        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        //erase all contacts in the list of text file
        pw.print("");
        for(String line:lines){
            //add all contacts to the text list
            pw.append(line);
            pw.append(System.lineSeparator());
        }
        System.out.println("Contact Successfully Added.");
        pw.close();
    }
}
