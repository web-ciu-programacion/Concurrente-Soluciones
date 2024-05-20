package ciu.concurrencia.mensajes.ejemplo.server;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import ciu.concurrencia.mensajes.ejemplo.config.ActiveMqQueueConfig;

/*
 *  Listener que consume mensajes de la queue siempre que haya.
 */

@Component
public class ActiveMqServer {

	@JmsListener(destination = ActiveMqQueueConfig.QUEUE)
	public void receiveQueue(String message) {
		System.out.println ("Monitor de cola: " + ActiveMqQueueConfig.QUEUE);
		System.out.println(message);
	}

}
