package pro.cons.buff.limitado;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Utils {

	public static void sendMessage(String queueName, String mqAddress) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(mqAddress);
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(queueName);
		MessageProducer messageProducer = session.createProducer(queue);
		Message message = session.createTextMessage(Main.TEXTO);
		System.out.println(Thread.currentThread().getName() + " UTILS -> envio mensaje [" + Main.TEXTO + "] cola [" + queueName + "]");
		messageProducer.send(message);
		messageProducer.close();
		session.close();
		connection.close();
	}

}
