package com.zhou.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zhou.constant.ConnectionConstant;

import java.io.IOException;


public class ConnectionUtil {


    public static Connection getConnection() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ConnectionConstant.HOST);
        factory.setVirtualHost(ConnectionConstant.VIRTUAlHOST);
        factory.setUsername(ConnectionConstant.USERNAME);
        factory.setPassword(ConnectionConstant.PASSWORD);

        Connection connection = factory.newConnection();
        return connection;

    }
}
