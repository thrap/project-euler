package problems;

import java.util.*;

import utils.Euler;
import utils.T;


public class Problem229 {
	
    private static class CandidateGenerator {
        private List<Long> primes = new ArrayList<Long>();
        public CandidateGenerator() {
            for (long p : Euler.primeList((int)Math.sqrt(limit))) {
                if (isCritical(p))
                    primes.add(p);
            }
            System.out.println(primes.size());
        }

        private void generateCandidates(long n, int i, List<Long> candidates) {
            if (i == primes.size() || primes.get(i)*n > limit) {
                candidates.add(n);
            } else {
                long p = primes.get(i);

                for (int j = 0; n*Math.pow(p, j) <= limit; j+=2) {
                    generateCandidates(n * (long) Math.pow(p, j), i + 1, candidates);
                }
            }
        }

        private List<Long> getCandidates() {
            List<Long> candidates = new ArrayList<Long>();

            generateCandidates(1, 0, candidates);

            return candidates;
        }
    }

    private static class SpecialGenerator {
        private List<Long> primes = new ArrayList<Long>();
        public SpecialGenerator() {
            for(int i = 0; i<10; i++) {
                System.out.println("Generating primes: "+(i+1)+"/10 ("+primes.size()+")");
                for (long p : Euler.primeListBetween((limit/10)*i, (limit/10)*(i+1))) {
                    if (!isCritical(p) && p != 1)
                        primes.add(p);
                }
            }
        }

        public List<Long> getSpecials() {
            List<Long> specials = primes;

            boolean changed;
            int start = 0;
            do {
                changed = false;
                List<Long> newSpecials = new ArrayList<Long>();
                long num = specials.get(start);
                long number = num;
                for(; number < limit; number*=num) {
                    for(int i = start; specials.get(i)*number < limit; i++) {
                        newSpecials.add(number*specials.get(i));
                        changed = true;
                    }
                }
                specials.addAll(newSpecials);
                Collections.sort(specials);
                System.out.println("New Specials: "+newSpecials.size());
                start++;
            } while(changed);

            return new ArrayList<Long>(new TreeSet<Long>(specials));
        }
    }

	static int limit = 2*(int)Math.pow(10, 9);
	public static void main(String[] args) {
        System.out.println(limit);
        T t = new T();

        List<Long> candidates = new CandidateGenerator().getCandidates();
        List<Long> specials = new SpecialGenerator().getSpecials();

        int count = 0;
        for (long a : candidates) {
            if (isBruteSpecial(a))
                count++;
            //should use binary search here
            for (long b : specials) {
                if (b * a > limit)
                    break;
                count++;
            }
        }
        System.out.println(count + " " + t);
    }
	
	private static boolean isBruteSpecial(long n) {
		return isSquareSum(n, 1) && isSquareSum(n, 2) && isSquareSum(n, 3) && isSquareSum(n, 7);
	}
	
	private static boolean isSquareSum(long n, int D) {
		for (long a = 1; a*a < n; a++) {
			if ((n-a*a) % D == 0 && Euler.isPerfectSquare((n-a*a)/D))
				return true;
		}
		return false;
	}

	private static boolean isCritical(long p) {
		return  (p % 7 == 3) || (p % 7 == 5) || (p % 7 == 6) ||
				(p % 4 == 3) || (p % 8 == 5) || (p % 8 == 7) ||
				(p % 3 == 2); 
	}
}
