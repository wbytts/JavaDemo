package com.by.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * 单元格对齐方式
 */
public class ExcelDemo007 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("f:/temp/a.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个Sheet页"); //第一个sheet页

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("OK");

        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
