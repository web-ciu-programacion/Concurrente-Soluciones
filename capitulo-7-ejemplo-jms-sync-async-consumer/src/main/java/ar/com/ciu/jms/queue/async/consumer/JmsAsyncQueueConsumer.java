package ar.com.ciu.jms.queue.async.consumer;

import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsAsyncQueueConsumer {

    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws URISyntaxException, Exception {
        JmsAsyncQueueConsumer asyncReceiveClient = new JmsAsyncQueueConsumer();
        asyncReceiveClient.receiveMessages();
        System.out.println("Finalizo consumidor!");
    }

    public void receiveMessages() throws JMSException, InterruptedException {
        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        try {
            Queue queue = session.createQueue("queue-1");
            MessageConsumer consumer = session.createConsumer(queue);
            ConsumerMessageListener consumerListener = new ConsumerMessageListener("Customer");
            consumer.setMessageListener(consumerListener);
            consumerListener.setJmsConsumerAsyncQueueClient(this);
            connection.start();
            latch.await();
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void latchCountDown() {
        latch.countDown();
    }

}
