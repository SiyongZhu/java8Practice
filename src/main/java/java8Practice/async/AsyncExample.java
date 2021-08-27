package java8Practice.async;

import java.util.concurrent.TimeUnit;

public class AsyncExample {
	
	public static void delay(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		AsyncTest ce = new AsyncTest();
		
		long startTime = System.currentTimeMillis();
//		ce.testAsync();
//		ce.testCallback();
//		ce.testCompose();
//		ce.testCombine();
//		ce.testWaitMultipleFuture();
		ce.testHandleException();
		long endTime = System.currentTimeMillis();
		
		long duration  = (endTime-startTime)/1000;
		System.out.println("Program ends with total time: "+duration+" sec");

	}

}
