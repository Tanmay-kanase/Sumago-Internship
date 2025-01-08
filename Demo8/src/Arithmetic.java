public class Arithmetic {
    public static void add(int x, int y) {
        System.out.println("\n\nAddition of two numbers : " + (x + y));
    }

    public static void sub(int x, int y) {
        System.out.println("Subtraction of two numbers : " + (x - y));
    }

    public static void mult(int x, int y) {
        System.out.println("Multiplicatino of two numbers : " + (x * y));
    }

    public static void division(int x, int y) {
        try {
            System.out.println("Division of two numbers : " + (x / y));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static int Square(int y) {
        return y * y;
    }

    public static void main(String[] args) {

        add(12, 23);
        sub(40, 20);
        mult(5, 4);
        division(12, 4);
        System.out.println("Square of number 56 : " + (Square(56)));
    }
}
