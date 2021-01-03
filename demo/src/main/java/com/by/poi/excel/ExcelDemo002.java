package com.by.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * 创建行、单元格、写入内容等
 */
public class ExcelDemo002 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("f:/temp/a.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个Sheet页"); // 第一个sheet页
        wb.createSheet("第二个sheet页"); // 第二个sheet页

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("啦啦啦");
        row.createCell(1).setCellValue("哈哈哈");
        row.createCell(2).setCellValue("啊啊啊");

        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
