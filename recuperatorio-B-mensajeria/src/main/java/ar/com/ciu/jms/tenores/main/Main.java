package ar.com.ciu.jms.tenores.main;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import ar.com.ciu.jms.tenores.modelo.Compartida;
import ar.com.ciu.jms.tenores.modelo.Sumador;

public class Main {

	private static final String QUEUE = "queue-1";
	
	public static void main(String[] args) {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(QUEUE);
			// Se envía mensaje testigo para MUTEX.
			MessageProducer messageProducer = session.createProducer(queue);
			Message message = session.createTextMessage("Lamadrid");
			messageProducer.send(message);
			messageProducer.close();
			session.close();
			connection.close();
			// Fin envío mensaje testigo para MUTEX.
			Thread sumadorA = new Thread(new Sumador(QUEUE, "tcp://localhost:61616", 5000), "Sumador A");
			Thread sumadorB = new Thread(new Sumador(QUEUE, "tcp://localhost:61616", 3000), "Sumador B");
			sumadorB.start();
			sumadorA.start();
			sumadorA.join();
			sumadorB.join();
			System.out.println("valor: " + Compartida.total + ".");			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
