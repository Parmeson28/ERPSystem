package sistemaerp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetImporter {

    String filePath;
    

    public SpreadsheetImporter(String filePath){

        this.filePath = filePath;

    }

    public void readFile(){
        File file = new File(filePath);
        

        try{
            FileInputStream inputStream = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(inputStream);

            int i = 0;
            for(Sheet s : workbook){
                for(Row a : s){
                    if(i >= 5000){
                        break;
                    }

                    System.out.println(a.getCell(1) + " - " + a.getCell(5));

                    i++;
                }

            }

            inputStream.close();

        }catch(IOException e){

            e.printStackTrace();

        }
    }

}
