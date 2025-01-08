package Applications;

import java.util.Scanner;

public class Facebook {
    boolean FbFlag = true;
    Scanner sc = new Scanner(System.in);

    public void Post() {
        System.out.println("Posting on Facebook...");
        Timer.time();
        System.out.println("...................");
        Timer.time();
        System.out.println("Posted on Facebook.\n");
    }

    public void Like() {
        System.out.println("Liking a post...");
        Timer.time();
        System.out.println("...................");
        Timer.time();
        System.out.println("Liked a post.\n");
    }

    public void Comment() {
        System.out.println("Adding a comment...");
        Timer.time();
        System.out.println("......................");
        Timer.time();
        System.out.println("Comment Added.\n");
    }

    public void Menu() {
        do {
            System.out.println("""
                    <---------------------------Facebook------------------------->
                    Operations:
                    1. Post
                    2. Like
                    3. Comment
                    Press any other key to close Facebook
                    Enter operation: """);
            int fbc = sc.nextInt();
            if (fbc == 1) {
                Post();
            } else if (fbc == 2) {
                Like();
            } else if (fbc == 3) {
                Comment();
            } else {
                FbFlag = false;
            }
        } while (FbFlag);
    }

}