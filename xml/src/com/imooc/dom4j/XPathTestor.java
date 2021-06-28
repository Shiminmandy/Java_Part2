package com.imooc.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XPathTestor {
    public void xpath(String xpathExp) {
        String file = "c:/Users/Shimin Mandy Cheng/Documents/Java_Part2/xml/src/hr.xml";
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            List<Node> nodes = document.selectNodes(xpathExp);
            for(Node node : nodes){
                Element emp = (Element)node;
                System.out.println(emp.attributeValue("no"));
                System.out.println(emp.elementText("name"));
                System.out.println(emp.elementText("age"));
                System.out.println(emp.elementText("salary"));
                System.out.println("=====================================");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XPathTestor testor = new XPathTestor();
        /*
            testor.xpath("/hr/employee") 与  testor.xpath("//employee") 获取到的信息相同
        */
        //testor.xpath("/hr/employee");
        //testor.xpath("//employee");
        //调取工资少于4000员工信息
        //testor.xpath("//employee[salary<4000]");
        //通过姓名调取员工信息
        testor.xpath("//employee[name='李四']");
        //按照工号调取信息
        testor.xpath("//employee[@no=3304]");
        //找到编号最小的人
        testor.xpath("//employee[1]");
        //找到最后一个编号（新入职）员工信息
        testor.xpath("//employee[last()]");
        System.out.println("****************************************");
        //调取前五个员工信息
        testor.xpath("//employee[position()<6]");
        System.out.println("****************************************");
        //同时调取第3名和第8名员工
        testor.xpath("//employee[3] | //employee[8]");
    }
}
