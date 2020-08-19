public class Problem76 {
//	public static void main(String[] args) {
//		//4+1
//		//3+2
//		//3+1+1
//		//2+2+1
//		//2+1+1+1
//		//1+1+1+1+1
//		
//		//
//		
//		//2=1+1&2
//		//3=[2]+1
//		//4=[3]+1
//		//1*1
//		//1*2*2
//		//1*1
//		String asd = "";
//		for (int i = 0; i < 5; i++) {
//			asd+="1";
//		}
//		System.out.println(asd);
//		for (int i = 0; i < asd.length(); i++) {
//			
//		}
//		
//		//1=1 = 1
//		//2=2 = 1
//		//3= (2+1) = 2
//		//4= (3+1) & (2+2) = 2
//		//5= (4+1) & (3+2) = 2 = 
//		//6=(5+1) & (4+2) & (3+3) & (2+2+2)=4 = 10
//		//7=(6+1) & (5+2) & (4+3) & (3+2+2) & (2+2+2+1)=4 = 12
//		//
//		//(5+1) & (4+2) & (4+1+1) & (3+3) & (3+2+1) & (3+1+1+1) & (2+2+2) & (2+2+1+1) & (2+1+1+1+1) & (1+1+1+1+1+1)
//		//[5-1]+([5-2]+[2]) 
//		//(6+1) & (5+2) & (5+1+1) & (4+3) & (4+2+1) & (4+1+1+1) & (3+3+1) & (3+2+2) & (3+2+1+1) & (3+1+1+1+1) & (2+1+1+1+1+1) & (1+1+1+1+1+1+1)
//		
//	}
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		int [] array = new int[101]; 
		for (int i = 1; i < array.length-1; i++) {
			int tall = i;
			++array[tall];
			for (int j = tall; j < array.length; ++j) {
				array[j]+=array[j-tall];
			}
		}
		return array[100];
	}
}
