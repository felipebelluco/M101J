package com.mongodb;

import static spark.Spark.*;

public class SparkRoutes {

    public static void main(String[] args) {
        get("/", (request, response) -> "Hello World");

        get("/test", (request, response) -> "This is a test page");

        get("/echo/:thing", (request, response) -> request.params(":thing"));
    }

}
