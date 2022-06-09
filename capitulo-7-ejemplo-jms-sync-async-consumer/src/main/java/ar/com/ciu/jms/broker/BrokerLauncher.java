package ar.com.ciu.jms.broker;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

/*
 * El BrokerService levanta un servicio donde puedo crear queues, topic en ActiveMQ.
 * No lo utilizo más.
 * Ahora utilizamos levantar ActiveMQ mediante:
 * $ ./activemq start (luego ir a browser)
 */
public class BrokerLauncher {

	public static void main(String[] args) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		broker.start();
	}

}
