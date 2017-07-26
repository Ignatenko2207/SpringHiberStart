package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name = "PASSWORD", unique = false, nullable = false)
	private String password;

	@Column(name = "FIRST_NAME", unique = false, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", unique = false, nullable = false)
	private String lastName;

	@Column(name = "PHONE", unique = true, nullable = true)
	private String phone;

	@Column(name = "ADDRESS", unique = false, nullable = true)
	private String address;
	
	@Column(name = "LAST_ACTION", unique = false, nullable = false)
	private Long lastActrion;
	
}
