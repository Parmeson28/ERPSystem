package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import sistemaerp.database.DatabaseHandler;


public class InventoryManagement {

    
    private ArrayList<String> products = new ArrayList<>();

    BufferedReader reader;
    BufferedWriter writer;
    String line;

    DatabaseHandler db = new DatabaseHandler();

    public boolean verifyFile(){

        DatabaseHandler.dbConnection();

        System.out.println("All worked fine");
        return true;

    }

   public ArrayList<String> showItems(){
        return new ArrayList<String>();
   }


   public void registerItems(String description, String id, int quantity){
        
   }


   public void searchForItem(String description, String id){

        
   }

}
