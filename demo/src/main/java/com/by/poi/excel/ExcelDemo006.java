package com.by.poi.excel;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 批量文本抽取
 */
public class ExcelDemo006 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("f:/temp/risk.xls");
        POIFSFileSystem fs = new POIFSFileSystem(is);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0); // 获取第一个Sheet页
        if(sheet == null) {
            return;
        }

        ExcelExtractor excelExtractor = new ExcelExtractor(wb);
        excelExtractor.setIncludeSheetNames(false); //不需要包含Sheet页的名字
        System.out.println(excelExtractor.getText());

        is.close();
    }
}
