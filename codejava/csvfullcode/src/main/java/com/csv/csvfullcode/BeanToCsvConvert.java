package com.csv.csvfullcode;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class BeanToCsvConvert {
	private String Name, Age, Company, Salary;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", Age=" + Age + ",Company= " + Company + ",Salary = " + Salary + "]";
	}

	public BeanToCsvConvert(String name, String age, String company, String salary) {
		super();
		Name = name;
		Age = age;
		Company = company;
		Salary = salary;
	}

	public static void main(String[] args) {

		// name of generated csv
		final String CSV_LOCATION = "/Users/Kraj-mac/Work/JavaTestFolder/Employees.csv";
		try {
			// Creating writer class to generate
			// csv file
			FileWriter writer = new FileWriter(CSV_LOCATION);

			// create a list of employee
			List<BeanToCsvConvert> EmployeeList = new ArrayList<BeanToCsvConvert>();

			BeanToCsvConvert emp1 = new BeanToCsvConvert("Mahafujp", "24", "HTc", "75000");
			BeanToCsvConvert emp2 = new BeanToCsvConvert("Aman", "24", "microsoft", "79000");
			BeanToCsvConvert emp3 = new BeanToCsvConvert("Suvradip", "26", "tcs", "39000");
			BeanToCsvConvert emp4 = new BeanToCsvConvert("Riya", "22", "NgGear", "15000");
			BeanToCsvConvert emp5 = new BeanToCsvConvert("Prakash", "29", "Sath", "51000");

			EmployeeList.add(emp1);
			EmployeeList.add(emp2);
			EmployeeList.add(emp3);
			EmployeeList.add(emp4);
			EmployeeList.add(emp5);

			// Create Mapping Strategy to arrange the
			// Column name in order
			ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
			mappingStrategy.setType(BeanToCsvConvert.class);

			// Arrange column name as provided in below array.
			String[] columns = new String[] { "Name", "Age", "Company", "Salary" };
			mappingStrategy.setColumnMapping(columns);

			// Creating StatefulBeanToCsv object
			StatefulBeanToCsvBuilder builder = new StatefulBeanToCsvBuilder(writer);
			StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			// Write list to StatefulBeanToCsv object
			beanWriter.write(EmployeeList);

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
