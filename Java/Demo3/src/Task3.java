import java.util.Scanner;

public class Task3 {

    public static boolean isAllLowercase(String input) {
        for (char str : input.toCharArray()) {
            if (str >= 'A' && str <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllUppercase(String input) {
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                return true;
            }
        }
        return false;
    }

    public static boolean isDigit(String input) {

        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String args[]) {
        try {

            // We have to take input from user if user gives "abcc" then give output as
            // "Small letter"
            // If "ABCJHDHJH" then output "Capital Letter"
            // If "446546576" then output "Digits"
            // or else special symbol

            // Creating Scanner object for getting input from user
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("=======================================================");
                System.out.println("\nEnter an String you want to check : OR (Type 'exit' to terminate program)");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Terminating Program ........");
                    try {
                        Thread.sleep(1000); // Pause for 2 seconds (2000 milliseconds)
                    } catch (InterruptedException e) {
                        System.err.println("Sleep interrupted: " + e.getMessage());
                    }
                    break;
                } else if (isAllLowercase(input)) {
                    System.out.println("The input is upper case.");

                } else if (isAllUppercase(input)) {
                    System.out.println("The input is in lower case.");

                } else if (isDigit(input)) {
                    System.out.println("The input is Digit.");

                } else {
                    System.out.println("The input is special smbol.");

                }

            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Try again . After some time");
        }
    }

}
