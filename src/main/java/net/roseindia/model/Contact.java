package net.roseindia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
@SuppressWarnings("serial")
public class Contact implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "is_primary")
	private String isPrimary;
	   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	
}
