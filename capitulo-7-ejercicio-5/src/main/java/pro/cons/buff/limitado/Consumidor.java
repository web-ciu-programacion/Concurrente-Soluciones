package pro.cons.buff.limitado;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
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
	private BufferMessageListener listener;
	private Item item;
	
		// constructor
	public Consumidor(String nombre, String queueBufferName, String queueCapacidadBufferName, String mqAddress) throws JMSException {
		super();
		this.nombre = nombre;
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queueBuffer = this.session.createQueue(queueBufferName);
		this.queueCapacidadBuffer = this.session.createQueue(queueCapacidadBufferName);
		MessageConsumer messageConsumer = this.session.createConsumer(this.queueBuffer);
		this.listener = new BufferMessageListener(messageConsumer, this);
		this.connection.start();
		System.out.println(nombre + " esperando item a consumir...");
	}
	
		// metodos
	@Override
	public void run() {
		try {
			this.suspender();
			this.consumir();
			this.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private void consumir() throws JMSException {
		System.out.println(Thread.currentThread().getName() + " consumio item [" + item.getDescripcion() + "]");
		MessageProducer messageProducer = this.session.createProducer(this.queueCapacidadBuffer);
		Message message = this.session.createTextMessage(Main.TEXTO);
		messageProducer.send(message);
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

	public void setItem(Item item) {
		this.item = item;
	}

}
