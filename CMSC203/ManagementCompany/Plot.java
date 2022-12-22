package assignment4;

public class Plot extends Object{
	
	//fields
	private int x, y, depth, width;
	
	//constructors
	Plot(){
		x = 0; 
		y = 0;
		width = 1;
		depth = 1;
	}
	
	Plot(Plot p){
		x = p.x;
		y = p.y;
		depth = p.depth;
		width = p.width;
	}
	
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//methods
	//determines if this plot overlaps the parameter,returns true if the two plots overlap, false otherwise
	public boolean overlaps(Plot plot) {
		
		int leftCanvas = x, rightCanvas = leftCanvas+width, topCanvas = y, botCanvas = topCanvas+depth ;
		int left = plot.getX(), right = plot.getX()+plot.getWidth();
		int up = plot.getY(), bot = plot.getY()+plot.getDepth();
		
		if ((leftCanvas < right) && (rightCanvas > left) 
				                 &&
			   (topCanvas < bot) && (botCanvas > up)) {		
			return true;
		}
		else 
			return false;
		}
	
	//takes a Plot instance and determines if the current plot contains it. Note that the determination 
	//should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
	public boolean encompasses(Plot plot) {
		//System.out.println("x: " + x + "plot.x: " + plot.getY());
		
		int leftCanvas = x, rightCanvas = x+width, topCanvas = y, botCanvas = y-depth ;
		int left = plot.getX(), right = plot.getX()+plot.getWidth();
		int up = -plot.getY(), bot = plot.getY()-plot.getDepth();

		if((leftCanvas <= left && rightCanvas >= right) && (topCanvas >= up && botCanvas <= bot)) {
			return true;
		} else {
			return false;	
		}			
	}
	
	//getter and setter methods
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Upper left: " + "(" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
