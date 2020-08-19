package problem424;

public class EncryptedSum implements Cell {
	public String horizontal = "";
	public String vertical = "";

	public String rawString;
	public EncryptedSum (String s) {
		rawString = s;
		for (String el : s.split(",")) {
			if (el.charAt(0) == 'h') {
				horizontal = el.substring(1);
			} else {
				vertical = el.substring(1);
			}
		}
	}
	
	public boolean isVertical() {
		return this.vertical.length() != 0;
	}
	
	public boolean isHorizontal() {
		return this.horizontal.length() != 0;
	}
	
	public String toRawString() {
		return "("+rawString+")";
	}
}

