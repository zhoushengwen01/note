package com.zhou.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConstantUtil {

    public static Properties getProperties() {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ConstantUtil.class.getClassLoader().getResourceAsStream("rabbitMQ.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}
