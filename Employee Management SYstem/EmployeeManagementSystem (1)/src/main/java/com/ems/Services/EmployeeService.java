package com.ems.Services;

import com.ems.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity saveEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(int id);
    EmployeeEntity updateEmployee(EmployeeEntity emp, int id);
    void deleteEmployee(int id);
	void deleteEmployee(Long id);
	EmployeeEntity updateEmployee(Long id, EmployeeEntity employee);
	EmployeeEntity getEmployeeById(Long id);
}
