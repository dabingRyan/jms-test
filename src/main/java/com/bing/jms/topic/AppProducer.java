package com.bing.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @package：com.bing.jms.queue
 * @des：
 * @autor ：王兵【wb38113】
 * @createTime： 2018/2/12-13:51
 */
public class AppProducer {

    private static final String url = "tcp://10.101.48.24:61616";
    private static final String TOPIC_NAME = "test-topic";

    public static void main(String[] args) throws Exception {
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2.创建Connection
        Connection connection = connectionFactory.createConnection();

        //3.启动
        connection.start();

        //4.创建Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.创建目标
        Destination destination = session.createTopic(TOPIC_NAME);

        //6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 1; i <= 100; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("testMessage" + i);
            //8.发送消息
            producer.send(textMessage);
            System.out.println("发送消息：" + textMessage.getText());
        }

        //9.关闭连接
        connection.close();
    }
}
