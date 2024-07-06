package ar.com.ciu.parcial.monitor;

public class Main {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Thread barny = new Thread(new Ebrio(monitor), "barny");
		Thread homero = new Thread(new Ebrio(monitor), "homero");
		Thread burns = new Thread(new Ecologico(monitor), "burns");
		Thread smiders = new Thread(new Ecologico(monitor), "smiders");
		Thread juanTopo = new Thread(new Transito(monitor), "juan topo");
		Thread marge = new Thread(new Transito(monitor), "marge");
		barny.start();
		homero.start();
		burns.start();
		smiders.start();
		juanTopo.start();
		marge.start();
		Thread alcoholicosAnonimos = new Thread(new Liberador(monitor, Infractor.EBRIEDAD), "alcoholicos anonimos");
		Thread ecologista = new Thread(new Liberador(monitor, Infractor.ECOLOGICA), "ecologista");
		Thread transito = new Thread(new Liberador(monitor, Infractor.TRANSITO), "agente transito");
		alcoholicosAnonimos.start();
		ecologista.start();
		transito.start();
	}

}
