package com.testing.simplegameapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 50, nullable=false)
	@NotBlank(message = "{name.not.blank}")
	private String name;

	@Column(length = 100, nullable = false)
	@Email(message = "{email.not.valid}")
	@NotBlank(message = "{email.not.blank}")
	private String email;
	
	@Column(columnDefinition = "integer NOT NULL default 1")
	@Positive(message = "{level.not.positive}")
	private Integer level = 1;
	
	/**
	 * Constructor
	 */
	public Player() {}
	
	/**
	 * Constructor
	 */
	public Player(String name, String email) {
		
		this.name = name;
		this.email = email;
	}
	
	/**
	 * 
	 * @return Integer id
	 */
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return Integer level
	 */
	public Integer getLevel() {
		return this.level;
	}
	
	/**
	 * 
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
}