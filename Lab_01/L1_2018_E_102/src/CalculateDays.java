import java.util.Scanner;

/**
 *
 * Author: 2018/E/102
 *
 */
public class CalculateDays {

    private int year;
    private String month;
    private String input;

    CalculateDays(String input){
        this.input=input;
    }

    public void FindDays()
    {
        splitYearMonth ();
        //find days in appropriate month
        switch(getMonth ())
        {
            case "January" :
            case "February":
            {
                if(isLeap()){
                    System.out.println(29);
                }
                else{
                    System.out.println(28);
                }
                break;
            }
            case "March" :
            case "May" :
            case "July" :
            case "August" :
            case "October" :
            case "December" :
            {
                System.out.println(31);
                break;
            }
            case "April" :
            case "June" :
            case "September" :
            case "November" :
            {
                System.out.println(30);
                break;
            }
            default:
            {
                System.out.println("Error!!!");
                break;
            }
        }
    }

    private void splitYearMonth ()
    {
        //split month and year
        String[] split = input.split(" ");
        this.year=Integer.parseInt(split[1]);
        this.month= split[0];
    }
    //check is it a leap year
    private boolean isLeap()
    {
        return getYear ()%4==0;
    }
    private int getYear ()
    {
        return year;
    }
    private String getMonth ()
    {
        return month;
    }


    public static void main(String[] args) {

        System.out.println("Enter month and year likewise (April 2021):");
        Scanner sc = new Scanner(System.in);
        String input= sc.nextLine();

        CalculateDays obj = new CalculateDays(input);
        //find dates
        System.out.println("Number of days:\t");
        obj.FindDays();

    }

}