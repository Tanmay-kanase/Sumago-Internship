import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Take an input form user and print the number of times hello , the number given by the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point :");
        int st = sc.nextInt();
        System.out.println("Enter the ending point : ");
        int ep = sc.nextInt();
        // while ( 5 <= 10) 6 <= 10 7 <= 10
        while(st <= ep){
            System.out.println(st);
            st++;
        }
        sc.close();

        // problem statement 2nd 

    }
}
