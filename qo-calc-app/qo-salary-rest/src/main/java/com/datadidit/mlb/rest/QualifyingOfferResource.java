package com.datadidit.mlb.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.datadidit.mlb.SalaryPuller;
import com.datadidit.mlb.model.PlayerSalary;
import com.datadidit.mlb.model.TopSalaryReport;

@Path("qualifyingoffer")
public class QualifyingOfferResource {
	private SalaryPuller puller; 
	
	public QualifyingOfferResource(){
		//TODO: Pull this from web.xml
		//String uri = "https://questionnaire-148920.appspot.com/swe/";
		String uri = "src/test/resources/qo-salaries.html";
		puller = new SalaryPuller(uri, true);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello QO REST Resource";
	}
	
	@Path("allsalaries")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlayerSalary> getSalaries(){
		try {
			return puller.getSalaryInformation(true);
		} catch (IOException e) {
			throw new WebApplicationException("Unable to pull player salaries", 500);
		}
	}
	
	@Path("topsalaries")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TopSalaryReport getTopSalaryReport(@DefaultValue("125") @QueryParam("n") Integer n){
		try {
			return puller.getTopNSalaryReport(n);
		} catch (IOException e) {
			throw new WebApplicationException("Unable to get top salary report", 500);
		}
	}
}
