package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Tarea;
import vista.Menu;

public class gestionTareas {

	public static void crearTareas() {
		BufferedWriter wr = null;
		Tarea tarea = new Tarea(null, null);
		FileWriter fw = null;
		String texto = "";
		ArrayList<Tarea> tareas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		File f = gestionFicheros.crearFichero();
		System.out.println("Tareas a a�adir\nTitulo: ");
		tarea.setTitulo(sc.nextLine());
		System.out.println("Descipcion: ");
		tarea.setDescripcion(sc.nextLine());
		

		while (true) {
			try {
				fw = new FileWriter(f, true);
				wr = new BufferedWriter(fw);
				
				wr.write("-" + tarea + "\n");
				
				wr.close();
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Siguiente tarea, si no hay mas que a�adir introducir salir:\n"
					+ "Titulo: ");
			texto = sc.nextLine();
			if (texto.equals("salir")) {
				break;
			}
			tarea.setTitulo(texto);
			System.out.println("Descripcion: ");
			tarea.setDescripcion(sc.nextLine());
		}
		Menu.mostrarMenu();
	}

	public static ArrayList<Tarea> cargarTareas(File f) {
		FileInputStream input = null;
		
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		String tareaLeida = "";
		try {
			input = new FileInputStream(f);
			InputStreamReader lectura = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(lectura);

			tareaLeida = br.readLine();

			System.out.println("Tareas de: " + f.getName());
			int a = 1;
			while (tareaLeida != null) {
				Tarea tarea = new Tarea(tareaLeida, null);
				listaTareas.add(tarea);
				System.out.println(a + tarea.getTitulo());
				tareaLeida = br.readLine();
				a++;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTareas;
	}

	public static void guardarTareas() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		Tarea tarea = new Tarea(null,null);
		File f = gestionFicheros.elegirFichero();
		System.out.println("Tarea a a�adir: ");
		tarea.setTitulo(sc.nextLine());

		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);

			bw.write(tarea.getTitulo() + "\n");

			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		Menu.mostrarMenu();
	}

	public static void listarTareas() {
		FileInputStream input = null;
		Tarea tarea = new Tarea(null,null);
		File f = gestionFicheros.elegirFichero();
		try {
			String tareaLeida = "";
			input = new FileInputStream(f);
			InputStreamReader lectura = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(lectura);

			tareaLeida = br.readLine();
			System.out.println("Tareas de: " + f.getName());
			while (tareaLeida != null) {
				tarea.setTitulo(tareaLeida);
				System.out.println(tarea.getTitulo());
				tareaLeida = br.readLine();
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Menu.mostrarMenu();
	}

	public static void borrarTareas() {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = null;
		FileWriter fw = null;
		File f = gestionFicheros.elegirFichero();
		ArrayList<Tarea> listaTareas = cargarTareas(f);

		System.out.println("Elija que tarea desea borrar: ");
		int opcion = sc.nextInt();
		listaTareas.remove(opcion - 1);
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (int cont = 0; cont < listaTareas.size(); cont++) {
				bw.write(listaTareas.get(cont).getTitulo() + "\n");
			}

			bw.close();

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu.mostrarMenu();
	}
}
