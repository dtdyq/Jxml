package dtdyq.xml.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * Doc类，实现文件的读取写入等主要功能
 * @author dtdyq
 *
 */

public class Doc {
	/**
	 * 用于将指定的xml文件转化为Doucment对象
	 * @param url
	 * @return Document
	 * @throws Exception
	 */
	public static Document getDocument(String url) throws Exception{
		SAXReader reader=new SAXReader();
		return reader.read(url);
	}
	/**
	 * 将一个document写入指定文件中
	 * @param document
	 * @param url
	 * @throws Exception
	 */
	public static void writeDocument(Document document,String url)throws Exception{
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer=new XMLWriter(new FileWriter(url),format);
		writer.write(document);
		writer.close();
	}
	/**
	 * 将指定文本转化位字符串
	 * @param file
	 * @return
	 */
	public static String getFile(String file){
		StringBuilder builder=new StringBuilder();
		try {
			List<String> lines=Files.readAllLines(Paths.get(file));
			for(String str:lines){
				builder.append(str+"\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}













