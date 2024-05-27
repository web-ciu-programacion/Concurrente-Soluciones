package ciu.prod.cons;

import javax.jms.JMSException;

public class Main {

	public static final String QUEUE_NAME = "buffer";
	public static final String MQ_ADDRESS = "tcp://localhost:61616";

	/*
	 * Productor / Consumidor (receive bloqueante)
	 * String message
	 */
	public static void main(String[] args) {
		try {
			Thread prod1 = new Thread(new Productor(QUEUE_NAME, MQ_ADDRESS), "Productor 1");
			Thread prod2 = new Thread(new Productor(QUEUE_NAME, MQ_ADDRESS), "Productor 2");
			Thread prod3 = new Thread(new Productor(QUEUE_NAME, MQ_ADDRESS), "Productor 3");
			Thread prod4 = new Thread(new Productor(QUEUE_NAME, MQ_ADDRESS), "Productor 4");
			Thread prod5 = new Thread(new Productor(QUEUE_NAME, MQ_ADDRESS), "Productor 5");

			Thread cons1 = new Thread(new Consumidor("Consumidor 1", QUEUE_NAME, MQ_ADDRESS), "Consumidor 1");
			Thread cons2 = new Thread(new Consumidor("Consumidor 2", QUEUE_NAME, MQ_ADDRESS), "Consumidor 2");
			Thread cons3 = new Thread(new Consumidor("Consumidor 3", QUEUE_NAME, MQ_ADDRESS), "Consumidor 3");
			Thread cons4 = new Thread(new Consumidor("Consumidor 4", QUEUE_NAME, MQ_ADDRESS), "Consumidor 4");
			Thread cons5 = new Thread(new Consumidor("Consumidor 5", QUEUE_NAME, MQ_ADDRESS), "Consumidor 5");

			cons1.start();
			cons2.start();
			cons3.start();
			cons4.start();
			cons5.start();

			prod1.start();
			prod2.start();
			prod3.start();
			prod4.start();
			prod5.start();

			prod1.join();
			prod2.join();
			prod3.join();
			prod4.join();
			prod5.join();

			cons1.join();
			cons2.join();
			cons3.join();
			cons4.join();
			cons5.join();

			System.out.println("fin");

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
