package XSL;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformadorXSL{
	
		public static void main(String [] args) {
			
			String srcXmlPath = "C:\\Users\\Alumno\\Desktop\\DAM22-23\\Lenguajes de marca\\simulacroExamen\\videojuegos.xml";
			String targetHTMLPath = "C:\\Users\\Alumno\\Desktop\\DAM22-23\\Lenguajes de marca\\simulacroExamen\\videojuegos.html";
			String xsltPath = "C:\\Users\\Alumno\\Desktop\\DAM22-23\\Lenguajes de marca\\simulacroExamen\\transformaVideojuegos.xsl";
			transformXmlByXslt(srcXmlPath, targetHTMLPath, xsltPath);
		
				try {    
					FileInputStream fis = new FileInputStream(targetHTMLPath);
					InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
					BufferedReader br = new BufferedReader(isr);
					String message="";
					while((message=br.readLine())!=null) {
						System.out.println(message);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println ("No se encontró el archivo");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					System.out.println ("Error de codificación de formato");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

/**
 * Utilice xslt para convertir archivos XML
 * @param srcXmlPath ruta del archivo XML de origen
 * @param targetXmlPath ruta del archivo XML de destino
 * @param xsltPath Ruta del archivo XSLT
		*/
		public static void transformXmlByXslt(String srcXmlPath,String targetXmlPath,String xsltPath) {
		
		// Obtener la fábrica de convertidores
		TransformerFactory tff = TransformerFactory.newInstance();
		
		try {
		// Obtener las instancias del objeto convertidor s
		Transformer tf = tff.newTransformer(new StreamSource(xsltPath));
		//Convertir
		tf.transform(new StreamSource(srcXmlPath), new StreamResult(
		new FileOutputStream(targetXmlPath)));
		
		System.out.println ("Conversión exitosa");
		} catch (TransformerConfigurationException e) {
		e.printStackTrace();
		System.out.println ("No se pudo obtener la instancia del objeto de conversión");
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println ("No se encontró archivo fuente");
		} catch (TransformerException e) {
		e.printStackTrace();
		System.out.println ("No se pudo convertir al archivo de destino");
		}
		

		}

}