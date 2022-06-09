package ar.com.ciu.jms.queue.async.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

	private String consumerName;
	private JmsAsyncQueueConsumer jmsConsumerAsyncQueueClient;

	public ConsumerMessageListener(String consumerName) {
		this.consumerName = consumerName;
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println(consumerName + " received " + textMessage.getText());
			if ("END".equals(textMessage.getText())) {
				jmsConsumerAsyncQueueClient.latchCountDown();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void setJmsConsumerAsyncQueueClient(JmsAsyncQueueConsumer asyncReceiveQueueClientExample) {
		this.jmsConsumerAsyncQueueClient = asyncReceiveQueueClientExample;
	}

}
