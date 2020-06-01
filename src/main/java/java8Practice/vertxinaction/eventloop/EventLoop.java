package java8Practice.vertxinaction.eventloop;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class EventLoop {

    private final ConcurrentLinkedDeque<Event> events = new ConcurrentLinkedDeque<Event>();
    private final ConcurrentHashMap<String, Consumer<Object>> handlers = new ConcurrentHashMap<>();
    
    public EventLoop on (String key, Consumer<Object> handler) {
        handlers.put(key, handler);
        return this;
    }
    
    public void dispatch(Event event) {
        events.add(event);
    }
    
    public void stop() {
        Thread.currentThread().interrupt();
    }
    
    public void run () {
        System.out.println("Start running function based on event type in event stack");
        while (!(events.isEmpty() && Thread.interrupted())) {
            if (!events.isEmpty()) {
                Event event = events.pop();
                if (handlers.containsKey(event.getKey())) {
                    handlers.get(event.getKey()).accept(event.getData());
                } else {
                    System.err.println("No handler for key " + event.getKey());
                } 
            }
           
        }
    }
    
    
}
