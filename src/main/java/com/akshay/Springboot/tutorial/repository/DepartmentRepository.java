package com.akshay.Springboot.tutorial.repository;

import com.akshay.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//To know that it is a repository
//JPaRepository is used because it provides methods that can be used directly for database interaction
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //We declared these methods because there is no in-built method for finding by name in JpaRepository
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
