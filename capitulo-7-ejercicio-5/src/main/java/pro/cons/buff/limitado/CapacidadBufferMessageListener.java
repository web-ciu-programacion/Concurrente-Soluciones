package pro.cons.buff.limitado;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class CapacidadBufferMessageListener implements MessageListener {

		// atributos
	private Productor productor;
	private MessageConsumer messageConsumer;

		// constructor
	public CapacidadBufferMessageListener(MessageConsumer messageConsumer, Productor productor) throws JMSException {
		super();
		this.messageConsumer = messageConsumer;
		this.messageConsumer.setMessageListener(this);
		this.productor = productor;
	}

		// metodos
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			textMessage.getText();
			System.out.println(this.productor.getNombre() + " tomo lugar en buffer");
			this.close();
			this.productor.reanudar();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void close() throws JMSException {
		this.messageConsumer.close();		
	}

}
