package java8Practice.vertxinaction.ch2.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class HelloVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(HelloVerticle.class);
    private long counter = 1;
    
   
    
    @Override
    public void start() throws Exception {
        vertx.setPeriodic(5000, id -> logger.info("tick "+id));
        
        vertx.createHttpServer()
            .requestHandler(req -> {
                logger.info("Request #{} from {}", counter++, req.remoteAddress().host());
                req.response().end("Wola Wola Hello!");
            }).listen(8090);
        logger.info("Open http://localhost:8090/");
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HelloVerticle());
        
        

    }

}
