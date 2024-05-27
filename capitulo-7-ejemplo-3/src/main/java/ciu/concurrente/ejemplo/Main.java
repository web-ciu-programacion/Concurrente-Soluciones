package ciu.concurrente.ejemplo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 *  Ejemplo de receive bloqueante.
 *  No hace falta crear la queue: queue-1.
 *  Enviar un mensaje desde: http://127.0.0.1:8161/admin/queues.jsp
 */
public class Main {

	public static void main(String[] args) throws JMSException {
		Connection connection = null;
		Session session = null;
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("queue-1");
			// Consumer
			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			System.out.println(Thread.currentThread().getName());
			System.out.println("esperando mensaje...");
			TextMessage textMsg = (TextMessage) consumer.receive();
			System.out.println("Received: " + textMsg.getText());
			System.out.println("Fin");
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
