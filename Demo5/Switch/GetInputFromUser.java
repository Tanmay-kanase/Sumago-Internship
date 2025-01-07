import java.util.Scanner;

public class GetInputFromUser {

    static int x;
    static int y;

    public void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the 1st number : ");
        x = sc.nextInt();

        System.out.println("Enter the 2nd number : ");
        y = sc.nextInt();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

