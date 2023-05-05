import java.util.Hashtable;

/**
 * This class extends from the Building parent class
 * and construct a Library
 */
public class Library extends Building {

  /** A private attribute creating a hashtable to store the book collection of the library*/
  private Hashtable<String, Boolean> collection;

  /** A boolean to indicate whether or not the library has an elevator */
  private boolean hasElevator; 

    /**
     * Default constructor: Construct a library with no parameter
     */
    public Library() {
      super();
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Overloaded constructor: Construct a library with an address
     * @param address the address of the library
     */
    public Library(String address) {
      super(address);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Overloaded constructor: Construct a library with name and address
     * @param name the name of the library
     * @param address the address of the library
     */
    public Library(String name, String address) {
      super(name, address);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Full constructor: Construct a library with name, address, nFloors, and hasElevator
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors of the library
     * @param hasElevator whether or not the library has an elevator
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * Method to add a book title into the collection
     * @param title the title of the book
     */
    public void addTitle(String title) {
      // check if the book title is already in the library, if yes, throw an exception
      if (containsTitle(title) == true) {
        throw new RuntimeException("Error! Cannot add " + title + " because it is already in the collection of " + this.name + ".");
      }
      // add the book title into the collection
      this.collection.put(title, true);
      System.out.println(title + " has just moved into the collection of " + this.name + ".");
    }

    /**
     * Method to remove a book title from the collection
     * @param title the title of the book
     * @return the title that is removed
     */
    public String removeTitle(String title) {
      if (containsTitle(title) == false) {
        throw new RuntimeException("Error! Cannot remove " + title + " because it is not in the collection of " + this.name + ".");
      }
      // return the title that we removed
      this.collection.remove(title);
      System.out.println(title + " has been removed from the collection of " + this.name + ".");
      return title;
    } 
    
    /**
     * Method to check a book out from the library
     * @param title the title of the book
     */
    public void checkOut(String title) {
      // check if the library collection has the book
      if (containsTitle(title) == false) {
        throw new RuntimeException("Error! Cannot check out " + title + " because it is not in the collection of " + this.name + ".");
      }
      // check if the book is avaliable to be checked out from the library
      if (isAvailable(title) == false) {
        throw new RuntimeException("Error! Cannot check out " + title + " because it is already checked out from " + this.name + ".");
      }
      // check out the book
      collection.replace(title, true, false);
      System.out.println(title + " is successfully checked out from " + this.name + ".");
    }
    
    /**
     * Method to return a book to the library
     * @param title the title of the book
     */
    public void returnBook(String title) {
      // check if the library collection has the book
      if (containsTitle(title) == false) {
        throw new RuntimeException("Error! Cannot return " + title + " because it is not in the collection of " + this.name + ".");
      }
      // check if the book is avaliable to be returned to the library
      if (isAvailable(title) == true) {
        throw new RuntimeException("Error! Cannot return " + title + " because it was not borrowed from " + this.name + ".");
      }
      // return the book
      collection.replace(title, false, true);
      System.out.println(title + " is successfully return to " + this.name + ".");
    }

    /**
     * Boolean method to check if the library collection has the book
     * @param title the title of the book
     * @return boolean true if the library has the book, 
     * and false if the library does not have the book
     */
    public boolean containsTitle(String title) {
      // returns true if the title appears as a key in the Libary's collection, false otherwise
      if (this.collection.containsKey(title)) {
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Method to check if the book is avaliable to be checked out
     * @param title the title of the book
     * @return boolean true if the book is avaliable to be checked out, 
     * and false if the book is unavaliable to be checked out
     */
    public boolean isAvailable(String title) {
      // returns true if the title is currently available, false otherwise
      if (this.collection.get(title) == true) {
        return true;
      }
      else {
        return false;
      }
    }
    
    /** Method to print the whole collection of the library */
    public void printCollection() {
      // prints out the entire collection in an easy-to-read way (including checkout status)
      for (String title : collection.keySet()) {
        System.out.println("Name: " + title + ", Available Status: " + isAvailable(title));
      }
    }

    /**
     * Method to show all available options for this class
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
    }

    /**
     * Method to take the elevator if there is an elevator in the house.
     * ps. I did not used super for this class but wrote a more 
     * complicated overrided method. This works better than using super.
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this library. Must call enter() before navigating between floors.");
    }
      if (this.hasElevator) {
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors +".");
        }
        System.out.println("You took the elevator and you are now on floor #" + floorNum + " of " + this.name + ".");
        this.activeFloor = floorNum;
      } 
      else if ((!this.hasElevator) && ((floorNum == this.activeFloor) || (floorNum == this.activeFloor + 1) || (floorNum == this.activeFloor - 1))) {
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors +".");
        }
        System.out.println("You walked to floor #" + floorNum + ".");
        this.activeFloor = floorNum;
      } 
      else {
        throw new RuntimeException("You cannot directly go to floor #" + floorNum + " because there is no elevator in this library." );
      }
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "some street", 4, false);
      neilson.showOptions();
      neilson.addTitle("Bird Book");
      //neilson.removeTitle("Bird Book");
      //neilson.removeTitle("Bird Book");
      neilson.checkOut("Bird Book");
      //neilson.removeTitle("Bird Book");
      //neilson.checkOut("Bird Book");
      //neilson.returnBook("Bird Book");
      //neilson.returnBook("Bird Book");
      //neilson.checkOut("AAA");
      //neilson.returnBook("AAA");
      neilson.addTitle("Something");
      neilson.addTitle("Another Book");
      neilson.printCollection();

      neilson.enter();
      neilson.goToFloor(2);
      System.out.println(neilson.toString());

      Library young = new Library("young", "some address");
      System.out.println(young.toString());
    }
  }
