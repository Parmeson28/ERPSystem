package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class InventoryManagement {

    
    private ArrayList<String> products = new ArrayList<>();

    private String filePath = "\\ERPSystem\\app\\src\\main\\java\\sistemaerp\\inventory\\inventory.txt";
    BufferedReader reader;
    BufferedWriter writer;
    String line;

    public boolean verifyFile(){
        
        try{
            reader = new BufferedReader(new FileReader(filePath));
            System.out.println("All worked fine");
            return true;
    
        }catch(FileNotFoundException e){
            System.out.println("Couldn't find file");
            return false;
    
        }

    }

   public ArrayList<String> showItems(){
    
        try {
            reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null){

                line = line.replace(";", " ");
                
                products.add(line);

            }  

            return products;

        }catch(FileNotFoundException e) {
            System.out.println("ERRO");
            return null;
            
        }catch(IOException a){
            System.out.println("ERROR");
            return null;
        }

   }


   public void registerItems(String description, String id, int quantity){
        try {
            writer = new BufferedWriter(new FileWriter(filePath, true));
            

            if(!description.strip().equals("") && !id.strip().equals("")){

                line = id+";"+description+";"+quantity;

                writer.write(line);
                writer.newLine();
            }
           

            writer.flush();
            writer.close();

        }catch(FileNotFoundException e) {
            System.out.println("ERRO");
            
        }catch(IOException a){
            System.out.println("ERROR");
        }
   }

}
