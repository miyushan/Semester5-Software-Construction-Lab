public class uglyNumber {

    public static void main(String[] args){

        int n = 235;
        while (n!=1){
            if(n%5==0)  n/=5;
            else if(n%3==0)  n/=3;
            else if(n%2==0)  n/=2;
            else{
                System.out.print("It is not an ugly number.");
                break;
            }
        }
        if (n==1){
            System.out.print("It is an ugly number.");
        }
    }

}
