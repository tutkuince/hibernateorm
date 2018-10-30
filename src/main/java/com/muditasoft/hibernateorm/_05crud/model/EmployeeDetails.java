package com.muditasoft.hibernateorm._05crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author tutku ince
 *
 *         Oct 30, 2018
 */

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 55, nullable = false, unique = true)
	private String email;

	@Column(length = 55, nullable = false, unique = true)
	private String mobilePhone;

	@OneToOne(mappedBy = "employeeDetails", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Employee employee;

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(String email, String mobilePhone) {
		this.email = email;
		this.mobilePhone = mobilePhone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", email=" + email + ", mobilePhone=" + mobilePhone + "]";
	}

}
