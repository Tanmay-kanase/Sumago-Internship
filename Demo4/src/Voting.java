import java.util.Scanner;

public class Voting {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your age : ");
            int age = sc.nextInt();
            if (age <= 18 && age >= 1) {
                System.out.println("You are not eligible for Voting");
            } else {
                System.out.println("You are eligible for voting.");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Try again....");
            try {
                Thread.sleep(2000);
            } catch (Exception h) {
                System.out.println(h.getMessage());
            }
        }
    }
}
