package com.datadidit.mlb.model;

public class PlayerSalary {
	private String name; 
	
	private String salary;
	
	private Long longSalary;

	public PlayerSalary(){}
	
	public PlayerSalary(String name, String salary, Long ls){
		this.name = name;
		this.salary = salary;
		this.longSalary = ls;
	}

	public Long getLongSalary() {
		return longSalary;
	}

	public void setLongSalary(Long longSalary) {
		this.longSalary = longSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "PlayerSalary [name=" + name + ", salary=" + salary + ", longSalary=" + longSalary + "]";
	}
}
