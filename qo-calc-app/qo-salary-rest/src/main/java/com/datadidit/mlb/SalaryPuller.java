package com.datadidit.mlb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datadidit.mlb.model.PlayerSalary;
import com.datadidit.mlb.model.TopSalaryReport;

/**
 * Utility class for retrieving salary information from a given url
 * 
 * @author mkwyc
 *
 */
public class SalaryPuller {
	Logger logger = LoggerFactory.getLogger(SalaryPuller.class);
	
	private String uri;
	
	private final String REGEX = "(\\$)?[0-9,]*[0-9]";
	
	private Pattern p = Pattern.compile(REGEX);

	private Boolean fileBased = false;
	
	public SalaryPuller(String url) {
		this.uri = url;
	}
	
	public SalaryPuller(String url, Boolean fileBased){
		this.fileBased = fileBased;
		this.uri = url;
	}
	
	public TopSalaryReport getTopNSalaryReport(Integer n) throws IOException{
		List<PlayerSalary> salaries = this.getSalaryInformation();
		Collections.sort(salaries, new Comparator<PlayerSalary>(){

			@Override
			public int compare(PlayerSalary o1, PlayerSalary o2) {
				return o1.getLongSalary().compareTo(o2.getLongSalary());
			}
		});
		
		//Get top salaries
		Collections.reverse(salaries);
		List<PlayerSalary> topSalaries = salaries.subList(0, n);
	
		//Get stats
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(PlayerSalary top : topSalaries){
			stats.addValue(top.getLongSalary().doubleValue());
		}
		
		TopSalaryReport report = new TopSalaryReport();
		report.setMean(stats.getMean());
		report.setMaximum(stats.getMax());
		report.setMinimum(stats.getMin());
		report.setStandardDeviation(stats.getStandardDeviation());
		report.setSalaryCount(n);
		report.setSalaries(topSalaries);
		
		return report;
	}
	
	public List<PlayerSalary> getSalaryInformation() throws IOException {
		return getSalaryInformation(this.fileBased);
	}

	public List<PlayerSalary> getSalaryInformation(Boolean fileBase) throws IOException {
		Document doc;
		List<PlayerSalary> salaries = new ArrayList<>();
		// Pull data
		if (fileBase) {
			// Parse file and make it doc
			doc = Jsoup.parse(FileUtils.readFileToString(new File(uri)));
		} else {
			doc = Jsoup.connect(uri).get();
		}

		// Get Rows from salary table
		Element salaryTable = doc.getElementById("salaries-table");
		Elements tableRows = salaryTable.getElementsByTag("tr");

		/*
		 * Iterate over each row
		 */
		for (Element tr : tableRows) {
			Elements trData = tr.getElementsByTag("td");

			int i = 0;
			String playerName = null, salary = null;
			Long longSalary = null;
			for (Element td : trData) {
				if (i == 0) {
					playerName = td.text();
				} else if (i == 1) {
					// TODO: This is for salary
					salary = this.cleanSalary(td.text());
					if(salary!=null)
						longSalary = this.getLongSalary(salary);
					else
						logger.error("Unable to parse salary from text: "+td.text()+" for player: "+playerName);
				}else{
					logger.error("Unhandled number of data rows "+i+" text is "+td.text());
				}
				i++;
			}
			if(playerName!=null && salary!=null)
				salaries.add(new PlayerSalary(playerName, salary, longSalary));
		}
		
		return salaries;
	}
	
	public String cleanSalary(String input){
		Matcher matcher = p.matcher(input);
		String match = null;
		int matchesFound = 0; 
		while(matcher.find()){
			matchesFound++;
			if(matchesFound==1){
				match = matcher.group();
			}else{
				logger.error("ERROR cleaning currency found another match "+matcher.group());
				break;
			}
		}
		
		//If match doesn't start with $ append
		if(match!=null && !match.startsWith("$"))
			match = "$"+match;
		
		return match;
	}
	
	public Long getLongSalary(String salary){
		//At this point salary has mached regex so should be able 
		//to just replace all 
		return Long.valueOf(salary.replaceAll(",", "").replaceAll("\\$", ""));
	}

	@Override
	public String toString() {
		return "SalaryPuller [uri=" + uri + ", REGEX=" + REGEX + ", p=" + p + ", fileBased=" + fileBased + "]";
	}
}
