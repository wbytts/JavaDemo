package com.by.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * 创建一个时间格式的单元格
 */
public class ExcelDemo003 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("f:/temp/a.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个Sheet页"); //第一个sheet页

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(new Date());

        CreationHelper creationHelper = wb.getCreationHelper();
        CellStyle cs = wb.createCellStyle(); //单元格样式
        cs.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd HH:mm:ss"));

        Cell cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cs);

        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cs);

        cell = row.createCell(3);
        cell.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
