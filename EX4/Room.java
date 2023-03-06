package newJava_Ex2;

public class Room {
	 // class variables 
	private String type;
	private double area;

	// constructor 
	public Room(String type, double area) {
		this.type = type;
		this.area =(area < 0) ? 0 :area ;
	}
	// copy constructor 
	public Room(Room other) {
		this.type = other.type;
		this.area = other.area;
	}
	// getters and setters 
	public String getType(){
		return this.type;
	}
	public double getArea(){
		return this.area;
	}
	public void setType(String name){
		this.type = name;
	}
	// print to string function 
	public String toString(){ 
		return "Room type: " + this.type + ", Area: " + this.area +"\n";
	}
}