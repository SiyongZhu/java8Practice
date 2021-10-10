package java8Practice.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncTest {
	
	public void delay(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  testAsync() {
		//Provide a lambda function 
		Runnable runnable = () -> {
			delay(1);
			System.out.println("I am in runnable - "+Thread.currentThread().getName());
		};
		//runAsync() takes Runnable Object, returns CompletableFuture<Void> 
		//without providing ExecutorThreadPool, a thread is obtained from global ForkJoinPool.commonPool()
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);
		System.out.println("I am in main - "+Thread.currentThread().getName());
		completableFuture.join();
		
		
		//We can also provide a thread Pool
		ExecutorService service = Executors.newCachedThreadPool();
		CompletableFuture<Void> completableFutureWithThreadPool = CompletableFuture.runAsync(runnable, service);
		System.out.println("I am still in main - "+Thread.currentThread().getName());
		completableFutureWithThreadPool.join();
		
		//We can use supplyAync to return a CompletableFuture<T>
		CompletableFuture<String> completeableFutureWithSupplier = CompletableFuture.supplyAsync(() -> {
			delay(1);
			System.out.println("I am in supplyer - "+Thread.currentThread().getName());
			return "Hello Supplier";
		});
		System.out.println("I am still still in main - "+Thread.currentThread().getName());
		String value= completeableFutureWithSupplier.join();
		System.out.println("Get result from future: "+value);
	}
	
	public void testCallback() {
		
		System.out.println("Start testing callback");
		
//		thenApply() returns a value<T>
//		thenAccept() returns void
//		thus completeableFuture is type CompletableFuture<Void>
		CompletableFuture<Void> completeableFuture = CompletableFuture.supplyAsync(() -> {
			delay(1);
			System.out.println("I am in - "+Thread.currentThread().getName());
			return "David";
		}).thenApply(s -> {
			delay(1);
			System.out.println("I am in - "+Thread.currentThread().getName());
			return "Hello "+s;
		}).thenAccept(s-> {
			delay(1);
			System.out.println("I am in - "+Thread.currentThread().getName());
			System.out.println("Finished "+s);
		});
		
		completeableFuture.join();
	}
	
	public void testCompose() {
		
		System.out.println("Start testing compose");
		//chain CompleteFuture together, one function will run given the result from the one before
		//Check https://stackoverflow.com/questions/43019126/completablefuture-thenapply-vs-thencompose/43116156
		//for the difference btw thenApply() and thenCompose()
		CompletableFuture<String> future = getUserDetails().thenCompose(s -> getWishList(s));
		
		delay(4);
		future.join();
	}
	
	public void testCombine() {
		//thenCombine() will run two completeableFuture functions simultaneously together
		//it takes a function combines the output of both future function
		CompletableFuture<Boolean> future = getUserDetails().thenCombine(getWeatherReport(), (u,w) -> {
			System.out.println("Receive results of both user and weather");
			delay(1);
			System.out.println(String.format("Send %s report %s", u, w));
			return true;
		});
		delay(3);
		future.join();
	}
	
	
	public void testWaitMultipleFuture() {
		//Use an array of CompletableFuture as args, all the future will run simultaneously
		//Future complete when all of them are completed 
		CompletableFuture<Void> future = CompletableFuture.allOf(getUserDetails(), getWeatherReport(), getCategory());
		//Time runs is the future that runs the longest
		future.join();
	}
	
	public void testHandleException() {
		CompletableFuture<Integer> future;
		//handle() takes two parameters, first is the returned value of future, second is exception
		//if e is not null, we can handle any failure
		//otherwise handle the returned value from future
		future = addValues(6, 8).handle((i, e)-> {
			if(e != null) {
				System.out.println(e.getMessage());
				System.err.println("Addition failed!");
				return 0;
			}
			return i;
		});
		System.out.println("Calculate result: "+ future.join());
		
		//exceptionally() works the same, but only be called when an exception is thrown
		future = addValues(0, 5).exceptionally((e) -> {
			System.err.println("Addition failed");
			return 0;
		});
		System.out.println("Calculate result: "+ future.join());
			
	}
	
	private CompletableFuture<Integer> addValues(int i, int j) {
		return CompletableFuture.supplyAsync(() -> {
			if(i==0 || j==0) throw new RuntimeException("Error: Found zero as an input");
			return i+j;
		});
	}
	
	private CompletableFuture<String> getUserDetails() {
		return CompletableFuture.supplyAsync(() -> {
			delay(2);
			System.out.println("I am in getUserDetails() - "+Thread.currentThread().getName());
			return "super user";
		});
	}
	
	private CompletableFuture<String> getWeatherReport() {
		return CompletableFuture.supplyAsync(() -> {
			delay(3);
			System.out.println("I am in getWeatherReport() - "+Thread.currentThread().getName());
			return "local weather report";
		});
	}
	
	private CompletableFuture<String> getCategory() {
		return CompletableFuture.supplyAsync(() -> {
			delay(4);
			System.out.println("I am in getCategory() - "+Thread.currentThread().getName());
			return "Thriller";
		});
	}
	
	
	private CompletableFuture<String> getWishList(String user) {
		return CompletableFuture.supplyAsync(() -> {
			delay(3);
			System.out.println("I am in getWishList() - "+Thread.currentThread().getName());
			return "Get wish list for "+user;
		});
	}

}
