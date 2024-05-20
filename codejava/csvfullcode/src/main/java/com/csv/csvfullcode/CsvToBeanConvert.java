package com.csv.csvfullcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CsvToBeanConvert {
	private static final long serialVersionUID = 1L;

	public String Name, RollNo, Department, Result, Pointer;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getPointer() {
		return Pointer;
	}

	public void setPointer(String pointer) {
		Pointer = pointer;
	}

	@Override
	public String toString() {
		return "Student [Name=" + Name + ", RollNo=" + RollNo + ",Department= " + Department + ",Result = " + Result
				+ ", Pointer=" + Pointer + "]";
	}

	public static void main(String[] args) {

		// Hashmap to map CSV data to
		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("name", "Name");
		mapping.put("rollno", "RollNo");
		mapping.put("department", "Department");
		mapping.put("result", "Result");
		mapping.put("pointer", "Pointer");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<CsvToBeanConvert> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvToBeanConvert>();
		strategy.setType(CsvToBeanConvert.class);
		strategy.setColumnMapping(mapping);

		// Create csvtobean and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("/Users/Kraj-mac/Work/JavaTestFolder/Student.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<CsvToBeanConvert> list = csvToBean.parse(strategy, csvReader);

		// print details of Bean object
		for (CsvToBeanConvert e : list) {
			System.out.println(e);
		}
	}
}
