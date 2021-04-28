public class EvenOrOdd {
    /**
     *
     * Author: 2018/E/102
     *
      * @param args
     */


    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};        //numbers want to check odd or even
        int count_odd = 0;  //to count odd numbers
        int count_even = 0; //to count even numbers

        //check odd or even
        for (int i = 0; i<numbers.length; i++){
            if (numbers[i]%2 == 0)  count_even++;
            else    count_odd++;
        }
        //print odd and even number values
        System.out.println("Number of even numbers: " +count_even);
        System.out.println("Number of odd numbers: " +count_odd);
    }


}
