package com.by.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * 创建工作簿， 工作表，保存为xls文件
 * @author bingyi
 */
public class ExcelDemo001 {
    public static void main(String[] args) throws Exception {
        Workbook wb = new HSSFWorkbook();
        FileOutputStream fos = new FileOutputStream("f:/temp/a.xlsx");

        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
