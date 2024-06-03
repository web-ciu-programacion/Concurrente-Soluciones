package ciu.prod.cons;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Productor implements Runnable {

		// atributos
	private String nombre;
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queueBuffer;
	private Queue queueCapacidadBuffer;
	private String descripcionItem;
	
		// constructor
	public Productor(String nombre, String descripcionItem, String queueBufferName, String queueCapacidadBufferName, String mqAddress) throws JMSException {
		super();
		this.nombre = nombre;
		this.descripcionItem = descripcionItem;
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queueBuffer = this.session.createQueue(queueBufferName);
		this.queueCapacidadBuffer = this.session.createQueue(queueCapacidadBufferName);
		this.connection.start();
	}
	
		// metodos
	@Override
	public void run() {
		try {
			MessageConsumer messageConsumer = this.session.createConsumer(this.queueCapacidadBuffer);
			System.out.println(this.nombre + " esperando lugar en buffer...");
			TextMessage textMessage = (TextMessage) messageConsumer.receive(); // bloquea
			System.out.println(this.nombre + " obtuvo lugar en el buffer (" + textMessage.getText() + ")");
			messageConsumer.close();
			// Producir
			this.producir();
			this.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void producir() throws JMSException {
		Item item = new Item(this.descripcionItem);
		MessageProducer messageProducer = this.session.createProducer(this.queueBuffer);
		ObjectMessage objectMessage = this.session.createObjectMessage();
		objectMessage.setObject(item);
		System.out.println(this.nombre + " producio item [" + item.getDescripcion() + "]");
		messageProducer.send(objectMessage);
		messageProducer.close();
	}

	private void close() throws JMSException {
		this.session.close();
		this.connection.close();
	}

	public String getNombre() {
		return nombre;
	}

}
