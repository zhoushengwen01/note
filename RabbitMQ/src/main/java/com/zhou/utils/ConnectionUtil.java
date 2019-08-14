package com.zhou.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;


public class ConnectionUtil {


    public static Connection getConnection() throws IOException {
        Properties properties = ConstantUtil.getProperties();


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(String.valueOf(properties.get("host")));
        factory.setPort(Integer.valueOf(String.valueOf(properties.get("port"))));
        factory.setVirtualHost(String.valueOf(properties.get("virtualhost")));
        factory.setUsername(String.valueOf(properties.get("username")));
        factory.setPassword(String.valueOf(properties.get("password")));

        Connection connection = factory.newConnection();
        return connection;

    }
}
