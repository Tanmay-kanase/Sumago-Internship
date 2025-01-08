package Methods;

public class Main {
public static void main(String[] args) {

    // Animal -> Dog , Cat 
    // Animal class referncing to the class Dog and accesing all the override methods with refference object.
    Animal dog = new Dog("Lufyy");
    dog.walk();
    dog.sound();

    // same for cat
    Animal cat = new Cat("Tommy");
    cat.walk();
    cat.sound();
}
}
