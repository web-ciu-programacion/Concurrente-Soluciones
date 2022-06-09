package ciu.concurrencia.semaphore;

public class Auto implements Runnable {

	private Sentido sentido;

	public Auto(Sentido sentido) {
		super();
		this.sentido = sentido;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		try {
			if (Sentido.NORTE_SUR.equals(this.sentido)) {
				System.out.println(t.getName() + " avanza en sentido: " + this.sentido.name() + " en tramo: 1");
				Shared.puenteNorte.acquire();
				System.out.println(t.getName() + " cruzo el puente Norte");
				Shared.puenteNorte.release();
				System.out.println(t.getName() + " avanza en sentido: " + this.sentido.name() + " en tramo: 2");
				Shared.puenteNorte.acquire();
				System.out.println(t.getName() + " cruzo el puente Sur");
				Shared.puenteNorte.release();
				System.out.println(t.getName() + " cruzo los 2 puentes y continua rumbo al Sur");
			} else {
				System.out.println(t.getName() + " avanza en sentido: " + this.sentido.name() + " en tramo: 1");
				Shared.puenteNorte.acquire();
				System.out.println(t.getName() + " cruzo el puente Sur");
				Shared.puenteNorte.release();
				System.out.println(t.getName() + " avanza en sentido: " + this.sentido.name() + " en tramo: 2");
				Shared.puenteNorte.acquire();
				System.out.println(t.getName() + " cruzo el puente Norte");
				Shared.puenteNorte.release();
				System.out.println(t.getName() + " cruzo los 2 puentes y continua rumbo al Norte");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Sentido getSentido() {
		return sentido;
	}

}
