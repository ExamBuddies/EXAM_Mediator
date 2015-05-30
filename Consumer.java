public class Consumer extends Thread {
	private Mediator med;
	private int id;
	private static int count = 1;

	// laver kopling over til medator
	public Consumer(Mediator m){
		med = m;
		id = count++;
	}

	public void run() {
		int num;
		while(true) {
			num = med.retrieveMessage();
			System.out.println("C" + id + ": " + num);
		}
	}
}
