package com.akshay.Springboot.tutorial.repository;

import com.akshay.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//Used for repository testing. Will save data at execution time and will flush the data at execution completion
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        //We implement tests for findbyid
        Department department=Department.builder().departmentName("Mechanical Engineering")
                .departmentCode("ME-011").departmentAddress("Delhi").build();
        //We want to persist these(the above values)
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
           Department department=departmentRepository.findById(1L).get();
           assertEquals(department.getDepartmentName(),"Mechanical Engineering");
    }
}