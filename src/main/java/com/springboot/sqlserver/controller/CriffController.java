package com.springboot.sqlserver.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.springboot.sqlserver.entity.Criff;
import com.springboot.sqlserver.service.CriffReportService;

@RestController
@RequestMapping(value = "/api/v1")
public class CriffController {

	@Autowired
	private CriffReportService criffReportService;
	
	@GetMapping(value = "/test")
	@ResponseStatus(HttpStatus.OK)
	public String test() {
		return "woring";
	}

	

	
	@PostMapping(value = "/criffInfo")
	@ResponseStatus(HttpStatus.CREATED)
	public int criffObj(@RequestBody Criff criff) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, GeneralSecurityException, InterruptedException {
		System.out.println("hi" +criff);
		return criffReportService.save(criff);
	}
	
	public void tests() {
		String data = "Sep:2017,000/XXX|Aug:2017,177/XXX|Jul:2017,146/XXX|Jun:2017,115/XXX|May:2017,085/XXX|Apr:2017,054/XXX|Mar:2017,024/XXX|Feb:2017,000/XXX|Jan:2017,060/XXX|Dec:2016,030/XXX|Nov:2016,030/XXX|Oct:2016,000/XXX|Sep:2016,030/XXX|Aug:2016,000/XXX|Jul:2016,XXX/XXX|Jun:2016,XXX/XXX|May:2016,XXX/XXX|Apr:2016,XXX/XXX|Mar:2016,XXX/XXX|Feb:2016,XXX/XXX|Jan:2016,XXX/XXX|Dec:2015,XXX/XXX|Nov:2015,XXX/XXX|Oct:2015,XXX/XXX|Sep:2015,XXX/XXX|Aug:2015,XXX/XXX|";
		String[] arrOfStr = data.split("\\|");
        for (String w : arrOfStr) {  
           String finalString = getSubFinatString(w);
           if(finalString.equalsIgnoreCase("XXX"))
           {
        	   
           }
           System.out.println(finalString);
        }  
	}
	

	private String getSubFinatString(String data) {
		int commaIndex = data.indexOf(",");
        int slashIndex = data.indexOf("/");
        String extractedSubstring = data.substring(commaIndex + 1, slashIndex);
		return extractedSubstring;
	}

	public static void main(String[] args) {
		CriffController e = new CriffController();
		e.test();
	}
}
