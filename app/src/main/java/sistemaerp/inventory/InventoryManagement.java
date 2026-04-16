package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import sistemaerp.database.DatabaseHandler;
import sistemaerp.model.Product;


//This class handles the inventory logic of the program
//Logic related to parts go here
public class InventoryManagement {

    
    private ArrayList<Product> products = new ArrayList<>();

    BufferedReader reader;
    BufferedWriter writer;
    String line;

    public List<Product> results = new ArrayList<>();

    DatabaseHandler db = new DatabaseHandler();

    //Verifies if the connection with the databse is happening with no issues
    public boolean verifyFile(){

        db.dbConnection();

        System.out.println("All worked fine");
        return true;

    }

    //Register the items on the database if all the fields are correctly filled
    // <------------ ******** MUST DO: Not allow parts to be registered under the same SKU ******** ------------>
     public void registerItems(String description, String sku, int quantity, String machinery){

          boolean registered = false;

          for(Product a : showItem()){
               if(sku.equals(a.getSku())){
                    System.out.println("Código já registrado em outro item");
                    registered = true;
                    break;
               }

          }

          if(registered == false){
               if(!description.strip().equals("") || !sku.strip().equals("") || !machinery.strip().equals("")){
                    
                    db.registerProducts(description, sku, quantity, machinery);
                    System.out.println("Item foi enviado para cadastro");

               }else{
                    System.out.println("Campos incompletos");
               }
          }
     }

     //Searchs for an item that matches EXACTLY description AND sku
     public Product searchForItem(String description, String sku){

          products = db.showItems();

          for(Product a : products){

               if(a.getDescription().equals(description) && a.getSku().equals(sku)){

                    return a;
               }
          }

          return null;
     }

     //Searches on the searchWindow. 
     //Can use parts of the description or parts of the SKU to find the item
     //Implement later -> Search based on the equipment name
     public List<Product> searchForNonSpecItem(String description, String sku, String equipament){

          System.out.println(results.size());

          products = db.showItems();

          results.clear();

          for(Product a : products){

               System.out.println("Produto inventario: " + a.getDescription());
               if((description.isBlank() || a.getDescription().contains(description)) && (sku.isBlank() || a.getSku().contains(sku))){
                    System.out.println(a.getDescription());
                    System.out.println(a.getSku());
                    
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
     public ArrayList<Product> showItem(){

          products = db.showItems();

          ArrayList<Product> p = new ArrayList<>();

          for(Product product : products){
               p.add(product);
          }

          return p;
     }

}
