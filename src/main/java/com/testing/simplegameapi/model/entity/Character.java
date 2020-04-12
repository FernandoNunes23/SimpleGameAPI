package com.testing.simplegameapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private Integer level;
	
	public Character() {}
	
	public Character(String name, Integer level) {
		this.name = name;
		this.level = level;
	}
}
