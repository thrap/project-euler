package problems;

public class Problem1602 {
	
	public static void main(String[] args) {
		int tall = 1;
		EulerThread t1 = new EulerThread(1, 99999, tall);
		EulerThread t2 = new EulerThread(100000, 999999, tall);
		EulerThread t3 = new EulerThread(1000000, 9999999, tall);
		EulerThread t4 = new EulerThread(10000000, 99999999, tall);
		
		t1.run();
		tall = t1.getTall();
		t2.run();
		tall *= t2.getTall();
		t3.run();
		tall *= t3.getTall();
		t4.run();
		tall *= t4.getTall();
		System.out.println(tall);
	}
	
	private static class EulerThread extends Thread {
		
		private int start;
		private int stop;
		private int tall;
		
		public EulerThread(int start, int stop, int tall) {
			this.start = start;
			this.stop = stop;
			this.tall = tall;
		}
		
		public int getTall() {
			return tall;
		}
		
		@Override
		public void run() {
			for (int i = start; i <= stop; i++) {
				doAlgorithm(i);
			}
		}

		private void doAlgorithm(int i) {
			int temp = i;
			while (temp % 10 == 0) {
				temp /= 10;
			}
			tall *= i;
			while (tall % 10 == 0) {
//				System.out.println(tall);
				tall /= 10;
			}
			if (tall > 100000) {
				tall %= 100000;
			}
		}
		
	}

}
