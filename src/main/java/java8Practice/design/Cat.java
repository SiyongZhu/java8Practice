package java8Practice.design;

public class Cat extends Pet {

    String color;
    
    public Cat(String name, int age) {
        super(name, age);
    }
    
    protected void EatFood(String food) {
        super.EatFood(food);
        System.out.println("My cat is eating "+food);
    }
}
