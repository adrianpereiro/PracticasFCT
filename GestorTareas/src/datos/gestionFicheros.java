package datos;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class gestionFicheros {
	
	public static File crearFichero() {
		String ruta = "";
		File f = null;
		JFileChooser guardar = new JFileChooser("C:\\Users\\i5-10600KF\\Desktop\\Tareas");

		int returnValue = guardar.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			ruta = (guardar.getSelectedFile().getAbsolutePath());
			f = new File(ruta);
			if (f.exists()) {
				JOptionPane.showMessageDialog(null, "No se creo el porque ya existe esa dirección",
						"Error al crear el fichero", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					f.createNewFile();
					JOptionPane.showMessageDialog(null, "Fichero creado correctamente");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return f;
	}

	public static File elegirFichero() {
		String ruta = "";
		File f = null;
		JFileChooser elegir = new JFileChooser("C:\\Users\\i5-10600KF\\Desktop\\Tareas");

		int returnValue = elegir.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			ruta = (elegir.getSelectedFile().getAbsolutePath());
			f = new File(ruta);
		}
		return f;
	}
}
