package java8Practice.guidetovertx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import java8Practice.guidetovertx.utils.PathParams;

public class MainVerticle extends AbstractVerticle {
    
    private final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

    
    @Override
    public void start() throws Exception {
        logger.info("Start Running MainVerticle");
        
//        vertx.createHttpServer().requestHandler(req -> {
//           req.response().end("Hello Vert.x World"); 
//        }).listen(8090);
        
        Router router = Router.router(vertx);
        
        
        
//        router.get("/api/v1/hello").handler(ctx -> {
//            ctx.request().response().end("Hello Vertex router");
//        });
//        router.get("/api/v1/hello/:name").handler(ctx ->{
//           String name = ctx.pathParam("name");
//           ctx.request().response().end(String.format("Hello %s!", name));
//        });
        router.get("/api/v1/hello").handler(this::helloVertx);
        router.get("/api/v1/hello/:name").handler(this::helloName);
        
        router.get("/api/v1/simple").handler(this::simpleVertx);
        router.get("/api/v1/simple/:name").handler(this::simpleName);
        vertx.createHttpServer().requestHandler(router).listen(8090);
        
        //Deploy a new Verticle
        vertx.deployVerticle(new SimpleVerticle());
    }
    
    void helloVertx(RoutingContext ctx) {
        ctx.request().response().end("Hello Vertex router");
    }
    
    void helloName(RoutingContext ctx) {
        String name = ctx.pathParam("name");
        ctx.request().response().end(String.format("Hello %s! You are running Vertx", name));
    }
    
    void simpleVertx(RoutingContext ctx) {
        vertx.eventBus().request(PathParams.SIMPLE_ADDR, "", reply -> {
            ctx.request().response().end((String)reply.result().body());
         
        });
    }
    
    void simpleName(RoutingContext ctx) {
        String name = ctx.pathParam("name");
        vertx.eventBus().request(PathParams.SIMPLE_NAME, name, reply -> {
            ctx.request().response().end((String)reply.result().body());
        });
    }
}
