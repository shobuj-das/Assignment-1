
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;



public class ExcelFileHandle {

    @Test
    public void readExcelFile(){
        List<String> suggested = new ArrayList<>();

        try{
            File file = new File("excelFile.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("Monday");
            if (sheet == null) {
                System.out.println("Sheet 'Monday' not found!");
                return ;
            }

            int colIndex = 2;
            for(int rowIndex=1; rowIndex<=7; rowIndex++){
                Row row = sheet.getRow(rowIndex);
                if(row != null){
                    Cell cell = row.getCell(colIndex);
                    if(cell != null){
                        suggested.add(cell.getStringCellValue());
                        System.out.println(cell.getStringCellValue());
                    }
                    else{
                        System.out.println("Cell not found");
                    }
                }
                else {
                    System.out.println("row not found");
                }
//                System.out.println(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue());
//                suggested.add(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

       // return suggested;
    }
}