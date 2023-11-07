package com.spring.mongo.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.mongo.demo.model.Employee;
 

public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<Employee>> employeeSupplier = () ->
            Arrays.asList(
		            Employee.builder().empId(1).firstName("Binay").lastName("Gurung").salary(3000.0f).build(),
		            Employee.builder().empId(2).firstName("Rahul").lastName("Ghadage").salary(4000.0f).build(),
		            Employee.builder().empId(3).firstName("Sunny").lastName("Deol").salary(5000.0f).build(),
		            Employee.builder().empId(4).firstName("Salman").lastName("Khan").salary(6000.0f).build(),
		            Employee.builder().empId(5).firstName("Aamir").lastName("Khan").salary(7000.0f).build(),
		            Employee.builder().empId(6).firstName("Shahrukh").lastName("Khan").salary(8000.0f).build(),
		            Employee.builder().empId(7).firstName("Ranbir").lastName("Kapoor").salary(9000.0f).build(),
		            Employee.builder().empId(8).firstName("Ranveer").lastName("Singh").salary(10000.0f).build(),
		            Employee.builder().empId(9).firstName("Akshay").lastName("Kumar").salary(11000.0f).build(),
		            Employee.builder().empId(10).firstName("Ajay").lastName("Devgan").salary(12000.0f).build()
            );
		
		
		
}

