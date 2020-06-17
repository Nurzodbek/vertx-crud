package com.simple.vertx.vertx;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;


public class MainVerticle extends AbstractVerticle {


  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }



  // HttpServerOptions options = new HttpServerOptions().setMaxWebSocketFrameSize(1000000);
  @Override
  public void start(){

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    router.route().handler(routingContext->{
      HttpServerResponse  response = routingContext.response();
      response.putHeader("content-type", "text/plain");
      response.end("Salom do`stlar");
    });

    server.requestHandler(router).listen(8080);

  }

  
  




  
}





// @Override
  // public void start(Future<Void> startFuture) throws Exception {
  //   vertx.createHttpServer().requestHandler(req -> {

  //     req.response()
  //       .putHeader("content-type", "text/plain")
  //       .end("Hello from Vert.x!");

  //   }).listen(8888, http -> {
  //     if (http.succeeded()) {
  //       startFuture.complete();
  //       System.out.println("HTTP server started on port 8888");
  //     } else {
  //       startFuture.fail(http.cause());
  //     }
  //   });
  // }