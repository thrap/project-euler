package problems;

import java.util.*;

import utils.Euler;
import utils.T;


public class Problem229 {
	
	/**
	 * http://math.uga.edu/~pete/thuelemmav7.pdf
	 * 
	 * denne lager alt for stor stack. fix plx
	 */

    private static class CandidateGenerator {
        private List<Long> primes = new ArrayList<Long>();
        public CandidateGenerator() {
            for (long p : Euler.primeList((int)Math.sqrt(limit))) {
                if (isCritical(p))
                    primes.add(p);
            }
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
            for (long p : Euler.primeList(limit)) {
                if (!isCritical(p))
                    primes.add(p);
            }
        }

        private void generateSpecials(long n, int i, List<Long> specials) {
            if (i == primes.size() || primes.get(i)*n > limit) {
                specials.add(n);
            } else {
                long p = primes.get(i);

                for (int j = 0; n*Math.pow(p, j) <= limit; j++) {
                    generateSpecials(n * (long) Math.pow(p, j), i + 1, specials);
                }
            }
        }

        public List<Long> getSpecials() {
            List<Long> specials = new ArrayList<Long>();

            generateSpecials(1, 0, specials);
            specials.remove(0);
            Collections.sort(specials);

            return specials;
        }
    }

	static int limit = (int)Math.pow(10, 6);
	public static void main(String[] args) {
		T t = new T();

        List<Long> specials = new SpecialGenerator().getSpecials();
        List<Long> candidates = new CandidateGenerator().getCandidates();

        int count = 0;
        for (long a : candidates) {
            if (isBruteSpecial(a))
                count++;

            //binærsøk her breh
            for (long b : specials) {
                if (b * a > limit)
                    break;
                count++;
            }
        }
        System.out.println(count + " " + t);
        System.out.println(specials.size());
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
