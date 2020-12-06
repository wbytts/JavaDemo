package com.by.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 *
 */
public class ExcelDemo {
    public static void main(String[] args) throws Exception {

        // 创建一个工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建一个工作表
        Sheet sheet = wb.createSheet("第一个Sheet页"); //第一个sheet页

        // 在工作表里创建一行
        Row row = sheet.createRow(0);
        // 在行里创建一个单元格
        Cell cell = row.createCell(0);

        FileOutputStream fos = new FileOutputStream("f:/temp/a.xls");
        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
