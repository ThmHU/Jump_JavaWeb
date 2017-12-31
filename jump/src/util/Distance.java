package util;

public class Distance {

	public Distance() {
		// TODO Auto-generated constructor stub
	}
	public int distance(int x1,int y1,int x2,int y2){
		return (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
