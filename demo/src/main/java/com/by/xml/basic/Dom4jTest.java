package com.by.xml.basic;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Dom4jTest {

    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        URL url = this.getClass().getClassLoader().getResource("book.xml");
        System.out.println(url);
        Document document = saxReader.read(url);
        System.out.println(document);

        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
        for(Element book : books) {
            Element nameElement = book.element("name");
            String nameText = nameElement.getText();
            String priceText = book.elementText("price");
            System.out.println(nameText + " --- " + priceText);
        }

    }

    @Test
    public void test_path() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        String path = Dom4jTest.class.getClassLoader().getResource("book.xml").getPath();
        System.out.println(path);
    }
}
