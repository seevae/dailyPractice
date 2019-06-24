package com.ming.client;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成逆向工程文件的类(考走直接运行)
 */
public class GeneratorToolsClient {

    public void generate() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //容易报错：  classpath file not be found exception
        File configFile = new File("src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


    public static void main(String[] args) {
        try {
            GeneratorToolsClient myGenerator = new GeneratorToolsClient();
            myGenerator.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
