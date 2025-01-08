
import java.util.Scanner;

import Applications.Facebook;
import Applications.Instagram;
import Applications.Snapchat;
import Applications.Timer;
import Applications.Twitter;

public class Methods {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        Twitter tw = new Twitter();
        Facebook fb = new Facebook();
        Instagram inst = new Instagram();
        Snapchat sp = new Snapchat();
        do {
            System.out.println("\n");
            System.out.println("""

                    =============================Menu==========================
                    1. Instagram
                    2. Twitter
                    3. Facebook
                    4. Snapchat

                    Enter number to perfrom operation or press any number to exit : """);
            int ch = sc.nextInt();
            if (ch == 1) {
                inst.Menu();
            } else if (ch == 2) {
                tw.Menu();
            } else if (ch == 3) {
                fb.Menu();
            } else if (ch == 4) {
                sp.Menu();
            } else {
                System.out.println("Exitting program.......");
                Timer.time();
                flag = false;
            }
        } while (flag);
        sc.close();

    }

}
