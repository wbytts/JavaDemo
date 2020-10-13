package com.by.pdf;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class GeneratePDFUtil {

    // 利用模板生成pdf
    public static void interviewReportPDF(Map<String, String> map) {

        // 模板路径
        String templatePath = "f:/temp/test_pdf/template.pdf";
        // 生成的新文件路径
        String newPDFPath = "f:/temp/test_pdf/res.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            // 给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
//            BaseFont bf = BaseFont.createFont(UtilPath.getRootPath() + "fonts/simsun.ttc,0", BaseFont.IDENTITY_H,
//                    BaseFont.EMBEDDED);
//            form.addSubstitutionFont(bf);

            //遍历map装入数据
            for (Entry<String, String> entry : map.entrySet()) {
                form.setField(entry.getKey(), entry.getValue());
                //System.out.println("插入PDF数据---->  key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {

        } catch (DocumentException e) {

        }

    }

	//测试
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		map.put("jobtitle", "Java工程师面试报告");
		map.put("name", "李四");
		map.put("gender", "男");
		map.put("age", "22");
		map.put("jobyear", "10");
		map.put("education", "院士");
		map.put("location", "天堂");

		System.out.println(map);
		interviewReportPDF(map);

	}
}