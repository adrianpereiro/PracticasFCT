package modelo;

public class Tarea {
	private String Titulo;

	public Tarea(String titulo) {
		Titulo = titulo;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	@Override
	public String toString() {
		return "Tarea :" + Titulo;
	}
	
	
}
