import java.util.ArrayList;

/* This class stores information about campus buildings */
public class CampusMap {

    /**
     * Create an empty arraylist to store building information
     */
    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /* Print the arraylist into strings */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sabin Reed Hall", "4 Prospect Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "7 College Lane Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Neilson Library", "7 College Lane Northampton, MA 01063", 6));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "33 Elm Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Capen House", "26 Prospect St Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Gillet House", "10 Elm Street Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Hubbard House", "3 Green Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Campus Cafe", "10 Chapin Way Northampton, MA 01063", 1));

        System.out.println(myMap);
    }
    
}

