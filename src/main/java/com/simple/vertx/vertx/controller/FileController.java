package com.simple.vertx.vertx.controller;

import com.simple.vertx.vertx.model.File;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class FileController {

// Nurzod
    private FilePostgreSQLClient filePostgreSQLClient;

    public FileController(Vertx vertx){
        this.filePostgreSQLClient = new FilePostgreSQLClient(vertx);
    }

    public Future<Long> add(File file){
      return  this.filePostgreSQLClient.addFileCommand(1L, file);
    }

}