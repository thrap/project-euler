import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem102 {
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}
	
	public static int solution() throws IOException{
//		A(-340,495), B(-153,-910), C(835,-947)
//		X(-175,41), Y(-421,-714), Z(574,-645)
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/Problem102.txt"));
		String linje = null;
		int teller = 0;
//		System.out.println(inneholder(-340,495,-153,-910,835,-947));
//		System.out.println(inneholder(-175,41,-421,-714,574,-645));
		while ((linje = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linje, ",");
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			
			if (inneholder(ax, ay, bx, by, cx, cy)) {
				teller++;
			}
		}
		return teller;
	}

	public static boolean inneholder(int ax, int ay, int bx, int by, int cx, int cy) {
		double a = areal(ax, ay, bx, by, cx, cy);
		double b = areal(0, 0, bx, by, cx, cy) + areal(ax, ay, 0, 0, cx, cy) + areal(ax, ay, bx, by, 0, 0);
//		System.out.println(a + " " + b);
		return a == b || (a-b == 1);
	}
	
	public static double areal(int ax, int ay, int bx, int by, int cx, int cy) {
		if (((ax*(by - cy) + bx*(cy - ay) + cx*(ay - by))/2) < 0)
			return ((ax*(by - cy) + bx*(cy - ay) + cx*(ay - by))/2)*-1;
		return ((ax*(by - cy) + bx*(cy - ay) + cx*(ay - by))/2);
	}
}
