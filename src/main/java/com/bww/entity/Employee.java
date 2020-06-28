package com.bww.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
    @GeneratedValue
    private Long id;
     
    @Column(name="first_name")
    private String firstName;
     
    @Column(name="last_name")
    private String lastName;
     
    @Column(name="email", nullable=false, length=200)
    private String email;
    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="create_dtm")
//    private Date createDtm = new Date();
//    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="update_dtm")
//    private Date updateDtm = new Date();
}
