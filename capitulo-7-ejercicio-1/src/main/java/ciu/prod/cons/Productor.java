package ciu.prod.cons;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Productor implements Runnable {

		// atributos
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queue;
	
		// constructor
	public Productor(String queueName, String mqAddress) throws JMSException {
		super();
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = this.session.createQueue(queueName);
	}

		// metodos
	@Override
	public void run() {
		final String messageContent = "Lamadrid"; 
		try {
			MessageProducer messageProducer = this.session.createProducer(this.queue);
			Message message = this.session.createTextMessage(messageContent);
			System.out.println(Thread.currentThread().getName() + " coloco mensaje [" + messageContent + "]");
			messageProducer.send(message);
			messageProducer.close();
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
