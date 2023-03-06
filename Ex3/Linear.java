package newJava_Ex2;

/* 
 * 
 * IMPORTANT NOTE :)
 * In condition of division by zero the function return -1 
 * 
 * 
 * 
 * */
public class Linear {

	private double a;
	private double b;

	// constructor 
	public Linear(double a, double b) {
		this.a = a;
		this.b = b;
	}
	// copy constructor 
	public Linear(Linear lin) {
		this.a = lin.a;
		this.b = lin.b;
	}
	//generating getters and setters
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	// to string of all conditions 
	public String toString() {
		if (this.a == 0 && this.b == 0)
			return "y = " + 0;

		else if (this.a == 0 && this.b != 0)
			return "y = " + this.b;

		else if (this.b == 0 && this.a != 0 && this.a == 1)
			if (this.a == 1)
				return "y = x";
			else
				return "y = " + this.a + "x";
		else if (this.a == 1 && this.b >= 0)
			return "y = " + "x" + " + " + this.b;
		else
			if (this.b < 0)
				if (this.a == 1)
					return "y = " + "x " + this.b;
				else
					return "y = " + this.a + "x " + this.b;
		return "y = " + this.a + "x" + " + " + this.b;
	}
	// y = ax+b
	public double assign(double x) {
		return (this.a * x) + this.b;
	}
	// x = y-b/a 
	public double solve(double y) {
		// division by zero is unsolvable
		if (this.a == 0) {
			System.out.println("The slope is equal to 0, Cant solve x!");
			return -1;
		}
		return (y - this.b) / this.a;
	}
	public double getIntersection(Linear other) {
		// division by zero, lines are parallel 
		if ((this.a - other.a) == 0) {
			System.out.println("Unsolvable equation, division by zero!");
			return -1;
		}
		return (other.b - this.b) / (this.a - other.a);
	}
	public boolean isOnLine(double x, double y) {
		if (y == ((this.a * x) + this.b)) {
			return true;
		}
		return false;
	}
	public boolean areParallel(Linear other) {
		if (this.a == other.a)
			return true;
		return false;

	}
	public Linear createLinear(double x1, double y1, double x2, double y2) {
		// division by zero, unsolvable equation , return object of zeros 
		if ((x2 - x1) == 0) {
			System.out.println("invalid input");
			return new Linear(0, 0);
		}
		Linear newLine = new Linear((y2 - y1) / (x2 - x1), y2 - (((y2 - y1) / (x2 - x1)) * x2));
		return newLine;
	}
}