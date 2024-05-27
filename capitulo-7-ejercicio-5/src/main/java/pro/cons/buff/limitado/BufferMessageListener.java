package pro.cons.buff.limitado;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class BufferMessageListener implements MessageListener {

		// atributos
	private Consumidor consumidor;
	private MessageConsumer messageConsumer;
	
		// constructor
	public BufferMessageListener(MessageConsumer messageConsumer, Consumidor consumidor) throws JMSException {
		super();
		this.messageConsumer = messageConsumer;
		this.messageConsumer.setMessageListener(this);
		this.consumidor = consumidor;
	}
	
		// metodos
	@Override
	public void onMessage(Message message) {
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			Item item = (Item)objectMessage.getObject();
			this.messageConsumer.close();
			this.consumidor.setItem(item);
			this.consumidor.reanudar();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws JMSException {
		this.messageConsumer.close();		
	}

}
