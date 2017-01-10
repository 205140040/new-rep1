package com.yfairy.demo.javacore;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 第2章：XML91/858<br>
		 * 推荐看w3cXML教程:http://www.w3school.com.cn/xml/<br>
		 * schema教程w3c:http://www.w3school.com.cn/schema/index.asp<br>
		 */

		/**
		 * 什么是 XML? XML 指可扩展标记语言（EXtensible Markup Language） XML 是一种标记语言，很类似
		 * HTML <br>
		 * XML 的设计宗旨是传输数据，而非显示数据 XML 标签没有被预定义。您需要自行定义标签。 XML 被设计为具有自我描述性。<br>
		 * XML 是 W3C 的推荐标准<br>
		 * XML 被设计用来结构化、存储以及传输信息。<br>
		 * XML 文档形成一种树结构<br>
		 * XML 文档必须包含根元素。该元素是所有其他元素的父元素。<br>
		 * 删除根元素报错:The markup in the document following the root element must be
		 * well-formed.<br>
		 * XML 的属性值须加引号<br>
		 * 在 XML 中，空格会被保留<br>
		 * XML 属性 从 HTML，你会回忆起这个：<img src="computer.gif">。"src" 属性提供有关 <img>
		 * 元素的额外信息。 在 HTML 中（以及在 XML 中），属性提供有关元素的额外信息：<br>
		 * XML 命名空间（XML Namespaces）<br>
		 * XML 命名空间提供避免元素命名冲突的方法。<br>
		 */

		// java读取xml并解析
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		String desktop = "C:\\Users\\jiangzi\\Desktop";
		File xml1 = new File(desktop, "xml1.xml");
		Document document = documentBuilder.parse(xml1);
		Element root = document.getDocumentElement();
		System.out.println(root);
		System.out.println(document);

		// xml命名空间
		// XML Namespace (xmlns) 属性
		// XML 命名空间属性被放置于元素的开始标签之中，并使用以下的语法：
		// xmlns:namespace-prefix="namespaceURI"
		// xmlns:aop="http://www.springframework.org/schema/aop"
		// 默认的命名空间：xmlns="namespaceURI" 如：<table
		// xmlns="http://www.w3.org/TR/html4/">

		// CDATA
		// 术语 CDATA 指的是不应由 XML 解析器进行解析的文本数据（Unparsed Character Data）。

		// 什么是 XML Schema？
		// XML Schema 的作用是定义 XML 文档的合法构建模块，类似 DTD。
		// XML Schema:
		// 定义可出现在文档中的元素
		// 定义可出现在文档中的属性
		// 定义哪个元素是子元素
		// 定义子元素的次序
		// 定义子元素的数目
		// 定义元素是否为空，或者是否可包含文本
		// 定义元素和属性的数据类型
		// 定义元素和属性的默认值以及固定值

		// targetNamespace="http://www.w3school.com.cn"
		// 显示被此 schema 定义的元素 (note, to, from, heading, body) 来自命名空间：
		// "http://www.w3school.com.cn"。

		// 导入本地schema : xsi:schemaLocation="http://www.w3school.com.cn
		// schema1.xsd"
		
		//XSD 简易元素
		//<element name="name" type="date"></element>
		
		//看到 XSD 复合元素
		//http://www.w3school.com.cn/schema/schema_complex.asp
	}

}
