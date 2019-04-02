import java.util.concurrent.Semaphore;

public class Mesa {
    private Semaphore sems[];
    public static final int nFilosofos = 5;

    public Mesa() {
	sems = new Semaphore[nFilosofos];

	for (int i = 0; i < nFilosofos; ++i) {
	    sems[i] = new Semaphore(1, true);
	}
    }

    public void solicitar(int i) {
	try {
	    sems[i].acquire();
	}
	catch (InterruptedException ie) { }
    }

    public void liberar(int i) {
	
	sems[i].release();
    }
}
