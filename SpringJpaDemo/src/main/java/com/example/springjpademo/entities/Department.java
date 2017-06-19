package com.example.springjpademo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Adi Adari on 12/29/2016.
 */
@Entity
@Table(name="department")
public class Department implements Serializable 
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="DEPARTMENT_ID", unique=true, nullable = false)
    private Integer deptId;
    @Column(name="dpartment_name", unique=true, nullable = false)
    private String name;
    @Column(name="manager_id", nullable = false)
    private Integer managerId;
    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    public Department()
    {
    }

    public Department(Integer deptId, String name) 
    {
        super();
        this.deptId = deptId;
        this.name = name;
    }

     @OneToMany(mappedBy="department",cascade= CascadeType.ALL)
     private List<Employees> employees = new ArrayList<Employees>();
   

    @Override
    public String toString() {
        return "DepartmentVO [id=" + deptId + ", name=" + name + "]";
    }

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
}