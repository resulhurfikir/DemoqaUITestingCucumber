package UITesting.Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExcelConnection {

    public static ArrayList<ArrayList<String>> getDataExcel(String path, String sheetName, int colCnt) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < colCnt; j++) {
                row.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(row);
        }
        return table;
    }

    public static void writeDataExcel(String path, Scenario scenario, String browserName) {
        File file = new File(path);
        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("newSheet");

            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue("Assign");

            newCell = newRow.createCell(1);
            newCell.setCellValue("Scenario");

            newCell = newRow.createCell(2);
            newCell.setCellValue("Scenario Status");

            newCell = newRow.createCell(3);
            newCell.setCellValue("Browser");

            newCell = newRow.createCell(4);
            newCell.setCellValue("Date");

            Row newRow2 = sheet.createRow(1);

            Cell newCell2 = newRow2.createCell(0);
            newCell2.setCellValue("Resul Hürfikir");

            newCell2 = newRow2.createCell(1);
            newCell2.setCellValue(scenario.getName());

            newCell2 = newRow2.createCell(2);
            newCell2.setCellValue(scenario.getStatus().toString());

            newCell2 = newRow2.createCell(3);
            newCell2.setCellValue(browserName);

            newCell2 = newRow2.createCell(4);
            newCell2.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        } else {
            Sheet sheet = null;
            Workbook workbook = null;
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet("newSheet");
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
            Row newRow = sheet.createRow(sheet.getPhysicalNumberOfRows());

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue("Resul Hürfikir");

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(2);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(3);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(4);
            newCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
    }
}