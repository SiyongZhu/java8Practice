package java8Practice.vertxinaction.eventloop;

public final class Event {
    private final String key;
    private final Object data;
    
    public Event(String key, Object data) {
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public Object getData() {
        return data;
    }
}
