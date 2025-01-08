import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Eter an integer value : ");
        // int integer = sc.nextInt();
        // System.out.println("ENter an float value : ");
        // Float floatnum = sc.nextFloat();
        // System.out.println("Enter an boolean value : ");
        // boolean flag = sc.nextBoolean();
        // System.out.println("Enter an String : ");
        // String str = sc.next();
        // System.out.println("Enter an BigInteger : ");
        // BigInteger integer2 = sc.nextBigInteger();
        // System.out.println("Integer value : " + integer);
        // System.out.println("Integer value : " + floatnum);
        // System.out.println(
        // "Boolean Value : " + flag);
        // System.out.println("String : " + str);
        // System.out.println("Big INteger : " +integer2);

        getPassword gp = new getPassword();

        System.out.println("Enter the password : ");
        String pass = sc.nextLine();
        if (pass.equals("123")) {
            System.out.println("Hello");
        } else {
            gp.getPasswordformuser();
        }
        sc.close();

    }

}
