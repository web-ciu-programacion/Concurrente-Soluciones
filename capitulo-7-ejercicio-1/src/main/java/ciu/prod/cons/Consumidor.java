package ciu.prod.cons;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumidor implements Runnable {

		// atributos
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queue;
	
		// constructor
	public Consumidor(String nombre, String queueName, String mqAddress) throws JMSException {
		super();
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = this.session.createQueue(queueName);
		this.connection.start();
	}

		// metodos
	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			MessageConsumer consumer = this.session.createConsumer(this.queue);
			System.out.println(t.getName() + " esperando mensaje...");
			TextMessage textMessage = (TextMessage) consumer.receive(); // bloquea
			System.out.println(t.getName() + " consumio mensaje [" + textMessage.getText() + "]");
			this.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void close() throws JMSException {
		this.session.close();
		this.connection.close();
	}

}
