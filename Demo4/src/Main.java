import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // program for prime number
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to check wether prime or not : ");
        int num = sc.nextInt();
        sc.close();
        System.out.println((isPrime(num)) ? "Not a Prime Number " : "is prime number");

    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)  return true;
        }
        return false;

    }

}
