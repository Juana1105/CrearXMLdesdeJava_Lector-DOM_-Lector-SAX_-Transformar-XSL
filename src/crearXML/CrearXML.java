package crearXML;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXML {
	
	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		
		
		Ciudad c1 = new Ciudad ("Valladolid", 298000, "Oscar Puente","PSOE","vallisoletano","Castilla y León");
		Ciudad c2 = new Ciudad ("Santander", 172044, "Gema Igual Ortiz","PP","santanderino","Cantabria");
		Ciudad c3 = new Ciudad ("Gijón", 271843, "Ana González","PSOE","gijonés","Asturias");
		Ciudad c4 = new Ciudad ("Valencia", 792492, "Joan Ribó","Compromis","valenciano","Comunidad Valenciana");
		Ciudad c5 = new Ciudad ("Segovia", 50802, "Clara Martín","PSOE","segoviano","Castilla y León");

		Ciudad[] ciudadesEjemplo= {c1,c2,c3,c4,c5};
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		
		//Creamos el root
		Element ciudades = document.createElement("ciudades");
		
		
		for (Ciudad c: ciudadesEjemplo) {
			
			Element ciudad = document.createElement("ciudad");
			ciudad.setAttribute("nombre",c.getAttNombre());
			Element habitantes = document.createElement("habitantes");
			Element alcalde = document.createElement("alcalde");
			alcalde.setAttribute("partido", c.getAttPartido());
			Element gentilicio = document.createElement("gentilicio");
			Element comunidadAutonoma = document.createElement("comunidadAutonoma");
			
			
			Text textoHab=document.createTextNode(c.getHabitantes()+"");
			Text textoAlcalde=document.createTextNode(c.getAlcalde());
			Text textoGentilicio=document.createTextNode(c.getGentilicio());
			Text textoComAut=document.createTextNode(c.getComAutonoma());
			
			habitantes.appendChild(textoHab);
			alcalde.appendChild(textoAlcalde);
			gentilicio.appendChild(textoGentilicio);
			comunidadAutonoma.appendChild(textoComAut);
			
			
			ciudad.appendChild(habitantes);
			ciudad.appendChild(alcalde);
			ciudad.appendChild(gentilicio);
			ciudad.appendChild(comunidadAutonoma);
			
			ciudades.appendChild(ciudad);
		}
		
		document.appendChild(ciudades);
		saveXMLtoFile(document,"ciudades.xml");
		
	}
	
	
	/*TOCHO PARA GUARDARLO COMO XML*/
	public static void saveXMLtoFile(Document document,String fileName) throws IOException,TransformerException {
		
		DOMSource domSource=new DOMSource(document);
		FileWriter writer=new FileWriter("C:\\Users\\Alumno\\Desktop\\DAM22-23\\Lenguajes de marca\\simulacroExamen\\"+fileName);
		StreamResult result=new StreamResult(writer);
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
		transformer.transform(domSource, result);		
		writer.close();	
	}
	

}
