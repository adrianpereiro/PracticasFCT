package modelo;

public class Tarea {
	private String Titulo;
	private String Descripcion;
	
	public Tarea(String titulo, String descripcion) {
		Titulo = titulo;
		Descripcion = descripcion;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return  Titulo + " Descripcion: " + Descripcion;
	}
	
	
}
