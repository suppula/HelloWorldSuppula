package com.wells.suj.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import difflib.DiffRow;
import difflib.DiffRowGenerator;

public class CompareJson {
	
	public static void main(String arg[]) {
		try {
		
		
		ObjectMapper mapper = new ObjectMapper();
		//File jsonFile1 = new File("C:\\one.json");
		//File jsonFile2 = new File("C:\\two.json");
		
		//build simple lists of the lines of the two testfiles
				List<String> original = Files.readAllLines(new File("C:\\one.json").toPath());
				List<String> revised = Files.readAllLines(new File("C:\\two.json").toPath());
		
			//List<String> list1 = mapper.readValue(jsonFile1, new TypeReference<List<String>>(){});
			//List<String> list2 = mapper.readValue(jsonFile2, new TypeReference<List<String>>(){});
		
		

		
		DiffRowGenerator generator = new DiffRowGenerator.Builder().showInlineDiffs(true).
											ignoreWhiteSpaces(true).columnWidth(100).build();
		List<DiffRow> rows = generator.generateDiffRows(original, revised);
						//generator.generateDiffRows(list1, list2);
		                //Arrays.asList("\"id\": 1,", "\"name\": \"Leanne Graham\"", "\"username\": \"Bret\""),
		                //Arrays.asList("\"id\": 1,", "\"name\": \"sujjii Graham\"", "\"username\": \"Bret\""));
				
		        
//		System.out.println("|original|new|");
//		System.out.println("|--------|---|");
//		for (DiffRow row : rows) {
//		    System.out.println("|" + row.getOldLine() + "|" + row.getNewLine() + "|");
//		}
		
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println("<th>Firstname</th>");
		System.out.println("<th>lastname</th>");
		System.out.println("</tr>");
		for (DiffRow row : rows) {
			System.out.println("<tr>");
		    	System.out.println("<td>" + row.getOldLine() + "</td>");
		    	System.out.println("<td>" + row.getNewLine() + "</td>");
		    System.out.println("</tr>");
		}
		System.out.println("</table>");
		
		
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

}
