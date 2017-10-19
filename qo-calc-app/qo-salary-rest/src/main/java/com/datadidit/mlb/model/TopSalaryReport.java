package com.datadidit.mlb.model;

import java.util.List;

public class TopSalaryReport {
	private Double mean;
	
	private Double min;
	
	private Double maximum;
	
	private Double standardDeviation;
	
	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}

	public Double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	private Integer salaryCount;
	
	List<PlayerSalary> salaries;

	public Double getMean() {
		return mean;
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}
	
	public Integer getSalaryCount() {
		return salaryCount;
	}

	public void setSalaryCount(Integer salaryCount) {
		this.salaryCount = salaryCount;
	}

	public List<PlayerSalary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<PlayerSalary> salaries) {
		this.salaries = salaries;
	}
}
