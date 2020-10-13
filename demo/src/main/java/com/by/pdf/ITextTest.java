package com.by.pdf;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ITextTest {
    public static void main(String args[]) {
        // writePdf();
        removeWatermark("F:/eBook/test/lmx2572_wrapper.pdf", "F:/eBook/test/res.pdf");
    }

    public static void writePdf() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("F:/eBook/test/Helloworld.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        document.open();
        try {
            document.add(new Paragraph("Hello World"));
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        document.close();
    }

    /**
     * 移除水印
     *
     * @param srcPath   带水印pdf
     * @param buildPath 去除水印pdf
     * @return
     */
    public static String removeWatermark(String srcPath, String buildPath) {
        //注意，这将破坏所有层的文档中，只有当你没有额外的层使用
        try {
            PdfReader reader = new PdfReader(srcPath);
            //从文档中彻底删除的OCG组。
            //占位符变量
            reader.removeUnusedObjects();
            int pageCount = reader.getNumberOfPages();
            PRStream prStream = null;
            PdfDictionary curPage;
            PdfArray contentarray;
            //循环遍历每个页面
            for (int i = 1; i <= pageCount; i++) {
                //获取页面
                curPage = reader.getPageN(i);
                System.out.print(i+": ");
                System.out.println(curPage.getAsStream(PdfName.CONTENTS).getRawLength());
                //获取原始内容
                contentarray = curPage.getAsArray(PdfName.CONTENTS);
                // [/Contents, /Type, /Resources, /Parent, /Annots, /MediaBox]
                if (contentarray != null) {
                    //循环遍历内容
                    for (int j = 0; j < contentarray.size(); j++) {
                        //获取原始字节流
                        prStream = (PRStream) contentarray.getAsStream(j);
                        // 0代表水印层
                        if (j == 0) {
                            //给它零长度和零数据删除它
                            prStream.put(PdfName.LENGTH, new PdfNumber(0));
                            prStream.setData(new byte[0]);
                        }
                    }
                }
            }
            //写出来的内容
            FileOutputStream fos = new FileOutputStream(buildPath);
            Document doc = new Document(prStream.getReader().getPageSize(1));
            PdfCopy copy = new PdfCopy(doc, fos);
            doc.open();
            for (int j = 1; j <= pageCount; j++) {
                doc.newPage();
                PdfImportedPage page = copy.getImportedPage(prStream.getReader(), j);
                copy.addPage(page);
            }
            doc.close();
            return "success";
        } catch (BadPdfFormatException e) {
            e.printStackTrace();
            return "0";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "1";
        } catch (IOException e) {
            e.printStackTrace();
            return "2";
        } catch (DocumentException e) {
            e.printStackTrace();
            return "3";
        }
    }

}
