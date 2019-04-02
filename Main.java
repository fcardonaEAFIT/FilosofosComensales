public class Main {
    public static void main(String args[]) {
	Mesa mesa = new Mesa();
	Thread ts[] = new Thread[Mesa.nFilosofos];

	for (int i = 0; i < Mesa.nFilosofos; ++i) {
	    ts[i] =
		new Thread(new Filosofo(i,
					(i + 1) % Mesa.nFilosofos,
					mesa));
	    
	    ts[i].start();
	}
	try {
	    ts[0].join();
	}
	catch(InterruptedException ie) { }
    }
}
