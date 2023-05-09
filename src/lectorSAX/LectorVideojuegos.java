package lectorSAX;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;


public class LectorVideojuegos extends DefaultHandler{
	
	private String textoLeido="";
	private String nombre="",plataforma="";
	private int anyoLanzamiento=0, puntuacion=0;

	//Sobreescribimos 5 metodos: startElement, endElement, startDocument,endDocument y Characters
	@Override
	public void startDocument() {
		System.out.println("\n\tInicio de lectura de documento\n");
	}
	
	@Override
	public void endDocument() {
	
	}
	
	
	@Override
	public void startElement(String uri, String namespace, String name, Attributes atts) {
		
	}
	
	@Override
	public void endElement(String uri, String namespace, String name) {
		
		if ( name.equals("nombre")) {
			nombre=textoLeido;
		}else if(name.equals("plataforma")) {
			plataforma=textoLeido.trim(); //quita los espacio POR AMBOS LADOS
		}else if(name.equals("notaMetacritic")) {
			puntuacion=Integer.parseInt(textoLeido);
		}else if(name.equals("fechaSalida")) {
			String[] partesFecha=textoLeido.split(" ");
			anyoLanzamiento=Integer.parseInt(partesFecha[2]);
			//YA TENGO LOS DATOS, ahora CIERRO JUEGO e imprimo los juegos q SEAN DE XBOX
		}else if( name.equals("juego") && plataforma.equals("Xbox 360")) {
			System.out.println("Título:"+nombre+"\nPuntuación: "+puntuacion+"\nAño lanzamiento:"+anyoLanzamiento);
			System.out.println("---------------------------");
		}
	}
	
	
	@Override
	public void characters(char[]caracteres, int inicio, int longitud) {
		textoLeido=new String(caracteres,inicio,longitud);
	}
	
	
}
