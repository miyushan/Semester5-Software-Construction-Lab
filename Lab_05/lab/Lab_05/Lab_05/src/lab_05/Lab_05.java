package lab_05;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2017e009
 */
public class Lab_05 {
    
    public static void searchByName( Scanner in, String[] args ){
        
        boolean findContact=false;
        while (in.hasNextLine()){
            
            String value = in.nextLine();
            String[] arrOfStr0 = value.split(":");
            String[] arrOfStr = arrOfStr0[0].split(" ");

            if(args[1].equals(arrOfStr[0]) && arrOfStr[1].equals(args[2]) ){

                System.out.printf( "%-15s %15s %n", arrOfStr0[0], arrOfStr0[1]);
                findContact=true;

            }
        }
        
        if(findContact == false){
            System.out.println("No Contact");
        }
    }
    
    public static void searchByNumber( Scanner in, String[] args ){
        
        boolean findContact=false;
        while (in.hasNextLine()){
            String value = in.nextLine();
            String[] arrOfStr0 = value.split(":");
            String arrOfStr = arrOfStr0[1].replace("-","");

            if(args[1].equals(arrOfStr)){

                System.out.println(arrOfStr0[0]);
                findContact=true;

            }
        }
        
        if(findContact == false){
            System.out.println("No Contact");
        }
    }
    
    public String[] print(String[] A){
        String[] s=new String[2];
        for(int i=0; i<2;i++){
            s[i]=A[i];
        }
    }
    
    public void inputContact(String[] args) throws IOException{
        int n = args.length;
        System.out.println("Input the directry :");
        Scanner input = new Scanner(System.in);
        String dir = input.nextLine();
        FileWriter filewrite = new FileWriter(dir);
        PrintWriter printwriter = new PrintWriter(filewrite);
        printwriter.println(print(args)+":"+args[n-1]);
        
    }

    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        Scanner in = null;
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab_05.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        searchByName(in, args );
        searchByNumber(in, args );
        
       
    }
    
}
