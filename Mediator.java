public class Mediator {
	private int number;
	private boolean slotFull = false;

	public synchronized void storeMessage(int num){
		while(slotFull == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}  
		slotFull = true;
		number = num;
		notifyAll();
	}

	public synchronized int retrieveMessage(){
		while(slotFull == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slotFull = false;
		notifyAll();
		return number;
	}
}
