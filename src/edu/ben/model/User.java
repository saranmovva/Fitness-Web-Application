package edu.ben.model;

import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int age;
	private double height;
	private String gender;
	private ArrayList<Weight> progress;

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		age = 0;
		height = 0.0;
		gender = " ";
		progress = new ArrayList<Weight>();
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Weight> getProgress() {
		return progress;
	}

	public void addWeight(Weight add) {
		progress.add(add);
	}

}
