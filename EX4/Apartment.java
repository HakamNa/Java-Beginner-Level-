package newJava_Ex2;  
// for using objects featuers 
import java.util.Objects;


/* NOTE : THE OBJECT LIBRBRY USED TO CHECK THE CONDITION
 * OF THE OBJECTS IF THEY ARE EQUAL TO NULL IN FORMAL WAY 
 * IN PLACE OF if(obj == null) ==> Object.isNull(obj)
 */
public class Apartment{
	// class variables 
	private int flat;
	private int numOfRooms;
	private String family;
	private Room firstRoom;
	private Room secondRoom;
	private Room thirdRoom;
	// constructor , if flat <0 then flat = 0
	public Apartment(String name, int flat){
		this.family = name;
		this.flat = (flat < 0) ? 0 : flat; 						   
		this.firstRoom = null; 
		this.secondRoom = null;
		this.thirdRoom = null;
		this.numOfRooms = 0; 
	}
	// getters and setters 
	public String getFamily(){
		return family;
	}
	public int getFlat(){
		return flat;
	}
	// checks the rooms by its type
	public Room getRoomByType(String type){
		if (!Objects.isNull(this.firstRoom)){
			if( this.firstRoom.getType().equals(type) )
				return new Room(this.firstRoom);
		}
		if (!Objects.isNull(this.secondRoom)) {
			if(this.secondRoom.getType().equals(type) )
				return new Room(this.secondRoom);
		}
		if (!Objects.isNull(this.thirdRoom)) {
			if(this.thirdRoom.getType().equals(type) )
				return new Room(this.thirdRoom);
		}
		return null;
	}
	public int getNumOfRooms(){
		return numOfRooms;
	}
	public void setRoom(Room r){
		if (this.numOfRooms < 3){
			if (Objects.isNull(this.firstRoom)){
				this.firstRoom = new Room(r);
				this.numOfRooms++;
			}
			else if (Objects.isNull(this.secondRoom)) {
				this.secondRoom = new Room(r);
				this.numOfRooms++;
			}
			else if (Objects.isNull(this.thirdRoom)) {
				this.thirdRoom = new Room(r);
				this.numOfRooms++;
			}
			else
				return;
		}
		else
			return;
	}
	// function to sum the areas of the rooms if its not null 
	public double getTotalArea(){
		double sum = 0;
		if(!Objects.isNull(this.firstRoom)) 
			sum += this.firstRoom.getArea();
		if(!Objects.isNull(this.secondRoom)) 
			sum += this.secondRoom.getArea();
		if(!Objects.isNull(this.thirdRoom)) 
			sum += this.thirdRoom.getArea();
		return sum;
	}
	// print the rooms if not null according to the wanted conditions 
	public String toString(){
		String toPrint = "";
		toPrint += (this.family + "'s apartment, flat " + this.flat + " has " + this.numOfRooms + " rooms\n") ;
		if(!Objects.isNull(this.firstRoom)) 
			toPrint  += this.firstRoom.toString() ;
		if(!Objects.isNull(this.secondRoom)) 
			toPrint += this.secondRoom.toString();
		if(!Objects.isNull(this.thirdRoom)) 
			toPrint += this.thirdRoom.toString();
		return toPrint ;
	}
}