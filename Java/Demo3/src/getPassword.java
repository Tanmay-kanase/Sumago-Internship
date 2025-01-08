import java.util.Scanner;

public class getPassword {
    public void getPasswordformuser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Try Again Wrong Password !!!!!");
        System.out.println("\nEnter the password : ");
        String pass = sc.nextLine();
        if (pass.equals("123")) {
            System.out.println("Hello");
        } else {
            System.out.println("Wrong password!!");
            getPasswordformuser();
        }
        sc.close();
    }
}

