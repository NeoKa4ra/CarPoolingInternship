package Classes.FileManagement;

import java.io.File;
import java.io.FileWriter;

import Classes.Instanciation.Instance;

public class FileCreation {
	private String str;

	public FileCreation(Instance instance, int matrixMode, int wayMode, int rdmRange) {
		FilePath FP = new FilePath(instance.getVertices(), matrixMode, wayMode, rdmRange);
		File f = new File(FP + ".txt");
		str=FP.toString()+".txt";
		int numFichier = 1;
		while (f.exists()) {
			f = new File(FP + " (" + (numFichier++) + ")" + ".txt");
			str=FP.toString()+ " (" + (numFichier++) + ")" + ".txt";
		}
		try {
			// Creation of the file
			f.createNewFile();
			// creation of the writer
			final FileWriter writer = new FileWriter(f);
			try {
				writer.write(instance.getVertices() + "\n" + instance.getCostMatrices() + "\n" + instance.getHours()
						+ "\n" + instance.getDrivers() + "\n" + instance.getPassengers());
			} finally {
				writer.close();
			}
		} catch (Exception e) {
			System.out.println("File creation impossible");
		}
	}

	public String toString() {
		return this.str;
	}
}
