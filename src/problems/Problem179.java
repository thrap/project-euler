package problems;

import utils.Euler;

public class Problem179 {
	public static void main(String[] args) {
		System.out.println(solution());
	}
	public static int solution() {
		// LOL DETTE ER IKKE 72, det er
//				vector<int> a = primeFactors2(5432432);
//				for (int i = 0; i < a.size(); ++i) {
//					cout<<a[i]<<", ";
//				}
//		System.out.println(temp);
		int teller = 0;
		int forrige = 0;
		for (int i = 1; i<10000000; i++) {
			int denne = Euler.divisorAmount(i);
//					int neste = primefactors(i+1);
			if (denne == forrige) {
				teller++;
			}
			forrige = denne;
		}
//		System.out.println(teller);
		return teller;
	}

//	int number_of_divisors(int n){
//	    int counter,i;
//	    for(counter=0,i=1;(!(n%i) && (counter++)) || i<=(n/2);i++);
//	    return counter;
//	}

	int divisors(int x) {
	    int limit = x;
	    int numberOfDivisors = 0;

	    for (int i = 1; i < limit; ++i) {
	    	if (x % i == 0) {
	            limit = x / i;
	            if (limit != i) {
	                numberOfDivisors++;
	            }
	            numberOfDivisors++;
	        }
	    }

	    return numberOfDivisors;
	}

	static int primeFactors(int numbers) {
		int factors = 1;
		int n = numbers;
		int teller = 0;
		for (int i = 2; i*i <= numbers; i++) {
			teller = 0;
			while (n % i == 0) {
//				cout<<n<<endl;
				teller++;
				n /= i;
			}
			factors *= (teller+1);
		}
		if (n > 1)
			factors *= 2;
		return factors;
	}

	//vector<int> primeFactors2(int numbers) {
//		int n = numbers;
//		vector<int> factors;
//		for (int i = 2; i <= n / i; i++) {
//			while (n % i == 0) {
//				factors.push_back(i);
//				n /= i;
//			}
//		}
//		if (n > 1) {
//			factors.push_back(n);
//		}
//		return factors;
	//}

	int fi(int n)  {
	  int result = n;
	  for(int i=2;i*i <= n;i++)  {
		if (n % i == 0)
			result -= result / i;
		while (n % i == 0)
			n /= i;
	  }
	  if (n > 1)
		  result -= result / n;
	  return result;
	}
}
