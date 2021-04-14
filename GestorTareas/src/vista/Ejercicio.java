package vista;
import java.util.Scanner;
import datos.gestionTareas;


public class Ejercicio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Gestor de tareas: "
				+ "\n1-Cargar tareas de un fichero de texto "
				+ "\n2-Guardar tareas en un fichero de texto"
				+ "\n3-Crear tareas" 
				+ "\n4-Listar Tareas \n5-Borrar tareas");
		
		int opcion = sc.nextInt();

		if (opcion == 2) {
			gestionTareas.guardarTareas();
		}
		if (opcion == 3) {
			gestionTareas.crearTareas();
		}
		if (opcion == 4) {
			gestionTareas.listarTareas();
		}
		if (opcion == 5) {
			gestionTareas.borrarTareas();
		}
		sc.close();
	}
}
