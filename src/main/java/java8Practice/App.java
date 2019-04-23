package java8Practice;


import java8Practice.lambda.ExceptionHandlingExample;
import java8Practice.lambda.LambdaExpression;
import java8Practice.lambda.MethodReferenceExample;
import java8Practice.stream.StreamExample;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		JavaExampleTest le = new LambdaExpression();
		JavaExampleTest ehe = new ExceptionHandlingExample();
		JavaExampleTest mre = new MethodReferenceExample();
		JavaExampleTest se = new StreamExample();
//		le.run();
//		ehe.run();
//		mre.run();
		se.run();
		
		
		

	}

}
