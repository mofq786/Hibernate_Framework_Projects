package com.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@ToString
//@Getter
//@Setter


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_information")

public class UserInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(nullable=false)
	private String first_name;
	@Column(nullable=false)
	private String last_name;
	@Column(nullable=false)
	private String date_of_birth;
	@Column(nullable=false, length=45,unique=true)
	private String email_id;
	@Column(nullable=false, length=45,unique=true)
	private String password;
	@Column(nullable=false, length=10,unique=true)
	private long mobile_number;
	@Column(nullable=false, length=6,unique=true)
	private int account_number;
	@Column(nullable=false)
	private double amount;
	@Column(nullable=false)
	private String gender;
	
}
