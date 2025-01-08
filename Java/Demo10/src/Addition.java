public class Addition {
    public Addition() {
        System.out.println("Addition is called.");
    }

    public Addition(int x, int y) {
        System.out.println("Addition = " + (x + y));
    }

    public Addition(int x, int y, int z) {
        System.out.println("Addition = " + (x + y + z));
    }

    public Addition(int x, double y) {
        System.out.println("Addition = " + (x + y));
    }

    public Addition(double x, int y) {
        System.out.println("Addition = " + (x + y));
    }

}
