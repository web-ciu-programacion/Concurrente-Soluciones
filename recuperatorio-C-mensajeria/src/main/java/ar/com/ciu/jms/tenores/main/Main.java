package ar.com.ciu.jms.tenores.main;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import ar.com.ciu.jms.tenores.modelo.Color;

public class Main {
	public static final Integer CANTIDAD_DE_JUGADAS_POR_COLOR = 10;
	public static final String COLOR_NEGRO = "NEGRO";
	public static final String COLOR_BLANCO = "BLANCO";

	private static final String QUEUE = "queue-1";
	
	public static void main(String[] args) {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(QUEUE);
			// Se envía mensaje testigo para MUTEX.
			MessageProducer messageProducer = session.createProducer(queue);
			Message message = session.createTextMessage(COLOR_BLANCO); // Empieza la partida.
			messageProducer.send(message);
			messageProducer.close();
			session.close();
			connection.close();
			// Fin envío mensaje testigo para MUTEX.
			Thread blanco = new Thread(new Color(QUEUE, "tcp://localhost:61616", COLOR_BLANCO, CANTIDAD_DE_JUGADAS_POR_COLOR));
			Thread negro = new Thread(new Color(QUEUE, "tcp://localhost:61616", COLOR_NEGRO, CANTIDAD_DE_JUGADAS_POR_COLOR));
			blanco.start();
			negro.start();
			blanco.join();
			negro.join();
			System.out.println("Final partida.");			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
