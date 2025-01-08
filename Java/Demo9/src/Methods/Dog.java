package Methods;

public class Dog extends Animal{
    private String name;
    public void sound() {
        System.out.println(name + "  Bhow  ... bhow ... ");
    }

    public void walk() {
        System.out.println("Dog is walking ... ");
    }

    public Dog(String name){
        this.name = name;
    }
}
