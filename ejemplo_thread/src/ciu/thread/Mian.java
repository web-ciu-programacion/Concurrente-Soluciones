package ciu.thread;

public class Mian {

	public static void main(String[] args) {
		Thread hiloPrincipal = Thread.currentThread();
		System.out.println("inicio: " + hiloPrincipal.getName());
		Thread mh1 = new Thread(new MiHilo());
		mh1.start();
		System.out.println("fin: " + hiloPrincipal.getName());
	}

}
