package com.ultron;

import cn.hutool.core.util.ObjectUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 * @author pixel
 */
public class CodeGenerator {

    private static final String ENCODING = "UTF-8";
    private static final String TEMPLATE_FILE = "generater.ftl";

    /**
     * 获取模板文件
     * @param fileName
     * @param encoding
     * @return
     * @throws IOException
     */
    public static Template getTemplate(String fileName, String encoding) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        if (ObjectUtil.isNull(fileName)){
            fileName = TEMPLATE_FILE;
        }
        if (ObjectUtil.isNull(encoding)){
            encoding = ENCODING;
        }
        Template template = configuration.getTemplate(fileName,encoding);
        return template;
    }

    /**
     * 获取结果集
     * @param documentPath
     * @return
     */
    public static Map<String,Object> getDataMap(String documentPath){
        Map<String,Object> maps = new HashMap<>();
        return maps;
    }

    /**
     * 生成实体模型
     * @param modelPath
     * @param modelName
     * @param fileName
     * @param encoding
     * @param documentPath
     * @throws TemplateException
     */
    public static void generaterModel(String modelPath,String modelName,String fileName,String encoding,String documentPath) throws TemplateException {
        File file = new File(modelPath+"/"+modelName);
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            getTemplate(fileName,encoding).process(getDataMap(documentPath),bufferedWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ObjectUtil.isNotNull(bufferedWriter)) {
                try {
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws TemplateException {
        generaterModel(null,null,null,null,null);
    }
}
