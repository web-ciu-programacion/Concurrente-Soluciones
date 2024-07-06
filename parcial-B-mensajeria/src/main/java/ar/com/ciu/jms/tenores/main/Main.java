package ar.com.ciu.jms.tenores.main;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import ar.com.ciu.jms.tenores.modelo.Tarea;
import ar.com.ciu.jms.tenores.modelo.Trabajador;

/*
 * Iniciar ActiveMQ: .../apache-activemq-6.1.2/bin$ ./activemq start
 * ActiveMQ URL: http://localhost:8161/admin
 * 
 * Respuestas:
 * 
 * 1 - Finaliza su ejecución. Siempre hay un mensaje en la queue: tareas, antes de iniciar los hilos, y el bucle de los hilos Trabajador se repite hasta que el 
 *     mensaje recibido contenga el número igual al atributo: xyz, y sino lo es envía un mensaje con el mensaje recibido. Al llegar el mensaje con el valor 
 *     de la constante: CANTIDAD_TOTAL_DE_MENSAJES es porque no hay más hilos en ejeución y no se envía el mensaje para que no quede "sucia" la queue.
 *     
 * 2 - Posible traza:
 *     Leni esperando mensaje...
 *     Lisa esperando mensaje...
 *     Karl esperando mensaje...
 *     Lisa recibio mensaje [1]
 *     Lisa realizó la tarea: Trabajar
 *     Karl recibio mensaje [2]
 *     Leni recibio mensaje [2]
 *     Leni realizó la tarea: Organizarse
 *     Karl esperando mensaje...
 *     Karl recibio mensaje [3]
 *     Karl realizó la tarea: Derrotar a la patronal
 * 
 *     Observar que mediante el mensaje se sincronizan los hilos para que siempre se realicen las tareas en el orden indicado en el parámetro xyz del constructor.
 */
public class Main {

	private static final String HOST = "tcp://localhost:61616";
	private static final String QUEUE = "tareas";
	public static final Integer CANTIDAD_TOTAL_DE_MENSAJES = new Integer(3);

	public static void main(String[] args) {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(HOST);
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(QUEUE);
			MessageProducer messageProducer = session.createProducer(queue);
			Message message = session.createTextMessage("1");
			messageProducer.send(message);
			messageProducer.close();
			session.close();
			connection.close();
			Thread ta = new Thread(
					new Trabajador(QUEUE, HOST, 3, new Tarea("Derrotar a la patronal")), "Karl");
			Thread tb = 
					new Thread(new Trabajador(QUEUE, HOST, 1, new Tarea("Trabajar")), "Lisa");
			Thread tc = 
					new Thread(new Trabajador(QUEUE, HOST, 2, new Tarea("Organizarse")), "Leni");
			tc.start();
			tb.start();
			ta.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
