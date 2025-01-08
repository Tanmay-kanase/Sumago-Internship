import java.util.Scanner;

public class Pattern {
    public static void main(String args[]) {
        // st = 20 ep = 10
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting number : ");
        int num = sc.nextInt();
        System.out.println("Enter the seond number : ");
        int num1 = sc.nextInt();
        for (int i = num; i >= num1; i--) {
            System.out.println(i);
        }
        sc.close();
        
    }
}
