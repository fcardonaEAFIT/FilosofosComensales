import java.util.Random;

public class Filosofo implements Runnable {

    private int sem1, sem2;
    private Mesa mesa;

    public Filosofo(int sem1, int sem2, Mesa mesa) {
	if (sem1 > sem2) {
	    int tmp = sem1;
	    sem1 = sem2;
	    sem2 = tmp;
	}
	this.sem1 = sem1;
	this.sem2 = sem2;
	this.mesa = mesa;
    }

    public void run() {
	Random r = new Random();
	while (true) {
	    // pensar
	    System.out.println("Filosofo pensando: " +
			       sem1 + " " + sem2);
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    } catch (InterruptedException ie) { }
	    mesa.solicitar(sem1);
	    mesa.solicitar(sem2);
	    // comer
	    System.out.println("Filosofo comiendo: " +
			       sem1 + " " + sem2);
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    } catch (InterruptedException ie) { }
	    mesa.liberar(sem1);
	    mesa.liberar(sem2);
	}
    }
}
