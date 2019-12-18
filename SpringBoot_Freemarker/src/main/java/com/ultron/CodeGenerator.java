package com.ultron;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 * @author pixel
 */
public class CodeGenerator {

    private static final String TEMPLATE_PATH = "src/main/resources/templates";
    private static final String CLASS_PATH = "src/main/java/com/ultron/entity/";

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        Writer writer = null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));

            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classpath", "com.ultron.entity");
            dataMap.put("classname", "User");

            Template template = configuration.getTemplate("generater.ftl");

            File docFile = new File(CLASS_PATH + "User.java");
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));

            template.process(dataMap, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                    writer.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
