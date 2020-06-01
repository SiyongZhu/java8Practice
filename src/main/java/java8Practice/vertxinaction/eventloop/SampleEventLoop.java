package java8Practice.vertxinaction.eventloop;

public class SampleEventLoop {

    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        new Thread( () -> {
            for(int i=0; i<6; i++) {
                delay(500);
                System.out.println("1st thread running "+i);
                eventLoop.dispatch(new Event("tick", i));
            }
            eventLoop.dispatch(new Event("stop", ""));
            
        }).start();
        
        new Thread( () -> {
            delay(2500);
            eventLoop.dispatch(new Event("hello", "beautiful world"));
            delay(800);
            eventLoop.dispatch(new Event("hello", "universe"));
            
        }).start();
        
        eventLoop.dispatch(new Event("hello", "main"));
        eventLoop.dispatch(new Event("foo", "bar"));
        eventLoop
            .on("hello", s -> System.out.println("hello "+ s))
            .on("tick", n -> System.out.println("tick " + n))
            .on("stop", v -> eventLoop.stop())
            .run();
        System.out.println("bye bye");

    }
    
    private static void delay(long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

}
