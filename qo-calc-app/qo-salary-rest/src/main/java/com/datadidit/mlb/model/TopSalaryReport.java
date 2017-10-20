package com.datadidit.mlb.model;

import java.text.NumberFormat;
import java.util.List;

public class TopSalaryReport {
	private StatRep mean;
	
	private StatRep min;
	
	private StatRep maximum;
	
	private Double standardDeviation;
	
	private Integer salaryCount;
	
	List<PlayerSalary> salaries;
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	public StatRep getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = new StatRep(min);
	}

	public StatRep getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = new StatRep(maximum);
	}

	public Double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	public StatRep getMean() {
		return mean;
	}

	public void setMean(Double mean) {
		this.mean = new StatRep(mean);
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
	
	class StatRep {
		private String formatedValue;
		
		private Double value;
		
		public StatRep(){}
		
		public StatRep(Double value){
			this.value = value;
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			this.setFormatedValue(formatter.format(this.value));
		}

		public String getFormatedValue() {
			return formatedValue;
		}

		public void setFormatedValue(String formatedValue) {
			this.formatedValue = formatedValue;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	}
}
