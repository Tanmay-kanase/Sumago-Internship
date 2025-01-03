import java.util.Scanner;

public class Switch {
    static boolean flag;
    public static void main(String[] args) {
        
        System.out.println("\nEnter two numbers : ");
        Scanner sc = new Scanner(System.in);
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
        if (input == '1' || input == '2' || input == '3' || input == '4') {
            flag = true;
        }
        if (flag) {
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
                    System.out.println("Wrong input!!!!");
                    break;
            }
        }
        sc.close();
    }

}
