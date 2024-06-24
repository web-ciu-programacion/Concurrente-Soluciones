package ar.com.ciu.concurrente;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsSubscriberTopic {

	private static final String NO_MENSAJE = "no mensaje";

	private Connection connection;
	private MessageConsumer messageConsumer;

	public void subscribe(String clientId, String topicName) throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		this.connection = connectionFactory.createConnection();
		this.connection.setClientID(clientId);

		Session session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = session.createTopic(topicName);

		this.messageConsumer = session.createConsumer(topic);

		this.connection.start();
	}

	public void closeConnection() throws JMSException {
		this.connection.close();
	}

	public String getNoticia(int timeout) throws JMSException {
		String texto = NO_MENSAJE;

		Message message = this.messageConsumer.receive(timeout);

		if (message != null) {
			TextMessage textMessage = (TextMessage) message;
			texto = textMessage.getText();
			System.out.println(this.connection.getClientID() + " recibio mensaje: " + texto);
		} else {
			System.out.println(this.connection.getClientID() + " no tiene mensajes");
		}

		return texto;
	}

}
