package utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get total row count
    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    // Get total cell count (columns)
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellcount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

    // Read cell data
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;
        try {
            data = String.valueOf(cell.getStringCellValue());
        } catch (Exception e) {
            data = String.valueOf(cell.getNumericCellValue());
        }
        workbook.close();
        fi.close();
        return data;
    }

    // Write cell data
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill green color (Pass)
    public void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        cell.setCellStyle(style);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill red color (Fail)
    public void fillRedColor(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        cell.setCellStyle(style);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();


    }


}
