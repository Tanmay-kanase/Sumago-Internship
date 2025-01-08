import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(
                    "<-------------------------------------------------------------------------------------------------------------------------->");
            System.out.println("\n\nEnter two numbers : ");
            System.out.println("num1 = : ");
            int x = sc.nextInt();
            System.out.println("num2 = ");
            int y = sc.nextInt();
            System.out.println("""
                    ============================Menu=========================
                    1 . Addition
                    2 . Subtraction
                    3 . Multiplication
                    4 . Division

                    Enter the operation :
                    """);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Addition : ");
                    System.out.print((x + y));
                    break;
                case 2:
                    System.out.println("Subtraction : ");
                    System.out.print((x - y));
                    break;
                case 3:
                    System.out.println("Mulitiplication : ");
                    System.out.print(x * y);
                    break;
                case 4:
                    System.out.println("Division : ");
                    System.out.print((x / y));
                    break;
                default:
                    System.out.println("Thank You for using application !!!!!!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
