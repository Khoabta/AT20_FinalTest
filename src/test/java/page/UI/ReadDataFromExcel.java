package page.UI;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public static XSSFWorkbook excelWBook;
    public static XSSFSheet excelWSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static void setExcelFile(String path, String sheetName) throws IOException {
        try {
            File file = new File(path);
            FileInputStream excelFile = new FileInputStream(file);
            // Access the test data sheet
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e){
            throw (e);
        }
    }

    public static String getCellData(int rowNum, int colNum){
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e){
            System.out.println(e);
            return "";
        }
    }

    public static int getRowByTestCaseID(String testCase){
        int rowTotal = excelWSheet.getLastRowNum() - excelWSheet.getFirstRowNum();
        for(int i = 1; i < rowTotal + 1; i++){
            cell = excelWSheet.getRow(i).getCell(0);
            DataFormatter formatter = new DataFormatter();
            String rowText = formatter.formatCellValue(cell);
            if(rowText.equals(testCase)){
                return i;
            }
        }
        return -1;
    }

    public static int getCol(String columnName){
        row = excelWSheet.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++){
            String name = String.valueOf(row.getCell(i));
            if (name.equals(columnName)){
                return i;
            }
        }
        return -1;
    }
}
