package utils;


public class Point3d {
	public final int x;
	public final int y;
	public final int z;
	
	public Point3d(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return x + " " + y + " "+z;
	}
	
	public int hashCode() {
		int result = 373;
		result = 37 * result + x;
		result = 37 * result + y;
		result = 37 * result + z;
		return result;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Point3d)) 
			return false;
		Point3d p = (Point3d)o;
		return p.x==x && p.y == y && p.z == z;
	}
}
