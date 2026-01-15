package sistemaerp.inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InventoryManagement {

    private String filePath = "D:\\SistemaERP\\app\\src\\main\\java\\sistemaerp\\inventory\\inventory.txt";
    BufferedReader reader;

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

   public void showItems(){
    
        try {
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = reader.readLine()) != null){

                line = line.replace(";", " ");
                
                System.out.println(line);

            }  

        }catch(FileNotFoundException e) {
            System.out.println("ERRO");
            
        }catch(IOException a){
            System.out.println("ERROR");
        }

   }


   public void registerItems(){
        try {
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = reader.readLine()) != null){

                line = line.replace(";", " ");
                
                System.out.println(line);

            }  

        }catch(FileNotFoundException e) {
            System.out.println("ERRO");
            
        }catch(IOException a){
            System.out.println("ERROR");
        }
   }

}
