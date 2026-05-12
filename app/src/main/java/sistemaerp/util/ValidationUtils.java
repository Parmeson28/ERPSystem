package sistemaerp.util;

//This class handles some program logics for input validation
// ex: check if a string is numeric 
//If I am not mistaken, this class is only being used in one place
//Every validation should have its logic here
public class ValidationUtils {
    
    public boolean validateNum(String text){

        if(text == null){
            return false;
        }

        try{
            double d = Double.parseDouble(text);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

}
