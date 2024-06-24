package ar.com.ciu.concurrente;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 *  fuente: poner este ejemplo: https://www.codenotfound.com/jms-publish-subscribe-messaging-example-activemq-maven.html
 */
public class JmsPublisherTopic {

	private String clientId;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;

	public void create(String clientId, String topicName) throws JMSException {
		this.clientId = clientId;

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		this.connection = connectionFactory.createConnection();
		this.connection.setClientID(this.clientId);

		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = this.session.createTopic(topicName);

		// messageProducer que enviara los mensajes
		this.messageProducer = session.createProducer(topic);
	}

	public void closeConnection() throws JMSException {
		connection.close();
	}

	public void sendName(String noticia) throws JMSException {
		TextMessage textMessage = this.session.createTextMessage(noticia);
		this.messageProducer.send(textMessage);
		System.out.println(this.clientId + " publico el mensaje: " + noticia);
	}

}
