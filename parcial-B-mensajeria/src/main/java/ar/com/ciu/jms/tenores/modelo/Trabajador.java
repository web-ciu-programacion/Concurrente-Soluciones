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

import ar.com.ciu.jms.tenores.main.Main;

public class Trabajador implements Runnable {

		// atributos
	private ConnectionFactory connectionFactory; private Connection connection; private Session session;
	private Queue queue;
	private Integer xyz;
	private Tarea tarea;
	
		// constructor
	public Trabajador(String queueName, String mqAddress, Integer xyz, Tarea tarea) throws JMSException {
		super();
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = this.session.createQueue(queueName);
		this.xyz = xyz;
		this.tarea = tarea;
	}

		// metodos
	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			Integer recibido = new Integer(-1);
			MessageConsumer messageConsumer = this.session.createConsumer(this.queue);
			this.connection.start();
			while (!this.xyz.equals(recibido)) {
				System.out.println(t.getName() + " esperando mensaje...");
				TextMessage textMessage = (TextMessage) messageConsumer.receive();
				recibido = Integer.valueOf(textMessage.getText());
				System.out.println(t.getName() + " recibio mensaje [" + recibido + "]");
				if (!recibido.equals(this.xyz)) {
					MessageProducer messageProducer = this.session.createProducer(this.queue);
					Message message = this.session.createTextMessage(recibido.toString());
					messageProducer.send(message);
					messageProducer.close();
				}
			}
			this.tarea.realizar();
			if (!Main.CANTIDAD_TOTAL_DE_MENSAJES.equals(recibido)) {
				MessageProducer messageProducer = this.session.createProducer(this.queue);
				recibido++;
				Message message = this.session.createTextMessage(String.valueOf(recibido));
				messageProducer.send(message);
				messageProducer.close();
			}
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