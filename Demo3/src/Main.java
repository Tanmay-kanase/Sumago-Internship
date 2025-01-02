import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ro check wether even or odd : ");
        int num = sc.nextInt();
        System.out.println((num ^ 1));
        System.out.println(num +1);
        if ((num ^ 1) == (num + 1)) {
            System.out.println("The number is Even.");
        } else {
            System.out.println("The number is Odd.");
        }
        sc.close();
        int a = 12;
        int b = 13;
        System.out.println("GCD of " + a + "and" + b + " is :" + gcd(a, b));
        System.out.println("LCM of " + a + "and" + b + " is :" + lcm(a, b));

    }

    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
