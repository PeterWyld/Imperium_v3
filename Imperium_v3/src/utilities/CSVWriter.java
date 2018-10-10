package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that contains some functions for writing to files
 */
public class CSVWriter {
	
	/**
	 * Writes a 2d array to a file using CSV format of separating values by (newlines, commas)
	 * The CSV file output will be incorrectly formatted if the values in the arr contain commas or newlines when put toString()
	 * @param filePath The name (and location) that the file is being written to
	 * @param arr The 2d Array that is being used to make the CSV File
	 * @return The function will return 0 if successful and 1 if it failed
	 */
	public static int WriteCSVFile(String filePath, Object[][] arr) {
		File fileName = new File(filePath);
		
		try {
			FileWriter writer = new FileWriter(fileName);
			StringBuffer line = new StringBuffer();
			for(int i = 0; i <= arr.length -1; i++) {
				for(int j = 0; j <= arr[i].length -1; j++) {
					line.append(arr[i][j]);
					line.append(",");
				}
				line.append("\r\n");
			}
			line.deleteCharAt(line.length()-2);
			line.deleteCharAt(line.length()-1);
			writer.write(line.toString());
			writer.close();
		} catch (IOException exec) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Writes a 2d int array to a file using CSV format of separating values by (newlines, commas)
	 * The CSV file output will be incorrectly formatted if the values in the arr contain commas or newlines when put toString()
	 * @param filePath The name (and location) that the file is being written to
	 * @param arr The 2d Array that is being used to make the CSV File
	 * @return The function will return 0 if successful and 1 if it failed
	 */
	public static int WriteCSVFile(String filePath, int[][] arr) {
		File fileName = new File(filePath);
		
		try {
			FileWriter writer = new FileWriter(fileName);
			StringBuffer line = new StringBuffer();
			for(int i = 0; i <= arr.length -1; i++) {
				for(int j = 0; j <= arr[i].length -1; j++) {
					line.append(arr[i][j]);
					line.append(",");
				}
				line.append("\r\n");
			}
			line.deleteCharAt(line.length()-2);
			line.deleteCharAt(line.length()-1);
			writer.write(line.toString());
			writer.close();
		} catch (IOException exec) {
			return 1;
		}
		return 0;
	}
}