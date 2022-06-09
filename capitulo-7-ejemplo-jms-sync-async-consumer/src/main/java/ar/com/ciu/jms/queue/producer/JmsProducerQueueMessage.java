package ar.com.ciu.jms.queue.producer;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Producer.
 * Envía mensajes a la queue.
 */
public class JmsProducerQueueMessage {

	public static void main(String[] args) throws URISyntaxException, Exception {
		Connection connection = null;
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("queue-1");
			MessageProducer messageProducer = session.createProducer(queue);
			String preBody = "Lamadrid";
			for (int i = 0; i < 10; i++) {
				String body = preBody + i;
				Message message = session.createTextMessage(body);
				System.out.println("Enviando mensaje [" + body + "]");
				messageProducer.send(message);
			}
//			messageProducer.send(session.createTextMessage("END"));
			session.close();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
