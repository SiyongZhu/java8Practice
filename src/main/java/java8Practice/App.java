package java8Practice;


import java8Practice.interview.BasicTest;
import java8Practice.interview.search.SearchTest;
import java8Practice.interview.sort.SortTest;
import java8Practice.interview.tree.TreeTest;
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
		JavaExampleTest basic = new BasicTest();
		JavaExampleTest tree = new TreeTest();
		JavaExampleTest sort = new SortTest();
		JavaExampleTest search = new SearchTest();
//		le.run();
//		ehe.run();
//		mre.run();
//		se.run();
//		basic.run();
		tree.run();
//		sort.run();
//		search.run();
		
		
		

	}

}
