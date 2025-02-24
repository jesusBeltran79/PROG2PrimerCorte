package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {
	private static Scanner sc; // ve el contenido del archivo
	private static PrintWriter pw; // capacidad de escribir en archivos
	private static File archivo; // capacidad de manejar archivos

	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
//en este caso estos atributos son para la lectura del serializado
	public static FileInputStream fis;
	public static ObjectInputStream ois;

	private static final String FOLDER_NAME = "data";
	private static final String CONFIG_FOLDER_NAME = "config";// van en carpetas separadas para dividir
																// responsabilidades

	/**
	 * Metodo para ver si una carpeta existe
	 */
	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);

		if (archivo.exists() && archivo.isDirectory()) {// verificar si el archivo existe
			return;
		} else {
			archivo.mkdir();// comando para crear carpeta.
		}
		archivo = new File(CONFIG_FOLDER_NAME);

		if (archivo.exists() && archivo.isDirectory()) {// verificar si el archivo existe
			return;
		} else {
			archivo.mkdir();// comando para crear carpeta.
		}

	}

	/**
	 * Metodo para escribir un archivo
	 * 
	 * @param url     nombre del archivo
	 * @param content contenido
	 */
	public static void writeFile(String url, String content) {

		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error al crear el archivo(archivo de texto)");
		}
	}

	/**
	 * Metodo para leer un archivo
	 * 
	 * @param url nombre del archivo
	 * @return contenido
	 */
	public static String readFile(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			} // leer hasta EOF (end of file)
			String contenido = "";
			sc = new Scanner(archivo);
			while (sc.hasNext()) {// funciona para leer cada linea
				contenido += sc.nextLine() + "\n";

			}
			return contenido;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error en la lectura del archivo (archivo de texto)");
		}
		return null;
	}

	/**
	 * Metodo para escribir un serializado
	 * 
	 * @param url     nombre del archivo
	 * @param content contenido
	 */
	public static void writeSerializable(String url, Object content) {

		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error al escribir en el archivo serializado");
		}

	}

	/**
	 * Metodo para leer serizalizable
	 * 
	 * @param url nombre del archivo
	 * @return contenido
	 */
	public static Object readSerializable(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object content = ois.readObject();
			fis.close();
			ois.close();
			return content;
		} catch (IOException e) {// apuntar a una carpeta que no es, no se tiene acceso a esa carpeta
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("");

		} catch (ClassNotFoundException e) {// si se intenta jalar informacion, y llega ese archivo como una clase que
											// no se tiene, no se convierte, un ejemplo es que se lleve un array de
											// persona y que intente convertirlo en mascota
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("");

		}
		return null;
	}

	/**
	 * Metodo para leer archivo de propiedades
	 * 
	 * @param url nombre del archivo
	 * @return contenido
	 */
	public static Properties loadProperties(String url) {
		Properties prop = null;
		prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FOLDER_NAME + "/" + url));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("El archivo de propiedades en la url no existe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error en la lectura del archivo de propiedades " + url);
		}
		return prop;
	}
}
