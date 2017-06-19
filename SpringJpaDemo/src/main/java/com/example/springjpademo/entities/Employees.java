package com.example.springjpademo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Adi Adari on 12/29/2016.
 */

@Entity
@Table(name = "employees")
public class Employees {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="employee_id", unique=true,nullable=false)
    private Integer employeeId;

    @Column(name="first_name", nullable=false)
    private String firstName;
    @Column(name="last_name", nullable=false)
    private String lastName;
    @Column(name="email", nullable=false)
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="hire_date", nullable=false)
    private Date hireDate;
    @Column(name="job_id", nullable=false)
    private String jobId;
    @Column(name="salary")
    private float salary;
    @Column(name="manager_id")
    private Integer managerId;
    @Column(name="department_id")
    private Integer deptId;
    
      @ManyToOne
      @JoinColumn(name="employee_id")
      private Department department;

    public Employees() {}

    public Employees(String name, Department department) {
        this.firstName = name;
       // this.department = department;
    }

    public Employees(String name) {
        this.firstName = name;
    }

    //Setters and Getters
    public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
    
    @Override
    public String toString() {
        return "EmployeeVO [id=" + employeeId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department=" + "]";
    }
}