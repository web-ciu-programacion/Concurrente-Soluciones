package ciu.prod.cons;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumidor implements Runnable {

		// atributos
	private String nombre;
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queueBuffer;
	private Queue queueCapacidadBuffer;
	
		// constructor
	public Consumidor(String nombre, String queueBufferName, String queueCapacidadBufferName, String mqAddress) throws JMSException {
		super();
		this.nombre = nombre;
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
			// consume
			System.out.println(this.nombre + " esperando item a consumir...");
			MessageConsumer messageConsumer = this.session.createConsumer(this.queueBuffer);
			Message message = (ObjectMessage) messageConsumer.receive(); // bloquea
			ObjectMessage objectMessage = (ObjectMessage) message;
			messageConsumer.close();
			Item item = (Item)objectMessage.getObject();
			System.out.println(this.nombre + " consumio item [" + item.getDescripcion() + "]");

			// envia mensaje a buffer capacidad (desbloquea un productor)
			MessageProducer messageProducer = this.session.createProducer(this.queueCapacidadBuffer);
			message = this.session.createTextMessage(Main.TEXTO);
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
	
	public String getNombre() {
		return nombre;
	}
}
