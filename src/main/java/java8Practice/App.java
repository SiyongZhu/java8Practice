package java8Practice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import io.vertx.core.json.JsonObject;
import java8Practice.interview.BasicTest;
import java8Practice.interview.search.SearchTest;
import java8Practice.interview.sort.SortTest;
import java8Practice.interview.tree.TreeTraveralTest;
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
		JavaExampleTest tree = new TreeTraveralTest();
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
		
//		System.out.println("------Timeformat Testing");
//		String str = "2020-01-24T13:20:20.000Z";
//		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		DateTime dt = formatter.parseDateTime(str);
//		System.out.println(dt.getYear());
//		System.out.println(dt.getDayOfMonth());
//		System.out.println(String.format(" Time %s ", dt.toString()));
//		
//		System.out.println("-------Random Generator");
//		List<Object> qids = new ArrayList<>();
//		Random rand = new Random();
//        qids.add(String.valueOf(rand.nextInt(1000000)));
//        String s = (String)qids.get(0);
//        System.out.println(s);
        
//		System.out.println("-------Optional Example");
//        HashMap<Integer, String> stringMap = new HashMap<>();
//        stringMap.put(0, "John Doe");
//        stringMap.put(1, "Alfred Neuman");
//        stringMap.put(2, "John Galt");
//        stringMap.put(4, null); //<- this is a no-no, b/c this time the expected return is null, Optional will not consider it a valid value
//        stringMap.put(5, "Homer");
//        
//        System.out.println("Is this element Homer? " + Optional.ofNullable(stringMap.get(4)).orElse("").equals("Homer"));
//        
//        Object o = true;
//        System.out.println(o.equals("true"));
//        
//        HashMap<String, List<Object>> listMap = new HashMap<>();
//        List<Object> objs = new ArrayList<Object>();
//        objs.add("test");
//        listMap.put("1", new ArrayList<Object>());
//        listMap.put("2", objs);
//		
//        String result = (String) Optional.ofNullable(listMap.get("3"))
//                .filter(list->list.size()>0)
//                .map(list -> list.get(0)).orElse(null);
//        System.out.println( "Map might contain ampty list: " + result );
//        
//        JsonObject json = new JsonObject();
//        json.put("1", new JsonObject().put("2", new JsonObject().put("3", objs)) );
//        
//        JsonObject json2 = null;
//        
//        System.out.println("-------Nest Optional Test");
//        
//        System.out.println(
//                Optional.ofNullable(json).flatMap(a-> Optional.ofNullable(a.getJsonObject("1")))
//                .flatMap(a-> Optional.ofNullable(a.getJsonObject("4")))
//                .flatMap(a-> Optional.ofNullable(a.getJsonArray("3")))
//                .filter(a ->a.size()>0).isPresent()
//        );
//        
//        String errorMsg = "Access Denied (Service: Amazon S3; Status Code: 403; Error Code: AccessDenied; Request ID: 0DB30E072412F296)";
//        System.out.println(errorMsg.indexOf("Status Code:"));
//        System.out.println(errorMsg.indexOf("WHatever:"));

        
//        System.out.println(Optional.ofNullable(json).flatMap(o -> Optional.ofNullable(o.getJsonObject("1")))));
        
        
		
		

	}

}
