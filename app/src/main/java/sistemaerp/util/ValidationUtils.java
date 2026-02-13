package sistemaerp.util;

//This class handles some program logics for input validation
// ex: check if a string is numeric 
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
