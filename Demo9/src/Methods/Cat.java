package Methods;

public class Cat extends Animal {
    private String name;

    public void sound() {
        System.out.println(name + " Meow ... Meow ");
    }
    
    public void walk() {
        System.out.println("Cat is walking ...");
    }

    public  Cat(String name) {
        this.name = name;
    }
}
