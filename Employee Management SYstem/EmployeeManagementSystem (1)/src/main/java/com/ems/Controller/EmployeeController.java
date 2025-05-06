package com.ems.Controller;

import com.ems.Entity.EmployeeEntity;
import com.ems.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
//@CrossOrigin(origins = "http://localhost:5500")
@CrossOrigin(origins = "*") // for testing only
 
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully.";
    }
}
//@RestController
//@RequestMapping("/api/employees")
//@CrossOrigin(origins = "http://localhost:5500") // Allow frontend calls
//public class EmployeeController {
//    
//    @Autowired
//    private EmployeeService service;
//
//    @PostMapping
//    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity emp) {
//        return service.saveEmployee(emp);
//    }
//
//    @GetMapping
//    public List<EmployeeEntity> getAllEmployees() {
//        return service.getAllEmployees();
//    }
//
//    @GetMapping("/{id}")
//    public EmployeeEntity getEmployeeById(@PathVariable int id) {
//        return service.getEmployeeById(id);
//    }
//
//    @PutMapping("/{id}")
//    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity emp, @PathVariable int id) {
//        return service.updateEmployee(emp, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable int id) {
//        service.deleteEmployee(id);
//    }
//}
