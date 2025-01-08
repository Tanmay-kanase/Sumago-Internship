package Applications;

import java.util.Scanner;

public class Instagram {
    boolean IgFlag = true;
    Scanner sc = new Scanner(System.in);
    public void PostPhoto() {
        System.out.println("Posting a photo...");
        Timer.time();
        System.out.println("......................");
        Timer.time();
        System.out.println("Photo Posted.");
    }

    public void LikePhoto() {
        System.out.println("Liking a photo...");
        Timer.time();
        System.out.println("....................");
        Timer.time();
        System.out.println("Photo Liked.\n");
    }

    public void Story() {
        System.out.println("Posting a story...");
        Timer.time();
        System.out.println("....................");
        Timer.time();
        System.out.println("Story Posted.\n");
    }

    public void Menu(){
        do {
            System.out.println("""
                    <---------------------------Instagram------------------------->
                    Operations:
                    1. Post Photo
                    2. Like Photo
                    3. Story
                    Press any other key to close Instagram
                    Enter operation: """);
            int ig = sc.nextInt();
            if (ig == 1) {
                PostPhoto();
            } else if (ig == 2) {
                LikePhoto();
            } else if (ig == 3) {
                Story();
            } else {
                IgFlag = false;
            }
        } while (IgFlag);
    }
}