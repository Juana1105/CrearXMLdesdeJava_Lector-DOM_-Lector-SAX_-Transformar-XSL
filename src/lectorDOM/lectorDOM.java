package lectorDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class lectorDOM {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		
		String nombre="",plataforma="",fechaSalida="";
		String[] partesFecha=null;
		int anyo=0,notaMetacritic=0;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		File archivo = new File("C:\\Users\\Alumno\\Desktop\\DAM22-23\\Lenguajes de marca\\simulacroExamen\\videojuegos.xml");
		//parse
		Document documento = builder.parse(archivo);
		
		//Extraemos el elemento root
		Element juegos = documento.getDocumentElement();
		//De este element vamos a obtener todos sus NODOS hijo-nodos juego-__devuelve una lista de nodos
		NodeList juegoList = juegos.getChildNodes();
		//Vamos a recorrer los nodos juego
		for ( int i = 0; i<juegoList.getLength() ; i++) {
			//Extraemos el nodo que vamos a tratar
			Node juego = juegoList.item(i);
			//si el nodo leido no es un NODO 'juego' NOS LOS SALTAMOS
			if(juego.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			//Sacamos los elementos del elemento JUEGO
			NodeList elementosJuego = juego.getChildNodes();
			for ( int j = 0; j<elementosJuego.getLength(); j++) {
				//Tenemos los hijos de JUEGO(nombre,plataforma,fechaSalida,descripcion,notaMetacritic,notasUsuarios)
				Node hijoJuego = elementosJuego.item(j);
				
				if ( hijoJuego.getNodeName().equals("nombre")) {
					nombre=hijoJuego.getTextContent();
				}else if( hijoJuego.getNodeName().equals("plataforma")) {
					plataforma=hijoJuego.getTextContent().trim();//LIMPIAR ESPACIOS
				}else if( hijoJuego.getNodeName().equals("fechaSalida")) {
					fechaSalida=hijoJuego.getTextContent();
					partesFecha=fechaSalida.split(" ");
					anyo=Integer.parseInt(partesFecha[2]);
				}else if( hijoJuego.getNodeName().equals("notaMetacritic")) {
					notaMetacritic=Integer.parseInt(hijoJuego.getTextContent());
				}
				
			}
			if(notaMetacritic >= 90) {
				System.out.println("Título: " +nombre+"\tPlataforma: "+plataforma+"\tAño Lanzamiento: "+anyo+"\n--------------------------");
			}
			
		}
		
		
		
		
		
	}

	
}
