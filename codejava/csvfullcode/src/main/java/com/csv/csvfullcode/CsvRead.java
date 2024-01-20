package com.csv.csvfullcode;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class CsvRead {
	public static void readDataLineByLine(String file) 
	{ 
	  
	    try { 
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	  
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String cell : nextRecord) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        }
	        csvReader.close();
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	public static void main(String[] args) {
		String path="c:\\temp\\EmpDetails.csv";
		CsvRead.readDataLineByLine(path);
	}
}
