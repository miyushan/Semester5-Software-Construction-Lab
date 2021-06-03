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
                throw new Exception("Numbers of digits not 10");    //not a valid number
        }

        //check, is the input only contains letters
        else if(input.matches("^\\p{L}+(?: \\p{L}+)*$"))
            searchName(readB,input);

        //check, is the input include the letters and numbers settle as a new contact
        else if(Pattern.matches("[A-Za-z0-9 ]+",input)){
            String newContact = makeFormat(input,readB);
            addContact(newContact,path);
        }
        else{
            throw new Exception("Invalid Name or Number Exception");    //not a valid input
        }

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
     *
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
     * search the number and print the details if it exists
     * @param readB: text file in buffered reader format
     * @param num: inputted number
     * @throws Exception
     */
    public static void searchNumber(BufferedReader readB, String num) throws Exception {
        while((obj = readB.readLine()) != num){
            if(obj.contains(append(num))) {
                //check is there any duplicated numbers
                if(temp>=1)
                    throw new Exception("Stored Data Duplicate Number Exception");
                    print(obj);
                    temp++;
            }
        }
        //check is the comber doesnt
        if(temp == 0){
            System.out.println("No Contact Found");
        }
    }


    /**
     * search the name and print the details if it exists
     * @param readB: text file in buffered reader format
     * @param name: inputted name
     * @throws Exception
     */
    public static void searchName(BufferedReader readB, String name) throws Exception {
        while((obj = readB.readLine())!=null){
            if(obj.contains(name)){
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
