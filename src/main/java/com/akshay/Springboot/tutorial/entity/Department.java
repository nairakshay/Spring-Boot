package com.akshay.Springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data//Using lombok. It generates the getters, setters, constructors automatically
@NoArgsConstructor//To create a default constructor
@AllArgsConstructor
@Builder//To implement Builder Pattern
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message="Please Add Department Name")
    //@Length(max=5,min=1)
    //@Size(max=10,min=0)
    //@Email
    //@Positive
    //@Negative
    //@PositiveOrZero
    //@NegativeOrZero
    //@Future//Check if the date is a future date
    //@FutureOrPresent
    //@Past//Check if the date is a past date
    //@PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    /*public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }*/
}
