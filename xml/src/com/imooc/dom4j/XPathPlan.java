package com.imooc.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XPathPlan {
    public void xpath(String xpathExp) {
        String file = "c:/Users/Shimin Mandy Cheng/Documents/Java_Part2/xml/src/plan.xml";
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            List<Node> nodes = document.selectNodes(xpathExp);
            for (Node node : nodes) {
                Element emp = (Element) node;
                System.out.println(emp.attributeValue("id"));
                System.out.println(emp.elementText("name"));
                System.out.println(emp.elementText("hour"));
                System.out.println(emp.elementText("exam-form"));
                System.out.println("===============================");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        XPathPlan plan = new XPathPlan();
        System.out.println("获取所有课程信息：");
        plan.xpath("/plan/course");
        System.out.println("查询课时小于50的课程信息：");
        plan.xpath("//course[hour<50]");
        System.out.println("查询课程名为高等数学的课程信息：");
        plan.xpath("//course[name='高等数学']");
        System.out.println("查询属性id为001的课程信息：");
        plan.xpath("//course[@id=001]");
        System.out.println("查询前两条课程信息：");
        plan.xpath("//course[position()<3]");
    }
}
