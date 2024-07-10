package ar.com.ciu.jms.tenores.modelo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sumador implements Runnable {
		// atributos
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queue;
	private Integer cantidad;
		// constructor
	public Sumador(String queueName, String mqAddress, Integer cantidad) throws JMSException {
		super();
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = this.session.createQueue(queueName);
		this.cantidad = cantidad;
	}
		// metodos
	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			String mensajeRecibido = "";
			MessageConsumer messageConsumer = this.session.createConsumer(this.queue);
			MessageProducer messageProducer = this.session.createProducer(this.queue);
			this.connection.start();
			
			for (int i = 0; i < this.cantidad; i++) {
				System.out.println(t.getName() + " esperando mensaje...");
				TextMessage textMessage = (TextMessage) messageConsumer.receive();
				mensajeRecibido = textMessage.getText();
				System.out.println(t.getName() + " recibio mensaje [" + textMessage.getText() + "]");
				Compartida.total += 1;
				Message message = this.session.createTextMessage(mensajeRecibido);
				messageProducer.send(message);
			}

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