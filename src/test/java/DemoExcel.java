import org.apache.poi.ss.usermodel.Row;
//import com.sun.rowset.internal.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoExcel {
    public static void main(String[] args){
        try{
            File file = new File("excelFile.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("Monday");

            for(Row row:sheet){
                for(Cell cell:row){
                    System.out.println(cell.getStringCellValue());
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;

//public class DemoExcel {
//    public static void main(String[] args) {
//        try {
//            File file = new File("excelFile.xlsx");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            Workbook workbook = new XSSFWorkbook(fileInputStream);  // Correct way to initialize workbook
//            Sheet sheet = workbook.getSheet("Monday");  // Get the sheet by name
//
//            // Iterate through the rows and cells using Apache POI Row and Cell objects
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    // Print the value of each cell in the row
//                    System.out.println(cell.toString());  // You can use cell.getStringCellValue() for text values
//                }
//            }
//            workbook.close();  // Always close the workbook after use
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
