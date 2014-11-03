package hello;
import java.util.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Converter {

	String plain;
	String xml;
	
	Converter()
	{}
	//*update(Observable, Object){}
		
	

	
	public boolean uservalidation(String user, String project){
	return true;	
	}
	
	public boolean rulevalidation(String rules){
	 return true;
	}
	
	
	public void xmltoplain(String xml){
		//umwandlung XML in String
		//Auslese der Regeln in Plainform
		//Rulevalidation mit Iterator
		if (rulevalidation("test")){
		System.out.println(xml);
		
		}
	
	}
	
	public void plaintoxml(String user, String project){
		if (uservalidation(user, project)) {
			
			  try {
				  
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			 
					// root elements
					Document doc = docBuilder.newDocument();
					Element rootElement = doc.createElement("company");
					doc.appendChild(rootElement);
			 
					// staff elements
					Element staff = doc.createElement("Staff");
					rootElement.appendChild(staff);
			 
					// set attribute to staff element
					Attr attr = doc.createAttribute("id");
					attr.setValue("1");
					staff.setAttributeNode(attr);
			 
					// shorten way
					// staff.setAttribute("id", "1");
			 
					// firstname elements
					Element firstname = doc.createElement("firstname");
					firstname.appendChild(doc.createTextNode("yong"));
					staff.appendChild(firstname);
			 
					// lastname elements
					Element lastname = doc.createElement("lastname");
					lastname.appendChild(doc.createTextNode("mook kim"));
					staff.appendChild(lastname);
			 
					// nickname elements
					Element nickname = doc.createElement("nickname");
					nickname.appendChild(doc.createTextNode("mkyong"));
					staff.appendChild(nickname);
			 
					// salary elements
					Element salary = doc.createElement("salary");
					salary.appendChild(doc.createTextNode("100000"));
					staff.appendChild(salary);
			 
					// write the content into xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File("file.xml"));
			 System.out.println("File saved!");
					
				result = new StreamResult(System.out);
					
			 
					transformer.transform(source, result);
			 
					
					
					
			 
				  } catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				  } catch (TransformerException tfe) {
					tfe.printStackTrace();
				  }
				}
			
			
	
		}
		
		
		
	}

	


