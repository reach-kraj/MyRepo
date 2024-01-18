package com.csv.csvcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;


public class CsvFileRead {
	public static void writeDataLineByLine(String filePath) 
	{ 
	    File file = new File(filePath); 
	    try { 
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        String[] header = { "Name", "Class", "Marks" }; 
	        writer.writeNext(header); 
	  
	        String[] data1 = { "Aman", "10", "620" }; 
	        writer.writeNext(data1); 
	        String[] data2 = { "Suraj", "20", "630" }; 
	        writer.writeNext(data2); 
	  
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	}
	public static void main(String[] args) {
		String path="G:\\testCsv.csv";
		CsvFileRead.writeDataLineByLine(path);
	}
}