package lambdaAndStream;

public class Point implements Comparable<Point>{
	private int x , y ;
	
	public int getX() { return x ;}
	public int getY() { return y ;}
	
	public Point(int x , int y){
		this.x =x; ; this.y = y;
	}
	
	public int distance1(Point p){ return p.getX() - x ; }
	
	public int distance2(Point p){ return p.getY() - y ; }
	public int distance_a(Point p){ return p.getX() - x ;}
	
	
//	public int compareTo(Point p) {
//		if(this.x < p.getX()) return -1 ;
//		else if(this.y> p.getY()) return 1 ;
//		else if(this.y< p.getY()) return -1 ;
//		else if(this.y> p.getY()) return 1 ;
//		else return 0 ;		
//	}
	
	public int compareTo(Point p){
		if(this.x < p.x) return -1 ;
		else if(this.x == p.x) return 0 ;
		else return 1 ;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
		
}