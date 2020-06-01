package java8Practice.guidetovertx;

import io.vertx.core.Vertx;

public class VertxTutorial {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle());

    }

}
