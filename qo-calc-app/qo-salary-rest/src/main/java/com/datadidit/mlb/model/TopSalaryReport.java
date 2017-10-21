package com.datadidit.mlb.model;

import java.text.NumberFormat;
import java.util.List;

public class TopSalaryReport {
	private StatRep mean;
	
	private StatRep minimum;
	
	private StatRep maximum;
	
	private StatRep standardDeviation;
	
	private Integer salaryCount;
	
	List<PlayerSalary> salaries;
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	public StatRep getMinimum() {
		return minimum;
	}

	public void setMinimum(Double min) {
		this.minimum = new StatRep(min);
	}

	public StatRep getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = new StatRep(maximum);
	}

	public StatRep getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = new StatRep(standardDeviation);
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
		private String formattedValue;
		
		private Double value;
		
		public StatRep(){}
		
		public StatRep(Double value){
			this.value = value;
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			this.setFormattedValue(formatter.format(this.value));
		}

		public String getFormattedValue() {
			return formattedValue;
		}

		public void setFormattedValue(String formatedValue) {
			this.formattedValue = formatedValue;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	}
}
