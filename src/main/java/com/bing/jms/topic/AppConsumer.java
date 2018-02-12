package com.bing.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @package：com.bing.jms.queue
 * @des：
 * @autor ：王兵【wb38113】
 * @createTime： 2018/2/12-14:12
 */
public class AppConsumer {

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

        //6.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //7.启动监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收到消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
