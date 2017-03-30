package dtdyq.xml.domain;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import dtdyq.xml.Dao.Doc;

/**
 * Document 增删改查的主要功能实现
 * @author dtdyq
 *
 */
public class DocUtil {
	/**
	 * 向指定位置添加节点：
	 * @param fileName
	 * @param pName
	 * @param index
	 * @param nodeName
	 * @param nodeValue
	 * @throws Exception
	 */
	public static void addNode(String fileName,String pName,
	                int index,String nodeName,String nodeValue) throws Exception{
		Document document=Doc.getDocument(fileName);
		Element rootEle=document.getRootElement();
		Element newEle=(Element)rootEle.elements(pName).get(index);
		newEle.addElement(nodeName).setText(nodeValue);
		Doc.writeDocument(document, fileName);
	}
	/**
	 * 更新指定位置结点的文本和值：
	 * @param path
	 * @param nodeName
	 * @param nodeValue
	 */
	public static void updateNode(String fileName,
	                              String path,String nodeName,String nodeValue){
		try {
			Document document=Doc.getDocument(fileName);
			Node temp=document.selectSingleNode(path);
			temp.setName(nodeName);
			temp.setText(nodeValue);
			Doc.writeDocument(document, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除指定位置结点：
	 * @param fileName
	 * @param path
	 */
	public static void deleteNode(String fileName,String path){
		try {
			Document document=Doc.getDocument(fileName);
			Node node=document.selectSingleNode(path);
			node.getParent().remove(node);
			Doc.writeDocument(document, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置指定借点属性
	 * @param fileName
	 * @param path
	 * @param attrName
	 * @param attrValue
	 */
	public static void setAttr(String fileName,
	                           String path,String attrName,String attrValue){
		try {
			Document document=Doc.getDocument(fileName);
			Element node=(Element)document.selectNodes(path).get(0);
			node.addAttribute(attrName, attrValue);
			Doc.writeDocument(document, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		DocUtil.deleteNode("file/xml/Test.xml", "/books/book[1]");
		
	}
}
