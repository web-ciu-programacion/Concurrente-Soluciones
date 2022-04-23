package ciu.concurrencia.practica;

public class Competidor extends BaseCompetidor implements Runnable {

	public Competidor() {
		super();
		this.kilometros = 0;
	}

	@Override
	public void run() {
		int azaroso;
		Thread t = Thread.currentThread();
		while (this.kilometros<10) {
			 azaroso = this.getNumero();
			System.out.println(t.getName() + " - azaroso: " + azaroso + " - priority: " + t.getPriority());
			switch (azaroso) {
			case 2:
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				t.setPriority(Thread.MIN_PRIORITY);
				break;
			case 7:
//				http://www.java2s.com/Tutorials/Java/Java_Thread/0040__Java_Thread_Current.htm
				//https://www.geeksforgeeks.org/java-concurrency-yield-sleep-and-join-methods/
				Thread.yield();
				break;
			case 9:
				this.kilometros = this.kilometros+3;
				break;
			default:
				this.kilometros++;
				break;
			}
		}
		System.out.println(" -->> finalizó " + Thread.currentThread().getName() + " <<-- ");
	}

}
