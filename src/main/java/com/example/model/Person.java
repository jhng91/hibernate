package com.example.model;
import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@Column(name="Name")
	private String name;
	@Column(name="Height")
	private int height;
	@Column(name="Weight")
	private int weight;
	@Column(name="Gender")
	private char gender;
	
	public Person() {}
	public Person(String name, int height, int weight, char gender) {
		setName(name);
		setHeight(height);
		setWeight(weight);
		setGender(gender);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
