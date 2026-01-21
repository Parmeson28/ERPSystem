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
            return new ArrayList<>();
            
        }catch(IOException a){
            System.out.println("ERROR");
            return new ArrayList<>();
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


   public void searchForItem(String description, String id){

        try {
            reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null){

                line = line.replace(";", " ");
                String[] lineArray = line.split(" ");

                if(lineArray[0].equals(id) || lineArray[1].equals(description)){
                    System.out.println("DEu boa");
                }else{
                    System.out.println("Nem pa");
                }
                
            }  

        }catch(FileNotFoundException e) {
            System.out.println("Games");
            
        }catch(IOException a){
            System.out.println("Nao games");
        }

   }

}
