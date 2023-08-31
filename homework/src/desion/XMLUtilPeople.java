package desion;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtilPeople
{
	//该方法用于从XML配置文件中提取并返回
	public static String getPeopleName()
	{
		try
		{
			//创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src/desion/configPeople.xml"));

			//获取包含品牌名称的文本节点
			NodeList nl = doc.getElementsByTagName("peopleName");
			Node classNode=nl.item(0).getFirstChild();
			String brandName=classNode.getNodeValue().trim();
			return brandName;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
