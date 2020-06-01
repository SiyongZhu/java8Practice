package java8Practice.guidetovertx;

import io.vertx.core.AbstractVerticle;
import java8Practice.guidetovertx.utils.PathParams;

public class SimpleVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer(PathParams.SIMPLE_ADDR, msg -> {
            msg.reply("Hi, this is a simple verticle");
        });
        
        vertx.eventBus().consumer(PathParams.SIMPLE_NAME, msg -> {
           String name = (String)msg.body();
           msg.reply(String.format("Hello %s! This is simple vertx", name));
        });
    }
}
