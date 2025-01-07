public class Star {
    public static void main(String[] args) {
        System.out.println("\n\nStar Pattern : ");
        int num = 1;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 5; j++){
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }
}
 
