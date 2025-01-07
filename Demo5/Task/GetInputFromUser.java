import java.util.Scanner;

public class GetInputFromUser extends Store{
    Store str = new Store();
    private int x;
    private int y;

    public void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the 1st number : ");
        x = sc.nextInt();
        super.setNum1(x);
        System.out.println("Enter the 2nd number : ");
        y = sc.nextInt();
        super.setNum2(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

