public class Producer extends Thread{
	private Mediator med;
	private int id;
	private static int count = 1;

	// laver kopling over til medator
	public Producer(Mediator m){
		med = m;
		id = count++;
	}

	public void run() {
		int num;
		while(true) {
			num = (int)(Math.random()*100);
			med.storeMessage(num);
			System.out.println("P-" + id + ": " + num);
		}
	}
}
