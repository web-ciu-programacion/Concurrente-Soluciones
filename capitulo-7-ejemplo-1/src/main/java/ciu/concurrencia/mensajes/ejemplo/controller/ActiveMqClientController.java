package ciu.concurrencia.mensajes.ejemplo.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciu.concurrencia.mensajes.ejemplo.config.Message;

@RestController
@RequestMapping("/api")
public class ActiveMqClientController {

    @Autowired
    private Queue queue;
    
	@Autowired
	private JmsTemplate jmsTemplate;

	/*
	 * REQUEST: localhost:8080/api/send
	 */
	@GetMapping("/send")
    public void sendQueue() {
		try {
	        this.jmsTemplate.convertAndSend(this.queue, Message.MESSAGE_BODY);
	        System.out.println("Message published successfully on queue: " + this.queue.getQueueName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
