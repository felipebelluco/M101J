package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

import static spark.Spark.*;

public class SparkFormHandling {

    public static void main(String[] args) {
        get("/", (req, res) -> {
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");

            StringWriter writer = new StringWriter();

            try {
                HashMap<String, Object> params = new HashMap<>();
                params.put("fruits", Arrays.asList("Apple", "Orange", "Banana", "Peach"));

                Template template = configuration.getTemplate("fruitPicker.ftl");
                template.process(params, writer);

                return writer;
            } catch (Exception e) {
                throw halt(500);
            }
        });

        post("/favorite_fruit", (req, res) -> {
            String fruit = req.queryParams("fruit");
            return fruit == null ? "Why don't you pick one?" : String.format("Your favorite fruint is %s!", fruit);
        });
    }

}
