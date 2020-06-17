package com.simple.vertx.vertx.controller;

import com.simple.vertx.vertx.MainVerticle;
import com.simple.vertx.vertx.model.File;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Tuple;

public class FilePostgreSQLClient{

    private PgPool client;
    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

    public FilePostgreSQLClient(Vertx vertx) {
        
        PgConnectOptions connectOptions = new PgConnectOptions()
        .setPort(5432)
        .setHost("localhost")
        .setDatabase("file")
        .setUser("file")
        .setPassword("123");

        PoolOptions poolOptions = new PoolOptions().setMaxSize(5);
        client = PgPool.pool(vertx ,connectOptions,poolOptions);
    }

    public Future<Long> addFileCommand(Long loginId , File file){
        Promise<Long> promise = Promise.promise();
        client.preparedQuery( "SELECT file_add AS file_id" 
        + " FROM registration.file_add($1, $2, $3, $4, $5, $6, $7);",
        Tuple.of( 
          loginId,
          file.getName(),
          file.getDisplayName(),
          file.getUniqueName(),
          file.getDiscription(),
          file.getSize(),
          file.getMimeType()
              ),ar -> {
                  LOGGER.info("info: handle addFileCommand query result");
                  if (ar.succeeded()) {
                    System.out.println("Got " + ar.result().size() + " rows ");
                    for (Row row : ar.result()) {
                      LOGGER.info("info: handle query addFileCommand result - ok");
                      promise.complete(row.getLong("file_id"));
                    }
        
                    if (promise.tryComplete()) {
                      LOGGER.info("info: handle query addFileCommand result - no result");
                    }
                  } else {
                    LOGGER.error("info: handle query addFileCommand result - failed");
                    promise.fail(ar.cause());
                  }
                });
            return promise.future();
    }

    
}