package problems;

public class Problem148 {
	//============================================================================
	// Name        : Project148.cpp
	// Author      : 
	// Version     :
	// Copyright   : Your copyright notice
	// Description : Hello World in C++, Ansi-style
	//============================================================================
//
//	void print(vector<unsigned long long>);
//	unsigned long long sumRekke(unsigned long long);
//	unsigned long long superSumRader(unsigned long long r);
//	long teller= 0;


	public static void main(String[] args) {
		//10000 = 6264360/50005000
		//1000 = 118335/500500
		//100 = 2361/5050
		//10 = 40/55
		//6+5+4+3+2+1 = ((1+6)*6/2)*((1+6)*6/2);
		long rader = 1000000000L; //7*7*2 + 2 = (1+2)*sumRekke(2)

		System.out.println(solution());
		rader = 100;
		long sum = ((rader+1)*rader)/2;

//		vector<unsigned long long> v;
//		v.push_back(1LL);
//		print(v);
//		int teller = 0;
//		int teller2 = 1;
//		for(unsigned int j = 1; j<rader; j++) {
//			vector<unsigned long long> temp;
//			temp.push_back(1LL);
//			teller2++;
//			for (unsigned int i = 0; i < v.size()-1; ++i) {
//				int tall = v[i]+v[i+1];
//				if (tall%7 == 0) {
//					tall = 0;
//					teller++;
//				}
//				else {
//					teller2++;
//					tall = tall%7;
//				}
//
//				temp.push_back(tall);
//			}
//			teller2++;
//			temp.push_back(1LL);
//			v = temp;
//			print(temp);
//			unsigned long long antall = superSumRader(rader);
//		}
		//sumRekke(sumRekke(7))*sumRekke(r);

		// rader
		// 7x7 				trekant = sumRekke(7)
		// (7a)x(7a) 		trekant = sumRekke(7)*sumRekke(a)
		// 49x49 			trekant = sumRekke(7)*sumRekke(7)
		// (49a)x(49a) 		trekant = sumRekke(7)*sumRekke(7)*sumRekke(a)
		// (49*7)x(49*7) 	trekant = sumRekke(7)*sumRekke(7)*sumRekke(7)

		//
//		cout<<antall;
//		return 0;
	}

	public static long solution() {
		return superSumRader(1000000000L);
	}

	public static long sumRekke(long r) {
//		teller++;
		return ((r+1)*r)/2;
	}

	public static long superSumRader(long r) {
		long rest = r;
		long sum = 1;


		int p = 0;
		while (r / 7 >= 1) {
			r/=7;
			p++;
			sum *= sumRekke(7);
		}
//		cout<<pow(7,p)<<endl;
//		cout<<rest/(int)pow(7,p)<<endl;
		sum *= sumRekke(rest/(long)Math.pow(7,p));

		long antall = rest/(long)Math.pow(7,p);

		rest %= (long)Math.pow(7,p);
//		cout<<"Rest: "<<rest<<endl;
//		cout<<"Antall: "<<antall<<endl;
		if (rest > 0 && rest < 7) {
			sum += (antall+1)*sumRekke(rest);
		} else if (rest >= 7) {
			sum += (antall+1)*superSumRader(rest);
		}

		return sum;
	}

//	void print(vector<unsigned long long> v) {
//		for (unsigned int i = 0; i < v.size(); ++i) {
//			cout<<v[i]<< " ";
//		}
//		cout<<""<<endl;
//	}

}
