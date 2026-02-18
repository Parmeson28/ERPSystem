package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sistemaerp.database.DatabaseHandler;


//This class handles the inventory logic of the program
//Logic related to parts go here
public class InventoryManagement {

    
    private ArrayList<String[]> products = new ArrayList<>();

    BufferedReader reader;
    BufferedWriter writer;
    String line;

    DatabaseHandler db = new DatabaseHandler();

    //Verifies if the connection with the databse is happening with no issues
    public boolean verifyFile(){

        db.dbConnection();

        System.out.println("All worked fine");
        return true;

    }

    //Register the items on the database if all the fields are correctly filled
    // <------------ ******** MUST DO: Not allow parts to be registered under the same SKU ******** ------------>
     public void registerItems(String description, String id, int quantity, String machinery){
     

          if(!description.strip().equals("") || !id.strip().equals("") || !machinery.strip().equals("")){

               db.registerProducts(description, id, quantity, machinery);
               System.out.println("Item foi enviado para cadastro");

          }else{
               System.out.println("Campos incompletos");
          }

     }

     //Searchs for an item that matches EXACTLY description AND sku
     public String searchForItem(String description, String sku){

          products = db.showItems();

          for(String[] a : products){

               if(a[0].equals(description) && a[1].equals(sku) && !a[0].equals("") && !a[1].equals("")){

                    return a[0] + " " + a[1] + " " + a[2];
               }
          }

          return null;
     }

     //Searches on the searchWindow. 
     //Can use parts of the description or parts of the SKU to find the item
     public List<String[]> searchForNonSpecItem(String description, String sku, String equipament){
          
          products = db.showItems();
          List<String[]> results = new ArrayList<>();

          for(String[] a : products){

               if((description == null || a[0].contains(description)) && (sku == null || a[1].contains(sku))){
                    System.out.println(Arrays.toString(a));
                    System.out.println(a[0]);
                    
                    results.add(a);
               }

          }

          return results;
     }
          /*
          MAYBE USE LATER
          if(foundItem == false){
               for(String a : c){
                    String[] b = a.split(" ");

                    if(b[0].equals(description) || b[1].equals(sku)){
                         System.out.println(a);
                    }
               }
          }

          */

     public void changeItemQuantity(String description, String sku, int quantity){

          db.alterProductQuant(description, sku, quantity);

     }

     //Shows every item on the database
     //Used when it is needed to display every item registered
     public ArrayList<String> showItem(){

          products = db.showItems();

          ArrayList<String> p = new ArrayList<>();

          for(String[] a : products){
               p.add(a[0] + " " + a[1] + " " + a[2]);
          }

          return p;
     }

}


