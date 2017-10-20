package com.datadidit.mlb.rest;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.datadidit.mlb.SalaryPuller;
import com.datadidit.mlb.model.PlayerSalary;
import com.datadidit.mlb.model.TopSalaryReport;

@Path("qualifyingoffer")
public class QualifyingOfferResource {
	private SalaryPuller puller; 
	
	private String url;
	
	private Boolean fileBased = true;
	
	@Context
	private ServletContext context;
	
	//TODO: Forcing this in there are cleaner ways to do this
	public void init(){
		if(puller==null && context!=null){
			String url = context.getInitParameter("salaryURL");
			String fileBasedValue = context.getInitParameter("fileBased");
			if(fileBasedValue!=null){
				fileBased = Boolean.valueOf(fileBasedValue);
			}
			
			puller = new SalaryPuller(url, fileBased);
			System.out.println(puller);
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		this.init();
		return "Hello QO REST Resource";
	}
	
	@Path("allsalaries")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlayerSalary> getSalaries(){
		this.init();
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
		this.init();
		try {
			return puller.getTopNSalaryReport(n);
		} catch (IOException e) {
			throw new WebApplicationException("Unable to get top salary report", 500);
		}
	}
}
