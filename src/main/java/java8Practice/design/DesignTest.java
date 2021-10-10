package java8Practice.design;

public class DesignTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    	//Note: 
    	//Pet constructer is calling EatFood()
    	//the Pet constructer will also callback Cat Constructor to call cat.eatFood() as well
        Cat adm = new Cat("Admiral", 3);
        
        System.out.println("Over");
        

    }

}
