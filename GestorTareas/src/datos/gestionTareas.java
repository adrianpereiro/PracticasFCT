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

public class gestionTareas {

	public static void crearTareas() {
		BufferedWriter wr = null;
		FileWriter fw = null;
		String texto = "";
		ArrayList<String> tareas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		File f = gestionFicheros.crearFichero();
		System.out.println("Tareas a añadir: ");
		texto = sc.nextLine();

		while (true) {
			tareas.add(texto);
			System.out.println("Siguiente tarea, si no hay mas que añadir introducir salir: ");
			texto = sc.nextLine();
			if (texto.equals("salir")) {
				break;
			}
		}

		try {
			fw = new FileWriter(f, true);
			wr = new BufferedWriter(fw);

			for (int i = 0; i < tareas.size(); i++) {
				wr.write("-" + tareas.get(i) + "\n");
			}

			wr.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
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
				Tarea tarea = new Tarea(tareaLeida);
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
		Tarea tarea = new Tarea("");
		File f = gestionFicheros.elegirFichero();
		System.out.println("Tarea a añadir: ");
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
	}

	public static void listarTareas() {
		FileInputStream input = null;
		Tarea tarea = new Tarea("");
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
				System.out.println("-" + tarea.getTitulo());
				tareaLeida = br.readLine();
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		sc.close();
	}
}
