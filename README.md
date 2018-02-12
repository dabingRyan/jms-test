# jms-test
使用jms发送消息至ActiveMQ

## 1.安装 ActiveMQ
windows下安装
下载链接：http://activemq.apache.org/download.html
解压后进入：D:\apache-activemq-5.15.3\bin\win64
    点击 activemq.bat 即可启动activemq
    点击 InstallService.bat 即安装服务运行，可设置为自动或手动启动

    二者启动方式选一：启动成功后可浏览器访问查看：http://127.0.0.1:8161 [默认端口：8161]
    登录：admin/admin

## 2.运行实例代码

队列模式：
    运行 com.bing.jms.queue 下的 生产者 AppProducer 发送100个消息
    运行 com.bing.jms.queue 下的 消费者 AppConsumer 可接收消息

主题模式：
    运行 com.bing.jms.topic 下的对应代码即可

    *注意：* 主题模式下，消费者必须先启动，否则无法接收启动之前生产者已经发送的消息。