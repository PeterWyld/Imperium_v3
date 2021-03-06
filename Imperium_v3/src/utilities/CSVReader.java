package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * A class that contains some functions for reading CSV (Comma Separated Values) files
 */
public class CSVReader {
	
	/**
	 * A CSV file reader for CSV files that only have integers in them
	 * If the file has a non integer in it the value for that slot is set to zero
	 * @param fileName is the name of the file that is to be read (include extensions)
	 * @return The function returns a 2d int array filled with the values in the file in the form (line, value on line)
	 * If the function fails it returns null
	 */
	public static int[][] intArrCsvReader(String fileName) {
		
		String line = "0,";
		String temp = "0,";
		FileReader file;
		BufferedReader reader;
		String[] lineVals;
		int[][] returnInts = null;
		int numberOfLines = 0;
		
		File csvFile = new File(fileName);
		if(csvFile.exists() == true) { 
			try {
				file = new FileReader(fileName);
				reader = new BufferedReader(file);
				
				temp = reader.readLine(); //used to find the number of elements in a line
				numberOfLines += 1;
				
				while ((line = reader.readLine()) != null){ 
					//finds out how many lines there are in the file
					numberOfLines += 1;
				}
				
				file = new FileReader(fileName);
				reader = new BufferedReader(file); //reseting the reader to the top line
				returnInts = new int[numberOfLines][temp.split(",").length];
				
				for(int i = 0; i <= numberOfLines -1; i++) {
					line = reader.readLine();
					lineVals = line.split(",");
					
					for(int j = 0; j <= lineVals.length-1; j++) {
						try {
							returnInts[i][j] = utilities.Utilities.intParseDefault(lineVals[j], 0);
						} catch (Exception exec) {
							if (exec instanceof IndexOutOfBoundsException) { //will happen if lines are inconsistent length
								returnInts[i][j] = 0;
							}
						}
						
					}
				}
				
	
				file.close();
			} catch (Exception exec) {
				if(exec instanceof FileNotFoundException) {
					exec.printStackTrace();
					JOptionPane.showMessageDialog(null, "File " + fileName + " does not exist", "Error", JOptionPane.INFORMATION_MESSAGE);
					returnInts = null;
				}else if(exec instanceof IOException) {
					exec.printStackTrace();
					returnInts = null;
					JOptionPane.showMessageDialog(null, "Error whilst reading file", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		return returnInts;
	}
	
	/**
	 * A CSV file reader
	 * @param fileName is the name of the file that is to be read (include extensions)
	 * @return The function returns a 2d String array filled with the values in the file in the form (line, value on line)
	 * If the function fails it returns null
	 */
	public static String[][] strArrCsvReader(String fileName) {
		
		
		String line = "0,";
		String temp = "0,";
		FileReader file;
		BufferedReader reader;
		String[] lineVals;
		String[][] returnVals = null;
		int numberOfLines = 0;
		
		File csvFile = new File(fileName);
		if(csvFile.exists() == true) { 
			try {
				file = new FileReader(fileName);
				reader = new BufferedReader(file);
				
				temp = reader.readLine(); //used to find the number of elements in a line
				numberOfLines += 1;
				
				while ((line = reader.readLine()) != null){ 
					//finds out how many lines there are in the file
					numberOfLines += 1;
				}
				
				file = new FileReader(fileName);
				reader = new BufferedReader(file); //reseting the reader to the top line
				returnVals = new String[numberOfLines][temp.split(",").length];
				
				for(int i = 0; i <= numberOfLines -1; i++) {
					line = reader.readLine();
					lineVals = line.split(",");			
					returnVals[i] = lineVals;
				}
				
	
				file.close();
			} catch (Exception exec) {
				if(exec instanceof FileNotFoundException) {
					exec.printStackTrace();
					JOptionPane.showMessageDialog(null, "File " + fileName + " does not exist", "Error", JOptionPane.INFORMATION_MESSAGE);
				}else if(exec instanceof IOException) {
					exec.printStackTrace();
					returnVals = null;
					JOptionPane.showMessageDialog(null, "Error whilst reading file", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		return returnVals;
	}
}