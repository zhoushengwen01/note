package com.zhou.simplemq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhou.utils.ConnectionUtil;

import java.io.IOException;

public class Send_simple {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "hello world";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }


}
