package com.imooc.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

public class PlanWrite {
    String file="c:/Users/Shimin Mandy Cheng/Documents/Java_Part2/xml/src/plan.xml";
    public void writeXml(){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            Element course = root.addElement("course");
            course.addAttribute("id", "004");
            Element name = course.addElement("name");
            name.setText("大学物理");
            course.addElement("hour").setText("60");
            course.addElement("exam-form").setText("考试");
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            document.write(writer);
            writer.close();
        }catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readXml(){
        SAXReader reader=new SAXReader();
        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            List<Element> courses = root.elements("course");
            for (Element course : courses){
                Attribute att = course.attribute("id");
                System.out.println(att.getText());
                Element name = course.element("name");
                System.out.println(name.getText());
                System.out.println(course.elementText("hour"));
                System.out.println(course.elementText("exam-form"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        PlanWrite planWrite =new PlanWrite();
        planWrite.writeXml();
        planWrite.readXml();
    }
}
