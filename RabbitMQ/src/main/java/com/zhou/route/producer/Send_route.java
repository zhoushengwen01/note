package com.zhou.route.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhou.utils.ConnectionUtil;

import java.io.IOException;

public class Send_route {

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();


        //声明exchange,direct:交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = "添加商品";
        channel.basicPublish(EXCHANGE_NAME, "insert", null, message.getBytes());

        System.out.println("[X] Sent '" + message + "'");

        channel.close();
        connection.close();

    }
}
