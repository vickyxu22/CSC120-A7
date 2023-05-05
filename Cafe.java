/**
 * This class extends from the Building parent class
 * and construct a Cafe
 */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator; // A boolean to indicate whether or not the library has an elevator

    /**
     * Overloaded consructor: construct a overloaded cafe with parameters listed below
     * the difference between this constructor and the full constructor is the parameter hasElevator
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nCoffeeOunces the amount of coffee (in ounce) in the inventory of the cafe
     * @param nSugarPackets the number of sugar packets in the inventory of the cafe
     * @param nCreams the number of creams in the inventory of the cafe
     * @param nCups the number of cups of coffee in the inventory of the cafe
     */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = false;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Full constructor: construct a cafe with parameters listed below
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors of the cafe
     * @param nCoffeeOunces the amount of coffee (in ounce) in the inventory of the cafe
     * @param nSugarPackets the number of sugar packets in the inventory of the cafe
     * @param nCreams the number of creams in the inventory of the cafe
     * @param nCups the number of cups of coffee in the inventory of the cafe
     * @param hasElevator whether or not the cafe has an elevator
     */
    public Cafe(String name, String address, int nFloors, boolean hasElevator, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.hasElevator = hasElevator; //the extra parameter of this constructor
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded sellCoffee method: Give the customer one or more cups of water for free! Like Starbucks :)
     * @param nCups the number of cups of water given to the customer
     */
    public void sellCoffee(int nCups) {
        //check if there are enough cups in the inventory
        if (this.nCups >= nCups) {
            this.nCups -= nCups;
            System.out.println("You have successfully gave " + nCups + " cups of water to the customer!");
        }
        else {
            //restock cups
            this.restock(0,0,0, nCups); 
            //after restock the inventory, gave cup/cups of water to the customer
            this.nCups -= nCups;
            System.out.println("You have successfully gave " + nCups + " cups of water to the customer!");
        }
    }

    /**
     * Full sellCoffee method to sell a cup of coffee
     * @param size the amount of coffee (in ounce) to sell
     * @param nSugarPackets the number of sugar packets to sell
     * @param nCreams the number of creams to sell
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        //check if all requirements are met
        if (this.nCoffeeOunces >= size && 
            this.nSugarPackets >= nSugarPackets && 
            this.nCreams >= nCreams && 
            this.nCups >= 1) {
                //sell the coffee if all requirements are met
                this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups -= 1;
                System.out.println("Successfully sold a cup of coffee!");
        }
        else {
            //restock the right amount of nCoffeeOunces, nSugarPackets, nCreams, and nCups
            this.restock(Math.max(0, size - this.nCoffeeOunces), 
                         Math.max(0, nSugarPackets - this.nSugarPackets), 
                         Math.max(0, nCreams - this.nCreams), 
                         Math.max(0, 1 - this.nCups));
            //after restocked the inventory, sell the coffee
            this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups -= 1;
                System.out.println("Restocked the inventory and successfully sold a cup of coffee!");
        }
    }

    /**
     * Method to restock the inventory accroding to needs
     * @param nCoffeeOunces the amount of coffee (in ounce) to restock
     * @param nSugarPackets the number of sugar packets to restock
     * @param nCreams the number of creams to restock
     * @param nCups the number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Method to show all available options for this class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()");
    }

    /**
     * Default/Overloaded method to move the user to other floors
     * ps. I did not used super for this class but wrote a more complicated overrided method. 
     * I demonstrated my understanding of super in the House class.
     * @param floorNum the floor number the user wants to go to
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this cafe. Must call enter() before navigating between floors.");
      }
        if (this.hasElevator) {
          if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this cafe is 1-" + this.nFloors +".");
          }
          System.out.println("You took the elevator and you are now on floor #" + floorNum + " of " + this.name + ".");
          this.activeFloor = floorNum;
        } 
        else if ((!this.hasElevator) && ((floorNum == this.activeFloor) || (floorNum == this.activeFloor + 1) || (floorNum == this.activeFloor - 1))) {
          if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this cafe is 1-" + this.nFloors +".");
          }
          System.out.println("You walked to floor #" + floorNum + ".");
          this.activeFloor = floorNum;
        } 
        else {
          throw new RuntimeException("You cannot directly go to floor #" + floorNum + " because there is no elevator in this cafe." );
        }
      }

      /**
       * Full method to move the user to other floors.
       * @param floorNum the floor number the user wants to go to
       * @param isEmployee the status of the user (employee or not)
       */
      public void goToFloor(int floorNum, boolean isEmployee) {
        if (isEmployee == true) {
          goToFloor(floorNum);
        }
        else {
          if (floorNum == this.activeFloor) {
            System.out.println("You are already on the first floor of this cafe.");
          }
          else {
            System.out.println("Sorry, other floors are accessible only to employees.");
          } 
        }
      }



    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "some street", 3, true, 2, 2, 2, 2);
        campusCenter.showOptions();
        campusCenter.sellCoffee(3,2, 1);

        campusCenter.enter();
        campusCenter.goUp();
        campusCenter.goDown();
        campusCenter.goToFloor(3, true);
        System.out.println(campusCenter.toString());
    }
    
}
