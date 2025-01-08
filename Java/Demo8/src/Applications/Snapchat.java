package Applications;

import java.util.Scanner;


public class Snapchat {
     boolean Snflag = true;
     Scanner sc = new Scanner(System.in);
    
    public void Streak() {
        System.out.println(".....................");
        Timer.time();
        
        System.out.println("Streak is 34\n");
        Timer.time();
    }

    public void Sendsnap() {
        System.out.println("Sending snap .......");
        Timer.time();
        System.out.println(".....................");
        Timer.time();
        System.out.println("Snap send.\n");
    }

    public void Opensnap() {
        System.out.println("Openning Snap ........");
        Timer.time();
        System.out.println(".....................");
        Timer.time();
        System.out.println("Snap Opened.\n");
    }
    public void Menu(){
        do {
            System.out.println("""
                    <---------------------------Snapchat------------------------->
                    Operations :
                    1. Opensnap
                    2. Sendsnap
                    3. Streak
                    press an key to close snapchat
                    Enter operation : """);
            int sn = sc.nextInt();
            if (sn == 1) {
                Opensnap();
            } else if (sn == 2) {
                Sendsnap();
            } else if (sn == 3) {
                Streak();
            } else {
                Snflag = false;
                break;
            }
        } while (Snflag);

    }
}
