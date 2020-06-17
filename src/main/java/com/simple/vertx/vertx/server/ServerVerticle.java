package com.simple.vertx.vertx.server;

import java.util.HashSet;
import java.util.Set;

import com.simple.vertx.vertx.controller.FileController;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class ServerVerticle extends AbstractVerticle {


    private FileController fileController;

    @Override
    public void start(Future<Void> future){

        this.fileController = new FileController(vertx);


        Router router = Router.router(vertx);

        Set<String> allowedHeaders = new HashSet<>();

        allowedHeaders.add("x-requested-width");
        allowedHeaders.add("Access-Control-Allow-Origin");
        allowedHeaders.add("origin");
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("accept");
        allowedHeaders.add("X-PINGARUNER");

        Set<HttpMethod> allowedMethods = new HashSet<>();
        

    }

}