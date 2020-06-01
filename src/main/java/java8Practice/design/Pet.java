package java8Practice.design;

public class Pet {

    String name;
    int age;
    public Pet(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        EatFood("PetFood");
    }
    
    protected void EatFood(String food) {
        System.out.println("My Pet Eating "+food);
    }
}
