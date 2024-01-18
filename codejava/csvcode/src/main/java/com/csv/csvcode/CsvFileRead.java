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
	  
	        String[] data1 = { "1", "Pankaj Kumar", "20","India" }; 
	        writer.writeNext(data1); 
	        String[] data2 = { "2", "David dan", "40","USA" }; 
	        writer.writeNext(data2); 
	        String[] data3 = { "3", "Lisa ray", "28","Germany" }; 
	        writer.writeNext(data3); 
	  
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