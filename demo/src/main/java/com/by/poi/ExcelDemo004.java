package com.by.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;

/**
 * 处理不同内容格式的单元格
 */
public class ExcelDemo004 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("f:/temp/a.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个Sheet页"); //第一个sheet页

        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue("一个字符串");
        row.createCell(1).setCellValue(true);
        row.createCell(2).setCellValue(HSSFCell.LAST_COLUMN_NUMBER);

        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
