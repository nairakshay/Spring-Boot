package com.akshay.Springboot.tutorial.service;

import com.akshay.Springboot.tutorial.entity.Department;
import com.akshay.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//Spring Boot will know that it is a test class
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean//Coz we are mocking repository
    private DepartmentRepository departmentRepository;

    @BeforeEach//This method will be called for each and every test case added to the below method
    //@BeforeAll//This method will be called before executing test cases in the below method
    //@AfterEach//To clear data that we have created
    //@AfterAll//Same as above
    void setUp() {
            Department department= Department.builder().departmentName("IT").departmentAddress("Mumbai")
                    .departmentCode("IT-06").departmentId(1L).build();//1L is "1" which is of long type
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    //Implementing test case for fetchDepartmentByName
    @Test//It will be used as a test function
    @DisplayName("Get data based on valid department name")
    //@Disabled//To skip the entire test cases' method
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){

        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());//Positive Scenario
        //If you got to DeptServImpl you can see that fetchbyname uses repository. WE will mock this now
    }
}