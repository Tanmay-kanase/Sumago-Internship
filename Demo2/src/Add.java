import java.util.Scanner;

public class Add {
    public static void main(String[] args) throws Exception {

        // int a = 10;
        // int b = 20;
        // int c = 30;

        // System.out.println(a++ + ++b + c++ + a++ + ++b + c++);
        // System.out.println(c++ * a++ * c++ + b++ + --a - --c - c++);
        // System.out.println(b++ / c++ / ++b + c++);

        // System.out.println(50 + 55 * 66 / 88);
        // System.out.println(2 / 2 * 3 + 4);
        // int num1 = 50;
        // int num2 = 70;
        // int add = num1 + num2;
        // System.out.println("Addtion : " + add);

        // System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the first number : ");
        int x = sc.nextInt();
        System.out.println("Enter the second number : ");
        int y = sc.nextInt();

        System.out.println("Addition of two numbers are : " + Addition(x, y));
        System.out.println("Subtraction of two numbers are : " + Subtraction(x, y));

        sc.close();
    }

    public static int Addition(int x, int y) {
        return (x + y);
    }
    public static int Subtraction(int x , int y){
        return (x-y);
    }
}
