package pro.cons.buff.limitado;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Productor implements Runnable {

		// atributos
	private String nombre;
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queueBuffer;
	private Queue queueCapacidadBuffer;
	private CapacidadBufferMessageListener listener;
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
		MessageConsumer messageConsumer = this.session.createConsumer(this.queueCapacidadBuffer);
		this.listener = new CapacidadBufferMessageListener(messageConsumer, this);
		this.connection.start();
		System.out.println(nombre + " esperando lugar en buffer...");
	}
	
		// metodos
	@Override
	public void run() {
		try {
			this.suspender();
			this.producir();
			this.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void producir() throws JMSException {
		Item item = new Item(this.descripcionItem);
		MessageProducer messageProducer = this.session.createProducer(this.queueBuffer);
		ObjectMessage objectMessage = this.session.createObjectMessage();
		objectMessage.setObject(item);
		System.out.println(Thread.currentThread().getName() + " producio item [" + item.getDescripcion() + "]");
		messageProducer.send(objectMessage);
		messageProducer.close();
	}

	private synchronized void suspender() throws InterruptedException {
		this.wait();
	}
	
	public synchronized void reanudar() {
		this.notify();
	}
	
	private void close() throws JMSException {
		this.listener.close();
		this.session.close();
		this.connection.close();
	}

	public String getNombre() {
		return nombre;
	}

}
