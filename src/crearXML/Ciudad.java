package crearXML;

public class Ciudad {

	private String attNombre;
	private int habitantes;
	private String alcalde;
	private String attPartido;
	private String gentilicio;
	private String comAutonoma;
	
	
	public Ciudad(String attNombre, int habitantes, String alcalde, String attPartido, String gentilicio,
			String comAutonoma) {
		this.attNombre = attNombre;
		this.habitantes = habitantes;
		this.alcalde = alcalde;
		this.attPartido = attPartido;
		this.gentilicio = gentilicio;
		this.comAutonoma = comAutonoma;
	}


	public String getAttNombre() {
		return attNombre;
	}


	public void setAttNombre(String attNombre) {
		this.attNombre = attNombre;
	}


	public int getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}


	public String getAlcalde() {
		return alcalde;
	}


	public void setAlcalde(String alcalde) {
		this.alcalde = alcalde;
	}


	public String getAttPartido() {
		return attPartido;
	}


	public void setAttPartido(String attPartido) {
		this.attPartido = attPartido;
	}


	public String getGentilicio() {
		return gentilicio;
	}


	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}


	public String getComAutonoma() {
		return comAutonoma;
	}


	public void setComAutonoma(String comAutonoma) {
		this.comAutonoma = comAutonoma;
	}
	
	
	
	
}
