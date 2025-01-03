import java.util.Scanner;

public class Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter any number : ");
        int num = 678;
        System.out.println("Num = " + (num % 10));
        System.out.println(num);
        System.out.println("After Removing last digit : "  + (num));
        sc.close();
    }
}
