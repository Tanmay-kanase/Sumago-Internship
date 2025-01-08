import java.util.Scanner;

public class Forloop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting point : ");
        int st = sc.nextInt();
        System.out.println("Enter the ending point : ");
        int ep = sc.nextInt();
        for (int i = st; i <= ep; i++) {
            System.out.println(i);
        }
        sc.close();
    }
}
