package com.datadidit.mlb;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

public class JsoupQOTest {
	@Test
	@Ignore("This was only used for debugging JSoup true algorithm moved to test for SalaryPuller")
	public void test() throws IOException{
		Document doc = Jsoup.parse(FileUtils.readFileToString(new File("src/test/resources/qo-salaries.html")));
		
		//Get Rows from salary table
		Element salaryTable = doc.getElementById("salaries-table");
		Elements tableRows = salaryTable.getElementsByTag("tr");
		
		/*
		 * Iterate over each row
		 */
		for(Element tr : tableRows){
			Elements trData = tr.getElementsByTag("td");
			
			int i=0;
			String playerName;
			Integer salary;
			for(Element td : trData){
				if(i==0){
					playerName = td.text();
				}else if(i==1){
					//TODO: This is for salary
				}
				i++;
			}
		}
	}
	
	@Test
	public void testOzarks(){
		String clean = "$507,500";
		String messy = "$$507,590";
		String reallyMessy = "$$$500,000,000lamsflasmdflsmdfsd";
		
		String[] testString = new String[]{clean, messy, reallyMessy};
		
		String regex = "\\$[0-9,]*[0-9]";
		
		Pattern p = Pattern.compile(regex);
		
		for(String input : testString){
			System.out.println("Input "+input);
			Matcher matcher = p.matcher(input);
			
			while(matcher.find()){
				System.out.println(matcher.group());
			}			
		}
	}
	
	@Test
	public void testURI() throws URISyntaxException{
		String fileURI = "file:///src/test/resources/hello.html";
		String httpURI = "http://foobar.com";
		
		URI uri = new URI(fileURI);
		System.out.println(uri.getScheme());
		System.out.println(uri.getPath());
		
		uri = new URI(httpURI);
		System.out.println(uri.getScheme());
		System.out.println(uri.getHost());
	}
}
