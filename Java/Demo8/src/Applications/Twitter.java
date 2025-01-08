package Applications;

import java.util.Scanner;

public class Twitter {
    Scanner sc = new Scanner(System.in);
    boolean TwFlag = true;

    public void Tweet() {
        System.out.println("Tweeting...");
        Timer.time();
        System.out.println(".....................");
        Timer.time();
        System.out.println("Twitted.\n");
    }

    public void Retweet() {
        System.out.println("Retweeting...");
        Timer.time();
        System.out.println(".....................");
        Timer.time();
        System.out.println("Retwitted.\n");
    }

    public void LikeTweet() {
        System.out.println("Liking a tweet...");
        Timer.time();
        System.out.println(".....................");
        Timer.time();
        System.out.println("Liked a tweet.\n");
    }

    public void Menu() {
        do {
            System.out.println("""
                    <---------------------------Twitter------------------------->
                    Operations:
                    1. Tweet
                    2. Retweet
                    3. Like Tweet
                    Press any other key to close Twitter
                    Enter operation: """);
            int twc = sc.nextInt();
            if (twc == 1) {
                Tweet();
            } else if (twc == 2) {
                Retweet();
            } else if (twc == 3) {
                LikeTweet();
            } else {
                TwFlag = false;
            }
        } while (TwFlag);
    }
}