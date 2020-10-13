package com.by.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 遍历工作簿的行和列
 */
public class ExcelDemo005 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("f:/temp/risk.xls");
        POIFSFileSystem fs = new POIFSFileSystem(is);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0); // 获取第一个Sheet页
        if(sheet == null) {
            return;
        }
        for(int rowNum=0; rowNum<=sheet.getLastRowNum(); rowNum++) {
            HSSFRow row = sheet.getRow(rowNum);
            if(row == null) {
                continue;
            }
            // 遍历 cell
            for(int cellNum=0; cellNum <= row.getLastCellNum(); cellNum++) {
                HSSFCell cell = row.getCell(cellNum);
                if(cell == null) {
                    continue;
                }
                System.out.print(getValue(cell) + " ");
            }
            System.out.println();
        }

        is.close();
    }

    public static String getValue(HSSFCell cell) {
        if(cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if(cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
