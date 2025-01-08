import java.util.Scanner;

public class MenuBar extends Store{
    int input;

    public void menuBar() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("""
                    ============================Menu=========================
                    1 . Addition
                    2 . Subtraction
                    3 . Multiplication
                    4 . Division

                    Enter the operation :
                    """);
            input = sc.nextInt();
            super.setInput(input);
            switch (getInpute()) {
                case 1:
                    System.out.println("Addition : ");
                    System.out.print((super.num1 + super.b));
                    break;
                case 2:
                    System.out.println("Subtraction : ");
                    System.out.println((a + b));
                    break;
                case 3:
                    System.out.println("Mulitiplication : ");
                    System.out.println((a + b));
                    break;
                case 4:
                    System.out.println("Division : ");
                    System.out.println((a + b));
                    break;
                default:
                    System.out.println("Wrong input!!!!");
                    break;
            }
            

        }
        sc.close();

    }

    public int getInpute() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

}
