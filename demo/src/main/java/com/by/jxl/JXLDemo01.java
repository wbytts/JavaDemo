package com.by.jxl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JXLDemo01 {

    @Test
    public void test01() {
        try {
            File file = new File("f:/temp/test-jxl-01.xlsx");
            // 创建xls文件
            file.createNewFile();
            // 2:创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);

            // 3:创建sheet,设置第二三四..个sheet，依次类推即可
            WritableSheet sheet = workbook.createSheet("测试", 0);
            // 4：设置titles
            String[] titles = { "编号", "账号"};
            // 5:给第一行设置列名
            for (int i = 0; i < titles.length; i++) {
                sheet.addCell(new Label(i, 0, titles[i]));
            }
            sheet.setHeader("aa", "cc", "cc");
            // 6：模拟数据库导入数据 注意起始行为1
            for (int i = 1; i < 100; i++) {
                //添加编号
                sheet.addCell(new Label(0, i, new String("编号"+i)));
                //添加密码
                sheet.addCell(new Label(1, i, new String("编号"+i)));
            }
            workbook.write();
            workbook.close();
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            File file = new File("f:/temp/test-jxl-01.xlsx");
            //1:创建workbook
            Workbook workbook = Workbook.getWorkbook(file);
            //2:获取第一个工作表sheet
            Sheet sheet = workbook.getSheet(0);
            //3:读取数据，行数、列数
            System.out.println(sheet.getColumns());
            System.out.println(sheet.getRows());
            //4.自己注意行列关系
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    System.out.print(cell.getContents());
                }
                System.out.println();
            }
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
    }

}
