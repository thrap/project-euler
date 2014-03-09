package Java;

import java.util.HashMap;
import java.util.Map;

public class Problem126 {
//	#include <iostream>
//	#include <map>
//	#include <string>
//	using namespace std;
	static int n=100;
	static int limit = 3*2*n*n;

	static void supersum(int sum, int ant, int x, int y, int z, Map<Integer,Integer> c) {
	    if (sum == 0) {
	        sum = x*y;
	    }
	    int totsum = sum;
	    sum += (2*x+2*y) + 4*(ant-1);
	    totsum += sum + 4*(z-1)*(ant-1) + 2*((z-1)*y+x*(z-1));
	    if (totsum > limit)
	        return;
	    if (c.containsKey(totsum))
	    	c.put(totsum, c.get(totsum)+1);
	    else
	    	c.put(totsum, 1);
	    supersum(sum, ++ant, x, y, z, c);
	}

	public static void main(String[] args) {
		System.out.println(solution());
//	    cout<<storste<<" ("<<")"<<endl;
	//
//	    cout<<m[22]<<endl;
//	    cout<<m[46]<<endl;
//	    cout<<m[78]<<endl;
//	    cout<<m[118]<<endl;
//	    cout<<m[154]<<endl;

	}//end main

	public static long solution() {
		 Map <Integer,Integer> c = new HashMap<Integer, Integer>();

//		    int x = 7;
//		    int y = 2;
//		    int z = 3;
//		    int sum = 0;
//		    int ant = 1;
//		    supersum(sum, ant, x, y, z);
	//
	    for(int a = 1; a < n; ++a) {
	        for(int b = a;  (2*a+2*b) + 2*((b-1)*b+a*(b-1)) < limit; ++b) {
	            for(int d = b;  (2*a+2*b) + 2*((d-1)*b+a*(d-1)) < limit; ++d) {
	                int sum = 0;
	                int ant = 1;
	                int x = a;
	                int y = b;
	                int z = d;
	                supersum(sum, ant, x, y, z, c);
	            }
	        }
	    }
	//
//		    int storste = 0;
//		    int tall;
//		    int teller = 0;
	    for(Map.Entry<Integer, Integer> it : c.entrySet()) {
	        if(it.getValue()== 1000) {
	        	return it.getKey();
	        }
//		        if (it->second > storste) {
//		            tall = it->first;
//		            storste = it->second;
//		        }

	    }
	    return 0;
	}

}
