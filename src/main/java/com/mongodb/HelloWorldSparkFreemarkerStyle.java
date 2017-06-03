package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;

import static spark.Spark.*;

public class HelloWorldSparkFreemarkerStyle {

    private static final String PATH = "/";

    public static void main(String[] args) {
        get(PATH, (request, response) -> {
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, PATH);

            StringWriter writer = new StringWriter();

            try {
                Template template = configuration.getTemplate("hello.ftl");
                HashMap<String, Object> params = new HashMap<>();
                params.put("names", "Spark & Freemarker");

                template.process(params, writer);

                return writer;
            } catch (Exception e) {
                throw halt(500);
            }
        });
    }

}
