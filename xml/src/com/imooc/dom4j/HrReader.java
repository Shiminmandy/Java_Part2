package com.imooc.dom4j;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;

import java.util.List;
/*
 *如何在idea中对dom4j 进行 build path 操作：
 *  File-->Project Structure-->Module-->选择具体项目-->dependencies-->
 * 点击“+”符号-->选择 dom4j-2.1.1.jar-->OK
 */
public class HrReader {
    public void readXml(){
        String file="c:/Users/Shimin Mandy Cheng/Documents/Java_Part2/xml/src/hr.xml";
        SAXReader reader=new SAXReader();
        try {
            Document document=reader.read(file);
            //获取XML文档的根节点，即hr标签
            Element root=document.getRootElement();
            //elements方法用于获取指定的标签集合
            List<Element> employees=root.elements("employee");
            for(Element employee : employees){
                //element方法用于获取唯一的子节点对象
                Element name=employee.element("name");
                String empName=name.getText();//getText()方法用于获取标签文本
                System.out.println(empName);
                System.out.println(employee.elementText("age"));
                System.out.println(employee.elementText("salary"));
                Element department = employee.element("department");
                System.out.println(department.element("dname").getText());
                System.out.println(department.element("address").getText());
                Attribute att = employee.attribute("no");
                System.out.println(att.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HrReader reader=new HrReader();
        reader.readXml();
    }
}
