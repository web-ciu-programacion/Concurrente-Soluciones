package ciu.concurrencia.mensajes.ejemplo.config;

import javax.annotation.PostConstruct;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqQueueConfig {

	public static final String BROKER_URL = "tcp://localhost:61616";
	public static final String QUEUE = "messages";
	
	@PostConstruct
	public void showConfig() {
		System.out.println("broker url: " + BROKER_URL);
		System.out.println("queue: " + QUEUE);
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue(QUEUE);
	}

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(BROKER_URL);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return  new JmsTemplate(activeMQConnectionFactory());
    }

}
