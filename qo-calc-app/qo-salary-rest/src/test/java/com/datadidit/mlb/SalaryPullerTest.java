package com.datadidit.mlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.datadidit.mlb.model.PlayerSalary;
import com.datadidit.mlb.model.TopSalaryReport;

public class SalaryPullerTest {
	@Test
	public void testPullPlayerSalaries() throws IOException{
		String salarySource = "src/test/resources/qo-salaries.html";
		SalaryPuller puller = new SalaryPuller(salarySource);
		
		List<PlayerSalary> salaries = puller.getSalaryInformation(true);
		//Make sure right number of values
		assertEquals(1194, salaries.size());
		
		validateSalaries(salaries);
	}
	
	@Test
	public void testTopSalaryReport() throws IOException{
		String salarySource = "src/test/resources/qo-salaries.html";
		SalaryPuller puller = new SalaryPuller(salarySource, true);
		
		TopSalaryReport tSalary = puller.getTopNSalaryReport(125);
		
		assertNotNull(tSalary.getMaximum());
		assertNotNull(tSalary.getMin());
		assertNotNull(tSalary.getStandardDeviation());
		assertNotNull(tSalary.getMean());
		assertNotNull(tSalary.getSalaries());
		assertEquals(new Integer(125), tSalary.getSalaryCount());
	}
	
	/*
	 * Shouldn't make an internet connection on each build this is just to test
	 * against real URL
	 */
	@Test
	@Ignore("Move to integration test")
	public void testPullSalariesFromURL() throws IOException{
		String salarySource = "https://questionnaire-148920.appspot.com/swe/";
		SalaryPuller puller = new SalaryPuller(salarySource);

		validateSalaries(puller.getSalaryInformation());
	}
	
	private void validateSalaries(List<PlayerSalary> salaries){
		//Make sure all fields filled out for each included player
		for(PlayerSalary salary : salaries){
			assertNotNull(salary.getName());
			assertNotNull(salary.getLongSalary());
			assertNotNull(salary.getSalary());
			
			//Also ensure all salaries start with $
			assertTrue(salary.getSalary().startsWith("$"));
		}
	}
}
