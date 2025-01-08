import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Even odd program ");
        System.out.println("Enter the starting point : ");
        int x = sc.nextInt();
        System.out.println("Enter the second number : ");
        int y = sc.nextInt();
        for (int i = x; i <= y; i++) {
            if ((i ^ 1) == 0) {
                System.out.println(i);

            } else {
                continue;
            }
        }
    }

    public static boolean isEven(int num) {
        if ((num % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

}
