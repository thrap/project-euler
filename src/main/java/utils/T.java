package utils;

public class T {
	long start;
	public T() {
		start = System.currentTimeMillis();
	}
	
	public long ms() {
		return System.currentTimeMillis()-start;
	}
	
	public long secs() {
		return ms()/1000;
	}
	
	public String toString() {
		return "("+ms()+" ms)";
	}
}
