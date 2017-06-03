package com.mongodb;

import static spark.Spark.*;

public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        get("/", (request, response) -> "Hello World From Spark");
    }
}
