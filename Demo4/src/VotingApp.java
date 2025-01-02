import java.util.Scanner;

public class VotingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nEnter you age : ");
        int age = sc.nextInt();
        System.out.println((age >= 18) ? "Eligible for voting" : "not eligible for voting");
        boolean eligible = (age >= 18) ? true : false;
        int minAge = (age >= 18) ? 18 : 20;
        System.out.println(minAge);
        System.out.println(eligible);
        sc.close();
    }
}
