package ar.com.ciu.jms.queue.sync.consumer;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * cunsumer sync queda esperando por mensajes en la cola si no hay
 */
public class JmsSyncQueueConsumer {

	public static void main(String[] args) throws URISyntaxException, Exception {
		Connection connection = null;
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		try {
			Queue queue = session.createQueue("queue-1");
			// Consumer
			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			System.out.println("esperando mensaje...");
			TextMessage textMsg = (TextMessage) consumer.receive();
			//System.out.println(textMsg);
			System.out.println("Received: " + textMsg.getText());
		} finally {
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

}
