/**

The Library class represents a building that functions as a library. It extends the Building class and uses a Hashtable to store the collection of books.
Inherits from the Building class.
*/
import java.util.Hashtable;
/**
 * Constructs a Library object with the given name, address, and number of floors.
 * 
 * @param name the name of the library
 * @param address the address of the library
 * @param nFloors the number of floors in the library
 */
public class Library extends Building {
    private Hashtable<String, Boolean> collection = new Hashtable<>();

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
    }
/**
 * Adds a new title to the library's collection with the given title and author.
 * 
 * @param title the title of the book to be added
 * @param author the author of the book to be added
 * @throws RuntimeException if the book already exists in the inventory
 */
    public void addTitle(String title, String author) {
        String key = title + " by " + author;
        if (collection.containsKey(key)) {
            throw new RuntimeException("Book already exists in inventory.");
        }
        collection.put(key, true);
    }
/**
 * Removes a title from the library's collection with the given title.
 * 
 * @param title the title of the book to be removed
 * @return the title of the removed book
 * @throws RuntimeException if the book is not found in the inventory
 */
    public String removeTitle(String title) {
        if (!collection.containsKey(title)) {
            throw new RuntimeException("Book not found in inventory.");
        }
        collection.remove(title);
        return title;
    }
/**
 * Checks out a book from the library with the given title and name of the borrower.
 * 
 * @param title the title of the book to be checked out
 * @param name the name of the borrower
 * @throws RuntimeException if the book is not available for checkout
 */
    public void checkOut(String title, String name) {
      if (collection.containsKey(title) && collection.get(title)) {
          collection.put(title, false);
          System.out.println(title + " has been checked out by " + name + ".");
        } else {
            throw new RuntimeException("Book not available for checkout.");
        }
      }
/**
 * Returns a book to the library with the given title.
 * 
 * @param title the title of the book to be returned
 */
    public void returnBook(String title) {
        collection.put(title, true);
    }
/**
 * Checks if the library's collection contains a book with the given title.
 * 
 * @param title the title of the book to be checked
 * @return true if the library's collection contains the book, false otherwise
 */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }
/**
 * Checks if a book with the given title is available for checkout.
 * 
 * @param title the title of the book to be checked
 * @return true if the book is available, false otherwise
 */
    public boolean isAvailable(String title) {
        return collection.containsKey(title) && collection.get(title);
    }
/**
 * Prints the library's collection of books and their availability status.
 */
    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : collection.keySet()) {
            System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked out"));
        }
    }
/**
 * This method moves the customers to different floors.
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
        if (Math.abs(floorNum - nFloors) > 1) {
            System.out.println("Sorry, this elevator can't move between adjacent floors.");
            return;
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut()\n + returnBook()");
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Library constructor/methods");
        System.out.println("------------------------------------");
        
        Library Neilson = new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4);
        System.out.println(Neilson);
        Neilson.showOptions();
    
        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/check out/return");
        System.out.println("-----------------------------------");
        Neilson.enter();
        Neilson.goToFloor(3);
        Neilson.goUp();
        Neilson.goDown();
        Neilson.returnBook("Java");
        Neilson.returnBook("Python");
        Neilson.addTitle("C++","Jordan");
        Neilson.printCollection();
        Neilson.checkOut("Java", "Vicky");
        Neilson.printCollection();
      }

}