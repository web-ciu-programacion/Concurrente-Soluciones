package ar.com.ciu;

public class Main {

	/*
	 * Ejemplo: Logra que el sujeto A siga su curso cuando el sujeto B lo desbloquee.
	 *   Primero mostrar el ejemplo con MonitorA (sin Lock & Condition)
	 *   Segundo mostrar el ejemplo con MonitorB (con Lock & Condition)
	 */
	public static void main(String[] args) {
		MonitorA monitor = new MonitorA();
//		MonitorB monitor = new MonitorB();
		Thread a1 = new SujetoA(monitor);
		Thread a2 = new SujetoB(monitor);
		a1.start();
		a2.start();
	}

}
