import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test {
	static long aLav = 0; 
	static long bLav = 1; 
	static long cLav = 1; 
	static BigInteger aH0y = BigInteger.valueOf(0);
	static BigInteger bH0y = BigInteger.valueOf(1);
	static BigInteger cH0y = BigInteger.valueOf(1);
	static int i=0;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static long t = 0;
	static long p = 0;
	static long h = 0;
	static long triangle = 1;
	static long pentagonal = 1;
	static long hexagonal = 1;
	static int ord = 0;
	static int teller = 0;
	static int storsteRekke = 0;
	static ArrayList list;
	
	static HashMap map2 = new HashMap();
	
	public static void main(String[] args) throws IOException{
//		byte x=0;
//		while (x>=0)
//			x++;
//		System.out.println(x);
		
//		ordUnder1000();
//		problem104();
//		boolean tall[] = primtallUnder(1000);
//		for (int i = 0; i < tall.length; i++) {
//			if (tall[i])
//				System.out.println(i);
//		}
//		int a = 1;
//		int forrige = 0;
//		for (int i = 1; i <= 25; i++) {
//			forrige+=i;
//			System.out.println(forrige);
//			
//		}
		
		
		StringBuilder a = new StringBuilder();
		for (int j = 0; j < 1000000; j++) {
			a.append('1');
			if (j % 10000 == 0)
				System.out.println(j);
		}
		BigInteger b = new BigInteger(a.toString());
		
//		problem119();
		
//		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
//		String linje = in.readLine();
//		StringTokenizer st = new StringTokenizer(linje);
//		int[][] matrix = new int[st.countTokens()][st.countTokens()];
//		
//		for (int i = 0; i < matrix.length; i++) {
//			st = new StringTokenizer(linje);
//			for (int j = 0; j < matrix.length; j++) {
//				matrix[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//			linje = in.readLine();
//		}
//		
//		Node81 start = new Node81(0);
//		System.out.println(start);
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				start.settBarn(new Node81(matrix[i][j]));
//			}
//		}
		
	}
	
	public static boolean erPandigital(String tall) {

		String s = ""+tall;
		if (s.length() != 9)
			return false;
	    boolean[] A = new boolean[s.length()];
	    
	    for (int i = 0; i < s.length(); i++) {
	    	if (s.charAt(i) == '0')
	            return false;
	    	else if (s.charAt(i)-'1' >= A.length)
	    		return false;
	        if (!A[s.charAt(i)-'1']) 
	            A[s.charAt(i)-'1'] = true;
	        else if (A[s.charAt(i)-'1'])
	            return false;
		}
	    return true;
	}
	
	public static void problem95() {
		for (int i = 0; i < 1000000; i++) {
			ord = i ;
			teller = 0;
			list = new ArrayList();
			int asd = divisorSum(ord);
			if (asd != 0) {
				map2.put(ord, teller);
				map2.put(asd, teller);
				System.out.println(list);
			}
		}
		System.out.println(map2);
	}
	
	public static int divisorSum(int tall) {
		teller++;
		list.add(tall);
//		System.out.println(tall);
		if (tall == 0 || tall == 1 || map2.containsKey(tall))
			return 0;
		if (tall > ord) {
//			System.out.println("for stor lol");
			return 0;
		}
		int sum = 1;
		for (int i = 2; i <= Math.sqrt(tall); i++) {
			if (tall % i == 0) {
				sum+=i+tall/i;
			}
		}
		if (sum == ord) {
			if (storsteRekke < teller) {
				storsteRekke = teller;
				System.out.println(teller);
				System.out.println(tall);
			}
			return ord;
		}
		return divisorSum(sum);
	}
	
	public static void problem27() {
		int flest = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				i = 0;
				while (true) {
					if(!erPrimtall(i*i+a*i+b)) {
						if (flest < i) {
							flest = i;
							System.out.println(i + ": " + a + " + " + b);
							System.out.println(a*b);
						}
						break;
					}
					i++;
				}
//				System.out.println(i);
			}
		}
	}
	
	public static void problem99() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		String linje = in.readLine();
		
		int teller = 0;
		double storste = 0;
		int linjenr = 0;
		while (linje != null) {
			teller++;
			StringTokenizer st = new StringTokenizer(linje,", ");
			
			double denne = (Math.log(Long.parseLong(st.nextToken())) * Long.parseLong(st.nextToken()));
			if (denne>storste) {
				linjenr = teller;
				storste = denne;
			}
			
			linje = in.readLine();
		}
		System.out.println(teller);
		System.out.println(linjenr);
		System.out.println(storste);
	}
	
	public static void problem41() {
		System.out.println((erPandigital(123456)));
		for (int i = 1234561; i <= 9876543; i+=2) {
			if (erPrimtall(i))
				if (erPandigital(i))
					System.out.println(i);
		}
	}
	
	public static boolean erPandigital(long tall) {

		String s = ""+tall;
	    boolean[] A = new boolean[s.length()];
	    
	    for (int i = 0; i < s.length(); i++) {
	    	if (s.charAt(i) == '0')
	            return false;
	    	else if (s.charAt(i)-'1' >= A.length)
	    		return false;
	        if (!A[s.charAt(i)-'1']) 
	            A[s.charAt(i)-'1'] = true;
	        else if (A[s.charAt(i)-'1'])
	            return false;
		}
	    return true;
	}
	
	
	public static void problem29() {
		HashMap<BigInteger,String> map = new HashMap<BigInteger,String>();
		
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger tall = BigInteger.valueOf(i);
				tall = tall.pow(j);
				map.put(tall, "");
			}
		}
		System.out.println(map.size());
	}
	
	public static void storsteDigitaleVerdi() {
		int storste = 0;
		for (int i = 2; i <= 5; i++) {
			for (int j = 2; j <= 5; j++) {
				BigInteger tall = BigInteger.valueOf(i);
				tall = tall.pow(j);
				if (digitalVerdi(tall)>storste) {
					storste = digitalVerdi(tall);
					System.out.println(storste);
				}
				
			}
		}
	}
	
	public static int digitalVerdi(BigInteger tall) {
		String tallString = tall.toString();
		
		int sum = 0;
		for (int i = 0; i < tallString.length(); i++) {
			sum+=tallString.charAt(i)-'0';
		}
		return sum;
	}
	
	public static void problem45() {
		while (true) {
			nextHexagonal();
			while (hexagonal > pentagonal)
				nextPentagonal();
			while (hexagonal > triangle)
				nextTriangle();
			long t = triangle;
			long p = pentagonal;
			long h = hexagonal;
			if (t == p && t == h && h != 1) {
				System.out.println(t);
				System.out.println(Test.t);
				System.out.println(Test.p);
				System.out.println(Test.h);
			}
		}
	}
	
	public static void nextHexagonal() {
		h++;
//		if(h % 1000 == 0) {
//			System.out.println(triangle);
//			System.out.println(pentagonal);
//			System.out.println(hexagonal);
//		}
		
		hexagonal = (long)(h*(2*h-1));
	}
	
	public static void nextPentagonal() {
		p++;
//		if(p % 1000 == 0) {
//			System.out.println(triangle);
//			System.out.println(pentagonal);
//			System.out.println(hexagonal);
//		}
		pentagonal = (long)((p*(3*p-1))/2);
	}
	
	public static void nextTriangle() {
		t++;
//		if(t % 1000 == 0) {
//			System.out.println(triangle);
//			System.out.println(pentagonal);
//			System.out.println(hexagonal);
//		}
		triangle = (long)((t*(t+1))/2);
	}
	
	public static void ordUnder1000() {
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
		
		map.put(100, "OneHundred");
		map.put(200, "TwoHundred");
		map.put(300, "ThreeHundred");
		map.put(400, "FourHundred");
		map.put(500, "FiveHundred");
		map.put(600, "SixHundred");
		map.put(700, "SevenHundred");
		map.put(800, "EightHundred");
		map.put(900, "NineHundred");
		
		int sum = 0;
		for (int i = 1; i <= 999; i++) {
			int tall = i;
			String tallString = "";
			if (map.containsKey(tall))
				tallString+=(map.get(tall));
			else {
				String tallString2 = ""+tall;
				if (tall > 100)
					tallString+=map.get((tallString2.charAt(0)-'0')*100)+"And";
				if (map.containsKey(tall % 100))
					tallString+=(map.get(tall%100));
				else {
					tallString+=(map.get(((tallString2.charAt(tallString2.length()-2)-'0')*10)));
					tallString+=(map.get((tallString2.charAt(tallString2.length()-1)-'0')));
				}
			}
			System.out.println(tallString);
			sum+=tallString.length();
		}
		System.out.println(sum);
	}
	
	public static void over500divisors() {
		i=1;
		long tall = i;
		while(true) {
			i++;
			tall += i;
			long ant = antDivisors(tall);
			if(ant > 500) {
				System.out.println(tall);
				break;
			}
		}
	}
	
	public static long antDivisors(long tall) {
		int divisors = 2;
		for (int i = 2; i <= Math.sqrt(tall); i++) {
			if (tall % i == 0) {
				divisors+=2;
			}
		}
		return divisors;
	}
	
	public static void sundaysInYears() {
		int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int day = 2;
		int forste = 0;
		for (int year = 1901; year <= 1999; year++) {
			for (int month = 0; month < daysOfMonth.length; month++) {
				for (int j = 1; j <= daysOfMonth[month] + ((month == 1 && year % 4 == 0)?1:0); j++) {
					day++;
					if(day == 8)
						day = 1;
					if (day == 1 && j == 1) {
						forste++;
						System.out.println(month+1);
					}
//					System.out.println(j);
				}
			}
		}
		System.out.println(forste);
	}
	
	public static int divisorSumDaarlig(int tall) {
		int sum = 0;
		for (int i = 1; i <= tall/2; i++) {
			if (tall % i == 0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	public static void problem104() {
		for (int i = 2; i < 1000000000; i++) {
			boolean a = false, b = false;
//			System.out.println(cLav);
			if (sjekkForste(fibonacciNesteH0y())) {
//				System.out.println(cH0y);
				System.out.println("Frste: "+i);
				a=true;
//				break;
			}
			
			if (sjekkSiste(fibonacciNesteLav())) {
//				System.out.println(cLav);
				System.out.println("Siste: " + i);
				b = true;
//				break;
			}
			
			if (a && b) {
				System.out.println(i);
				System.out.println(Test.i);
				break;
			}
			
		}
	}

	public static void problem119() {
		ArrayList<Long> liste = new ArrayList<Long>();
		String tall = "10000000000000";
		for (int i = 2; i < (tall.length()-1)*9+2; i++) {
			int base = i;
			long sum = 1;
			while(sum < Long.valueOf(tall)){
				sum*=base;
				String tallString = ""+sum;
				int verdi=0;
				for (int j = 0; j < tallString.length(); j++) {
					verdi += tallString.charAt(j)-'0';
				}
				if (base == verdi && sum > 10)
					liste.add(sum);
			}
		}
		long storste = 0;
		for (int i = 0; i < liste.size(); i++) {
			if (storste < liste.get(i))
				storste = liste.get(i);
		}
		
		System.out.println(liste);
		System.out.println(storste);
		
//		if (i^x == verdi(""+i^x))
//		12*9
	}
	
	public static boolean sjekkSiste(long tall) {

	    boolean[] A = {false,false,false,false,false,false,false,false,false};
	    String s = "        "+tall;
	    
	    for (int i = s.length()-9; i < s.length(); i++) {
	    	if (s.charAt(i) == '0')
	            return false;
	    	else if (s.charAt(i) == ' ')
	    		return false;
	        if (!A[s.charAt(i)-'1']) 
	            A[s.charAt(i)-'1'] = true;
	        else if (A[s.charAt(i)-'1'])
	            return false;
		}
	    return true;
	}
	public static boolean sjekkForste(BigInteger tall) {
		
		boolean[] A = {false,false,false,false,false,false,false,false,false};
		String s = tall.toString()+"        ";
		
		if(s.length() > 1000) {
			i++;
			cH0y = cH0y.divide(BigInteger.valueOf(10));
			bH0y = bH0y.divide(BigInteger.valueOf(10));
			aH0y = aH0y.divide(BigInteger.valueOf(10));
		}
		
		
		for (int i = 0; i < 9; i++) {
			if (s.charAt(i) == '0')
				return false;
			else if (s.charAt(i) == ' ')
				return false;
			if (!A[s.charAt(i)-'1']) 
				A[s.charAt(i)-'1'] = true;
			else if (A[s.charAt(i)-'1'])
				return false;
		}
		return true;
	}

	
	public static String tilString(int tall) {
		StringBuilder sb = new StringBuilder();
		while(tall >= 1000) {
			tall -= 1000;
			sb.append("M");
		}
		if (tall >= 900) {
			sb.append("CM");
			tall -= 900;
		}
		if (tall >= 500) {
			sb.append("D");
			tall -= 500;
		}
		if (tall >= 400) {
			sb.append("CD");
			tall -= 400;
		}
		while(tall >= 100) {
			tall -= 100;
			sb.append("C");
		}
		if (tall >= 90) {
			sb.append("XC");
			tall -= 90;
		}
		if (tall >= 50) {
			sb.append("L");
			tall -= 50;
		}
		if (tall >= 40) {
			sb.append("XL");
			tall -= 40;
		}
		while(tall >= 10) {
			tall -= 10;
			sb.append("X");
		}
		if (tall >= 9) {
			sb.append("IX");
			tall -= 9;
		}
		if (tall >= 5) {
			sb.append("V");
			tall -= 5;
		}
		if (tall >= 4) {
			sb.append("IV");
			tall -= 4;
		}
		while(tall >= 1) {
			tall -= 1;
			sb.append("I");
		}
		return sb.toString();
	}
	
	public static int tilTall(String tall) {
		map.put("CM", 900);
		map.put("CD", 400);
		map.put("XC", 90);
		map.put("XL", 40);
		map.put("IX", 9);
		map.put("IV", 4);
		map.put("M", 1000);
		map.put("D", 500);
		map.put("C", 100);
		map.put("L", 50);
		map.put("X", 10);
		map.put("V", 5);
		map.put("I", 1);
		
		int sum = 0;
		for (int i = 0; i < tall.length(); i++) {
			if(i != tall.length()-1) {
				String asd = ""+tall.charAt(i)+tall.charAt(i+1);
				if (map.containsKey(asd)) {
					sum+=map.get(""+tall.charAt(i)+tall.charAt(i+1));
					i++;
				}
				else 
					sum+=map.get(""+tall.charAt(i));
			}
			else
				sum+=map.get(""+tall.charAt(i));
		}
		return sum;
	}
	
	public static boolean sjekk(int tall) {
		if (tall % 10 == 0)
			return false;
		int sum = tall + reverse(tall);
//		System.out.println(sum);
		String sumString = ""+sum;
		for (int i = 0; i < sumString.length(); i++) {
			if (sumString.charAt(i) % 2 != 1)
				return false;
		}
		return true;
	}
	
	public static int reverse(int tall) {
		StringBuilder a = new StringBuilder(""+tall);
		a.reverse();
		return Integer.parseInt(a.toString());
	}
	
	public static boolean asd(long i) {
		String tall = ""+i;
		if (tall.charAt(2) != '2')
			return false;
		if (tall.charAt(4) != '3')
			return false;
		if (tall.charAt(6) != '4')
			return false;
		if (tall.charAt(8) != '5')
			return false;
		if (tall.charAt(10) != '6')
			return false;
		if (tall.charAt(12) != '7')
			return false;
		if (tall.charAt(14) != '8')
			return false;
		if (tall.charAt(16) != '9')
			return false;
		return true;
	}
	
	public static boolean bouncy(int a) {
		String tall = ""+a;
		if (decreasing(tall))
			return false;
		else if (increasing(tall))
			return false;
		else 
			return true;
	}
	
	public static boolean increasing(String tall) {
		for (int i = 1; i < tall.length(); i++) {
			if (tall.charAt(i-1) > tall.charAt(i))
				return false;
		}
		return true;
	}
	
	
	public static boolean decreasing(String tall) {
		for (int i = 1; i < tall.length(); i++) {
			if (tall.charAt(i-1) < tall.charAt(i))
				return false;
		}
		return true;
	}
	
	public static boolean sjekk2(int a) {
		StringBuilder tall1 = new StringBuilder(""+a);
		StringBuilder tall2 = new StringBuilder("");
		
		tall2.append(tall1.charAt(0));
		tall1.delete(0, 1);
		while(tall1.length() != 0) {
			if(!erPrimtall(tall1))
				return false;
			if(!erPrimtall(tall2))
				return false;
			tall2.append(tall1.charAt(0));
			tall1.delete(0, 1);
		}
		if (!erPrimtall(tall2))
			return false;
		if (erPrimtall(a))
			return true;
		
		return false;
	}
	
	public static boolean erPrimtall(int tall) {
		if (tall <= 0)
			return false;
		else if (tall == 1)
			return false;
		for (int i = 2; i < Math.sqrt(tall)+2; i++) {
			if (tall % i == 0)
				return false;
		}
		return true;
	}
	public static boolean erPrimtall(StringBuilder string) {
		int tall = Integer.parseInt(string.toString());
		if (tall == 0)
			return false;
		else if (tall == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(tall); i++) {
			if (tall % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean[] primtallUnder(int tall) {

		
		boolean[] array = new boolean[tall+1];
		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}
		
		for (int i = 2; i < array.length/2; i++) {
			if (array[i]) {
				for (int j = 2*i; j < array.length; j+=i) {
					array[j]=false;
				}
			}
		}
		
		
//		for (int i = 1; i < array.length; i++) {
//			if (array[i])
//				System.out.print(i + ", ");
//		}
		
		return array;
	}

	
	public static long fibonacci (int nr) {
		if (nr == 1)
			return 0;
		else if (nr == 2)
			return 1;
		long a = 0;
		long b = 1;
		long c = a+b;
		for (int i = 0; i < nr-2; i++) {
			c = a+b;
			a=b;
			b=c;
		}
		return c;
	}
	
	public static BigInteger fibonacciNesteH0y() {
//		BigInteger c;
		cH0y = aH0y.add(bH0y);

		aH0y = bH0y;
		bH0y = cH0y;
		return cH0y;
	}
	
	public static long fibonacciNesteLav() {
		cLav = aLav+bLav;
		while(cLav > 1000000000)
			cLav-= 1000000000;
		aLav = bLav;
		while(aLav > 1000000000)
			aLav-= 1000000000;
		bLav = cLav;
		return cLav;
	}
	
	public static int divisors(int tall) {
		int divisors = 1;
		for (int i = 1; i <= tall/2; i++) {
			if (tall % i == 0) {
				divisors++;
			}
		}
		
		return divisors;
	}
	
	public static long fakultet(int j) {
		long sum = 1;
		for (int i = 1; i <= j; i++) {
			sum *= i;
		}
		return sum;
	}
	
	public static boolean sjekk(String string) {
		if(string.length() >= 19)
			System.out.println("lol");
		return false;
	}
	
	public static boolean lychrel(long tall) {
		for (int i = 0; i < 50; i++) {
			tall += reverse(tall);
			if (tall < 0)
				return true;
			if(palindrom(""+tall))
				return false;
		}
		return true;
	}
	
	public static long reverse(long tall) {
		String asd = ""+tall;
		String b="";
		for (int i = 0; i < asd.length(); i++) {
			b+=asd.charAt(asd.length()-1-i);
		}
		return Long.parseLong(b);
	}
	
	public static int sum(String asd) {
		int totsum = 0;
		for (int i = 0; i < asd.length(); i++) {
			int tall = Integer.parseInt(""+asd.charAt(i));
			totsum += tall*tall;
		}
		return totsum;
	}
	
	public static boolean like(String a, String b) {
		if (a.length() != b.length())
			return false;
		int[] ai = new int[10];
		int[] bi = new int[10];
		
		for (int i = 0; i < a.length(); i++) {
			ai[Integer.parseInt(""+a.charAt(i))] ++;
			bi[Integer.parseInt(""+b.charAt(i))] ++;
		}
		for (int i = 0; i < bi.length; i++) {
			if (ai[i] != bi[i])
				return false;
		}
		return true;
	}
	
	public static String lol(int tall) {
		String asd = "";
		for (int i = 20; i >= 0; i--) {
			if (opp(i) <= tall) {
				asd += "1";
				tall -= opp(i);
			} else if (!asd.equals(""))
				asd += "0";
		}
		return asd;
	}
	
	public static int opp(int i) {
		int s=1;
		for (int j = 0; j < i; j++) {
			s*=2;
		}
		return s;
	}
	
	public static long sjekkVannrett(int [][] tall){
		long storste = 0;
		for (int i = 0; i < tall.length; i++) {
			for (int j = 0; j < tall[0].length-3; j++) {
				long asd = 1;
				for (int j2 = 0; j2 < 4; j2++) {
					asd*=tall[i][j+j2];
				}
				if (storste < asd) {
//					System.out.println(storste);
					storste = asd;
				}
			}
		}
		return storste;
	}
	public static long sjekkLoddrett(int [][] tall){
		long storste = 0;
		for (int i = 0; i < tall[0].length-3; i++) {
			for (int j = 0; j < tall.length; j++) {
				long asd = 1;
				for (int j2 = 0; j2 < 4; j2++) {
					asd*=tall[i+j2][j];
				}
				if (storste < asd) {
//					System.out.println(storste);
					storste = asd;
				}
			}
		}
		return storste;
	}
	public static long sjekkDiagonalt(int [][] tall){
		long storste = 0;
		for (int i = 0; i < tall[0].length-3; i++) {
			for (int j = 3; j < tall.length; j++) {
				long asd = 1;
				for (int j2 = 0; j2 < 4; j2++) {
					asd*=tall[i+j2][j-j2];
				}
				if (storste < asd) {
//					System.out.println(storste);
					storste = asd;
				}
			}
		}
		return storste;
	}
	
	public static boolean palindrom(String a) {
		String b="";
		for (int i = a.length()-1; i > -1; i--) {
			b += a.charAt(i);
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				return false;
		}
		return true;
	}
	
}
