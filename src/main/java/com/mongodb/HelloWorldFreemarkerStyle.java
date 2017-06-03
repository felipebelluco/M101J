package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

public class HelloWorldFreemarkerStyle {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        StringWriter writer = new StringWriter();
        try {
            Template template = configuration.getTemplate("hello.ftl");
            HashMap<String, Object> params = new HashMap<>();
            params.put("name", "Freemarker");

            template.process(params, writer);

            System.out.println(writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
