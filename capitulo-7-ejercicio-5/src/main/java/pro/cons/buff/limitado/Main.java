package pro.cons.buff.limitado;

import javax.jms.JMSException;

public class Main {

	public static final String QUEUE_NAME = "buffer";
	public static final String QUEUE_CAPACIDAD_BUFFER = "capacidad-buffer";
	public static final String MQ_ADDRESS = "tcp://localhost:61616";

	public static final String TEXTO = "Lamadrid";
	public static final int CAPACIDAD_BUFFER = 5;

	/*
	 * Prodctor / Consumidor
	 * Buffer Limitado
	 * Receive No bloqueante (bloqueante con primitivAS)
	 */
	public static void main(String[] args) {
		try {			

			Thread prod1 = new Thread(new Productor("Productor 1", "Tenedor", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 1");
			Thread prod2 = new Thread(new Productor("Productor 2", "Cuchillo", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 2");
			Thread prod3 = new Thread(new Productor("Productor 3", "Cuchara", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 3");
			Thread prod4 = new Thread(new Productor("Productor 4", "Plato", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 4");
			Thread prod5 = new Thread(new Productor("Productor 5", "Vaso", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 5");
			Thread prod6 = new Thread(new Productor("Productor 6", "Vaso", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Productor 6");

			Thread cons1 = new Thread(new Consumidor("Consumidor 1", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 1");
			Thread cons2 = new Thread(new Consumidor("Consumidor 2", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 2");
			Thread cons3 = new Thread(new Consumidor("Consumidor 3", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 3");
			Thread cons4 = new Thread(new Consumidor("Consumidor 4", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 4");
			Thread cons5 = new Thread(new Consumidor("Consumidor 5", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 5");
			Thread cons6 = new Thread(new Consumidor("Consumidor 6", QUEUE_NAME, QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS), "Consumidor 6");

			prod1.start();
			prod2.start();
			prod3.start();
			prod4.start();
			prod5.start();
			prod6.start();

			cons1.start();
			cons2.start();
			cons3.start();
			cons4.start();
			cons5.start();
			cons6.start();

			// pongo los mensajes para controlar la capacidad del buffer			
			for (int i = 0; i < CAPACIDAD_BUFFER; i++) {
				Utils.sendMessage(QUEUE_CAPACIDAD_BUFFER, MQ_ADDRESS);
			}

			prod1.join();
			prod2.join();
			prod3.join();
			prod4.join();
			prod5.join();
			prod6.join();

			cons1.join();
			cons2.join();
			cons3.join();
			cons4.join();
			cons5.join();
			cons6.join();

			System.out.println("fin");

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
