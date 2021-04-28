import java.util.*;
public class EvenOrOddUpdate {
    /**
     *
     * Author: 2018/E/102
     *
     * @param args
     */


    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);    //standard input stream
        System.out.println("Total numbers you want to check:");
        int num = sc.nextInt();     //get total numbers as an input

        System.out.println("\nEnter your values below:");
        int[] inputNum = new int[num];
        int temp = 0;
        int count_odd = 0;  //to count odd numbers
        int count_even = 0; //to count even numbers

        for (int j = 0; j < num; j++) {
            temp = sc.nextInt();
            inputNum[j] = temp;
        }

        //check odd or even
        for (int i = 0; i<inputNum.length; i++){
            if (inputNum[i]%2 == 0)  count_even++;
            else    count_odd++;
        }

        //print odd and even number values
        System.out.println("\nNumber of even numbers: " +count_even);
        System.out.println("Number of odd numbers: " +count_odd);
    }


}
