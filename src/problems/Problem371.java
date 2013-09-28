package problems;

public class Problem371 {
	public static void main(String[] args) {
		//5 valg: sett/ny/match/000/500
		System.out.println(compute(1.0, 0,0));
	}
	
	private static double compute(double prob, double seen, double zeros) {
		if (prob < 0.0000000000001) {
			return prob*seen;
		}
		seen++;
		//zero
		double sum = compute(prob*(1.0/1000.0), seen, zeros+1);
		
		//ikke-match
		sum += compute(prob*((999-(seen-zeros))/1000),seen, zeros);
		//match
		sum += prob*((seen-zeros)/1000)*seen;
		
		return sum;
	}
}