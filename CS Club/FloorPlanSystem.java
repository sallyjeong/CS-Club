/* * * * * Imports * * * * */
import java.util.ArrayList;
import java.awt.Graphics;
/**
 * [FloorPlanSystem.java]
 * This class represents a floor plan system
 * @author Peter Gao, Anthony Tecsa
 * @version 1.0
 * @since Oct 2021
 */
public class FloorPlanSystem {
    
    private ArrayList<Table> tableList;
    private int tableCapacity;
    
    /**
     * Constructs a new floor plan system 
     */
    public FloorPlanSystem() {
        tableList = new ArrayList<Table>();
        tableCapacity = 20;
    }
    
    /**
     * getTableList
     * @return ArrayList<Table> the arraylist of tables
     */
    public ArrayList<Table> getTableList() {
        return this.tableList;
    }
    
    /**
     * displayTables
     * draws all the tables in the arraylist
     */
    public void displayTables(Graphics g) {
        for(int i=0; i < tableList.size(); i++) {
            tableList.get(i).draw(g);
        }
    }
    
    /**
     * addTable
     * @param t The table object that is being added
     * @return boolean, whether the addition was successful or not
     */
    public boolean addTable(Table t) {
        if(tableList.size()<tableCapacity) {
            tableList.add(t);
            return true;
        }
        return false;
    }
    
    /**
     * removeTable
     * @param id An integer holding the id of the table being removed
     * @return boolean, whether the removal was successful or not
     */
    public boolean removeTable(int id) {
        for(int i=0; i<tableList.size(); i++) {
            if(tableList.get(i).getID()==id) {
                tableList.remove(i);
                return true;
            }
        }
        return false;
    }
    
}