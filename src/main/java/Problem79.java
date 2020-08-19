import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Problem79 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:/Python27/input.txt"));
		
		HashMap foran = new HashMap();
		HashMap bak = new HashMap();
		String[] string = new String[50];
		
		//73162890
		char test = '9';
		for (int i = 0; i < string.length; i++) {
			string[i] = in.readLine();
			if (string[i].contains(""+test)) {
				boolean fpr=true; 
				for (int j = 0; j < 3; j++) {
					if (string[i].charAt(j) == test) {
						fpr = false;
						continue;
					}
					if (fpr) {
						foran.put(string[i].charAt(j), fpr);
					}
					else
						bak.put(string[i].charAt(j), fpr);
						
				}
			}
		}
		System.out.println(foran + " "+test + " " + bak);
	}
}
