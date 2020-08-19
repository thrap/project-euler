import utils.Euler;
import utils.T;

public class Problem313 {
	public static void main(String[] args) {
		T t = new T();
		long count = 0;
		long limit = 1000000;
		for (long p : Euler.primeList((int)limit)) {
			if(p == 2)
				continue;
			
			long start = (p*p+13)/8+1;
			long end = (p*p-5)/6+2;
			
			count += 2*(Math.max(end-start+1, 1));
		}
		
		System.out.println(count + " " + t);
	}
}
