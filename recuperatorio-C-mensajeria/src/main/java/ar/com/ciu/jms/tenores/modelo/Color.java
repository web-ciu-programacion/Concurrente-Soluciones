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

public class Color implements Runnable {
		// atributos
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private Queue queue;
	private String color;
	private Integer cantidadDeJugadas;
		// constructor
	public Color(String queueName, String mqAddress, String color, Integer cantidadDeJugadas) throws JMSException {
		super();
		this.connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		this.connection = this.connectionFactory.createConnection();
		this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.queue = this.session.createQueue(queueName);
		this.cantidadDeJugadas = cantidadDeJugadas;
		this.color = color;
	}
		// metodos
	@Override
	public void run() {
		try {
			MessageConsumer messageConsumer = this.session.createConsumer(this.queue);
			MessageProducer messageProducer = this.session.createProducer(this.queue);
			this.connection.start();

			String colorProximaJugada = "";
			while (cantidadDeJugadas>0) {
				TextMessage textMessage = (TextMessage) messageConsumer.receive();
				colorProximaJugada = textMessage.getText();
				if (this.color.equals(colorProximaJugada)) {
					this.cantidadDeJugadas = this.cantidadDeJugadas - 1;
					this.moverPieza();
				}
				Message message = this.session.createTextMessage(this.opuesto());
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
	private void moverPieza() {
		System.out.println("Movió: " + this.color + " - Jugada: " + (Main.CANTIDAD_DE_JUGADAS_POR_COLOR-this.cantidadDeJugadas));
	}
	private String opuesto() {
		if (Main.COLOR_BLANCO.equals(this.color)) {
			return Main.COLOR_NEGRO;
		}
		return Main.COLOR_BLANCO;
	}
}