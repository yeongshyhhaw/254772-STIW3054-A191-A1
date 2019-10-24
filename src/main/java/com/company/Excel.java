
package com.company;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Excel {

    private static final String[] columns = {"Name", "Matric","Github-Link"};
    private static final String[] column = {"Name", "Matric"};

    public void WriteToExcel(ArrayList<Data> studsub, ArrayList<Data> studnotsub) throws IOException {

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        //Create sheet
        Sheet sheet = workbook.createSheet("List Students");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);


        //set border style for header cells
        headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
        headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);

        //set text to center
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);

        //Create row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Print data to row
        int rowNum = 1;
        for (Data Data1 : studsub) {
            Row row = sheet.createRow(rowNum++);


            Cell column2 = row.createCell(0);
            column2.setCellValue(Data1.getName());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(1);
            column3.setCellValue(Data1.getMatric());
            column3.setCellStyle(cellStyle);

            Cell column4 = row.createCell(2);
            column4.setCellValue(Data1.getLink());
            column4.setCellStyle(cellStyle);

        }
        rowNum=rowNum+2;
        Row headerRow2 = sheet.createRow(rowNum);
        // title
        for (int i = 0; i < column.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(column[i]);
            cell.setCellStyle(headerCellStyle);


        }
        rowNum=rowNum+1;

        for (Data Data2 : studnotsub) {
            Row row = sheet.createRow(rowNum++);
            Cell column2 = row.createCell(0);
            column2.setCellValue(Data2.getName());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(1);
            column3.setCellValue(Data2.getMatric());
            column3.setCellStyle(cellStyle);


        }
        rowNum=rowNum+2;
        // title
        for (int i = 0; i < column.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(column[i]);
            cell.setCellStyle(headerCellStyle);


        }



        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\yeong\\IdeaProjects\\Assignment\\Assignment1.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        System.out.println("\n\n\n"+"Excel file has successfully created..........");

    }

}
