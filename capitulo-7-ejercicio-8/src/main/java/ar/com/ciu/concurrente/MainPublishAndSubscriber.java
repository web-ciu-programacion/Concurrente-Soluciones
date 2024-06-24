package ar.com.ciu.concurrente;

import javax.jms.JMSException;

public class MainPublishAndSubscriber {

	/*
	 * /opt/activemq/apache-activemq-6.1.2-bin/apache-activemq-6.1.2/bin$ ./activemq start
	 * http://127.0.0.1:8161/admin/
	 */
	public static void main(String[] args) {
		try {
			// topic futbol
			JmsPublisherTopic alejandroFabri = new JmsPublisherTopic();
			alejandroFabri.create("Alejandro Fabri", "FutbolTopic");

			// topic rojo
			JmsPublisherTopic karlMarx = new JmsPublisherTopic();
			karlMarx.create("Karl Marx", "RojoTopic");

			// suscriptores a deportes
			JmsSubscriberTopic suscriptor11 = new JmsSubscriberTopic();
			suscriptor11.subscribe("Juan De Los Palotes", "FutbolTopic");
			JmsSubscriberTopic suscriptor12 = new JmsSubscriberTopic();
			suscriptor12.subscribe("Hector Perez Picaro", "FutbolTopic");
			JmsSubscriberTopic suscriptor13 = new JmsSubscriberTopic();
			suscriptor13.subscribe("Fabiana Cantilo", "FutbolTopic");

			// suscriptores a rojo
			JmsSubscriberTopic suscriptor21 = new JmsSubscriberTopic();
			suscriptor21.subscribe("Lenin", "RojoTopic");
			JmsSubscriberTopic suscriptor22 = new JmsSubscriberTopic();
			suscriptor22.subscribe("Stalin", "RojoTopic");
			
			alejandroFabri.sendName("Ganó Lamadrid y se prende en el campeonato!");
			karlMarx.sendName("Nacionalización de todo YA!!!");
			
			alejandroFabri.closeConnection();
			karlMarx.closeConnection();

			suscriptor11.getNoticia(1000);
			suscriptor12.getNoticia(1000);
			suscriptor13.getNoticia(1000);

			suscriptor21.getNoticia(1000);
			suscriptor22.getNoticia(1000);

			suscriptor13.getNoticia(1000);
			suscriptor22.getNoticia(1000);

			suscriptor11.closeConnection();
			suscriptor12.closeConnection();
			suscriptor13.closeConnection();

			suscriptor21.closeConnection();
			suscriptor22.closeConnection();			

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
