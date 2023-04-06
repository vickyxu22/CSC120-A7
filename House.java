/**

The House class represents a residential building with multiple floors and optional amenities like a dining room and an elevator.
Inherits from the Building class.
*/
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

/**

Constructs a new House object with the specified name, address, number of floors, dining room availability, and elevator availability.
@param name the name of the house
@param address the address of the house
@param nFloors the number of floors in the house
@param hasDiningRoom a boolean indicating whether or not the house has a dining room
@param hasElevator a boolean indicating whether or not the house has an elevator
*/
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }
/**

Returns a boolean indicating whether or not the house has a dining room.
@return a boolean indicating whether or not the house has a dining room
*/
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
/**

Returns the number of residents currently living in the house.
@return the number of residents currently living in the house
*/
  public int nResidents() {
    return this.residents.size();
  }
/**

Adds a new resident with the specified name and occupation to the house.
@param name the name of the new resident
@param occupation the occupation of the new resident
@throws RuntimeException if the resident is already living in the house
*/
  public void moveIn(String name, String occupation) {
    if (this.residents.contains(name)) {
        throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    this.residents.add(name);
    System.out.println(name + ", who works as a " + occupation + " , has just moved into " + this.name + "! Go say hello :-)");
  }
/**

Returns a string representation of the House object, including its name, address, number of floors, number of residents, and dining room availability.
@return a string representation of the House object
*/
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }
/**

Removes a resident with the specified name and age from the house.
@param name the name of the resident to remove
@param age the age of the resident to remove
@throws RuntimeException if the resident is not living in the house
*/
  public void moveOut(String name, int age) {
    if (!this.residents.contains(name)) {
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name +  ", age " + age + ", has just moved out " + this.name + ".");
  }
/**

Checks if the given person is a resident of this House.
@param person the name of the person to check
@return true if the person is a resident of this House, false otherwise
*/
  public boolean isResident(String person) {
    return residents.contains(person);
  } 
/**

This method moves the customers to different floors.
 * @param floorNum The floor number to move to
 * @throws RuntimeException If the user is not inside the building or if the specified floor number is out of range
*/
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!hasElevator) {
      System.out.println("Sorry, there is no elevator in this house.");
      return;
  }
    if (Math.abs(floorNum - nFloors) > 1) {
      System.out.println("Sorry, this elevator can't move between adjacent floors.");
      return;
  }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
}

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()");
}

  public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("Test of House constructor/methods");
    System.out.println("------------------------------------");
    
    House Chase = new House("Chase", "3 Green St Northampton, MA 01063", 4, false, true);
    System.out.println(Chase);
    Chase.showOptions();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation/move in/move out");
    System.out.println("-----------------------------------");
    Chase.enter();
    Chase.goToFloor(3);
    Chase.goUp();
    Chase.goDown();
    Chase.moveIn("Vicky", "student");
    Chase.moveOut("Vicky", 18);
  }
}