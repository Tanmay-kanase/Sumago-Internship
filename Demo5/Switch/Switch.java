import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuBar menu = new MenuBar();
        menu.getInput();
        menu.menuBar();
        sc.close();
    }
}
