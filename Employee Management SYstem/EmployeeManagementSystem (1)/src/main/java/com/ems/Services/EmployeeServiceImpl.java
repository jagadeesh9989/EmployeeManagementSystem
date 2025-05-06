package com.ems.Services;

import com.ems.Entity.EmployeeEntity;
import com.ems.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employee) {
        EmployeeEntity existing = repository.findById(id).orElse(null);
        if (existing != null) {
        	existing.setName(employee.getName());
        	existing.setDepartment(employee.getDepartment());
        	existing.setSalary(employee.getSalary());

            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

	@Override
	public EmployeeEntity getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity emp, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
}
