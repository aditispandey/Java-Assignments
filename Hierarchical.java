class Animal1 {
    void eats() {
        System.out.println("Animal eats food");
    }
}
class Dog1 extends Animal1 {
    void barks() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal1 {
    void meows() {
        System.out.println("Cat meows");
    }
}
public class Hierarchical{
    public static void main(String[] args){
        Dog1 d1 = new Dog1();
        d1.eats();
        d1.barks();
        Cat c1 = new Cat();
        c1.eats();
        c1.meows();
    }
}
