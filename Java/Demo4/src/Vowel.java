import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ant character : ");
        char ch = sc.next().charAt(0);
        if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            System.out.println("Vowel");
        }else{
            System.out.println("Not a vowel!");
        }
        sc.close();
        // Ternary Operatot
    }
}
