package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import sistemaerp.database.DatabaseHandler;


public class InventoryManagement {

    
    private ArrayList<String> products = new ArrayList<>();

    BufferedReader reader;
    BufferedWriter writer;
    String line;

    DatabaseHandler db = new DatabaseHandler();

    public boolean verifyFile(){

        db.dbConnection();

        System.out.println("All worked fine");
        return true;

    }


     public void registerItems(String description, String id, int quantity, String machinery){
     

          if(!description.strip().equals("") || !id.strip().equals("") || !machinery.strip().equals("")){

               db.registerProducts(description, id, quantity, machinery);
               System.out.println("Item foi enviado para cadastro");

          }else{
               System.out.println("Campos incompletos");
          }

     }


     public void searchForItem(String description, String sku){

          products = db.showItems();

          boolean foundItem = false;

          ArrayList<String> c = new ArrayList<>();

          for(String a : products){

               String[] b = a.split(" ");
               

               if(b[0].equals(description) && b[1].equals(sku)){
                    System.out.println(a);
                    foundItem = true;
               }

               c.add(a);
          }

          if(foundItem == false){
               for(String a : c){
                    String[] b = a.split(" ");

                    if(b[0].equals(description) || b[1].equals(sku)){
                         System.out.println(a);
                    }
               }
          }

     }

     public ArrayList<String> showItem(){

          products = db.showItems();

          return products;
     }

}
