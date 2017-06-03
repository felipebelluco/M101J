package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

import static spark.Spark.*;

public class FavoriteFruit {

    public static void main(String[] args) {
        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();

            try {
                HashMap<String, Object> params = new HashMap<>();
                params.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

                Template template = getFreemarkerConfig().getTemplate("fruitPicker.ftl");
                template.process(params, writer);

                return writer;
            } catch (Exception e) {
                halt(500);
                return null;
            }
        });

        post("/favorite_fruit", (req, res) -> {
            String fruit = req.queryParams("fruit");
            if(fruit == null) {
                return "Why don't you pick one?";
            } else {
                return String.format("Your favorite fruint is %s!", fruit);
            }
        });
    }

    private static Configuration getFreemarkerConfig() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FavoriteFruit.class, "/");
        return configuration;
    }

}
