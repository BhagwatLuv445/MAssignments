package MulitThreding;

class Multiple{

	synchronized  void multipleOfTwo() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i * 2 + " ");
			try {
				wait(500);
			} catch (InterruptedException e) {

			}
			notify();
		}
	}

	synchronized  void multipleOfThree() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i * 3 + " ");
			try {
				wait(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		notify();
	}
}


public class MultiplyNumbers{

	public static void main(String[] args) {

		final Multiple m = new Multiple();
		new Thread(){
			public void run(){
				m.multipleOfTwo();
			}
		}.start();
		new Thread(){
			public void run(){
				m.multipleOfThree();
			}
		}.start();
	}		
}

