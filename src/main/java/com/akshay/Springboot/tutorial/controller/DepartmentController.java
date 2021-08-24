package com.akshay.Springboot.tutorial.controller;

import com.akshay.Springboot.tutorial.entity.Department;
import com.akshay.Springboot.tutorial.error.DepartmentNotFoundException;
import com.akshay.Springboot.tutorial.service.DepartmentService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    //Autowire(attach) the object of spring container to the reference that we created
    private DepartmentService departmentService;

    private final Logger LOGGER=LoggerFactory.logger(DepartmentController.class);

    @PostMapping("/departments")
    //Get JSON and convert that into a Department Object using Request Body
    //Valid annotation is used because we have validated the variable in Department.java
    public Department saveDepartment(@Valid @RequestBody Department department){

        //DepartmentService service=new DepartmentServiceImpl();//Commented coz Autowired is used
        //If you want to log whenever a particular request comes to save department
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    //Pathvariable("id") to map the {id} with the Long departmentId
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
