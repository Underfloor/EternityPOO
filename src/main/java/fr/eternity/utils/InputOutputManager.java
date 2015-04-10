package fr.eternity.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class InputOutputManager {

	private static ObjectOutputStream objectOutputStream;

	public static void writeObject(Object object, String file) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String chooseFile(String currentDirectoryPath) {
		if(!new File(currentDirectoryPath).exists())
        {
            new File(currentDirectoryPath).mkdirs();
        }		
		
		FileFilter fileFilter = new FileFilter(){
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return false;
				} else if (file.getName().endsWith(".ajm")) {
					return true;
				} else {
					return false;
				}
			}
			
			public String getDescription(){
				return "AJM files";
			}
		};
		
		JFileChooser fileChooser = new JFileChooser(currentDirectoryPath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
		fileChooser.setFileFilter(fileFilter);
		
		int returnValue = fileChooser.showSaveDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			
			if (filename == "") {
				return null;
			} else {
				return filename.endsWith(".ajm") ? filename : filename + ".ajm";
			}
		} else {
			return null;
		}
	}
	
}
