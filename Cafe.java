/**
* Cafe class represents a building that serves coffee to customers. It extends the Building class, adding coffee-related functionality.
* @author Vicky
*/

public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
/**
 
Constructor for the Cafe class.
@param name The name of the cafe.
@param address The address of the cafe.
@param nCoffeeOunces The number of coffee ounces available in the cafe.
@param nSugarPackets The number of sugar packets available in the cafe.
@param nCreams The number of cream splashes available in the cafe.
@param nCups The number of cups available in the cafe.
*/

    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nCoffeeOunces);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
/**

This method sells a cup of coffee to the customer with the given size, sugar and cream.
@param size The size of the coffee to sell in ounces.
@param nSugarPackets The number of sugar packets in the coffee to sell.
@param nCreams The number of cream splashes in the coffee to sell.
@param name The name of the customer who is buying the coffee.
*/

    public void sellCoffee(int size, int nSugarPackets, int nCreams, String name) {
        if (size <= nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
            System.out.println("Sold " + size + " ounces of coffee with " + nSugarPackets + " sugar packet(s) and " + nCreams + " splash(es) of cream to " + name + ".");
        } else {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups, "Monday");
            System.out.println("Sorry, we're out of stock!");
        }
    }
/**

This method restocks the cafe with a specified number of coffee ounces, sugar packets, cream splashes, cups, and day of the week.
@param nCoffeeOunces The number of coffee ounces to restock.
@param nSugarPackets The number of sugar packets to restock.
@param nCreams The number of cream splashes to restock.
@param nCups The number of cups to restock.
@param day The day of the week when restocking occurs.
*/
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, String day) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked supplies on " + day + ".");
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
        if (floorNum < 1) {
            throw new RuntimeException("Invalid floor number. It's accessible only to employees.");
        }
        if (floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
/**
 * Displays the available options for this Cafe.
 */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()");
    }

    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Cafe constructor/methods");
        System.out.println("------------------------------------");
            
        Cafe campusCafe = new Cafe("Campus Cafe", "1 Chapin Way Northampton, MA 01063", 50, 50, 50, 50);
        System.out.println(campusCafe);
        campusCafe.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation/sell coffee");
        System.out.println("-----------------------------------");
        campusCafe.enter();
        campusCafe.goToFloor(2);
        campusCafe.goUp();
        campusCafe.goDown();
        campusCafe.goDown();
        campusCafe.exit();
        campusCafe.sellCoffee(12, 2, 1, "Vicky");
        campusCafe.restock(50, 50, 50, 50, "Monday");
    }
}