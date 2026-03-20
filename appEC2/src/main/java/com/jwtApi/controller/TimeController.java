package com.jwtApi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
public class TimeController {
	
	private static final Logger log =  LoggerFactory.getLogger(TimeController.class); 
	
	private final DataSource dataSource;
	
	public TimeController(DataSource dataSource) {
		 this.dataSource = dataSource;
	}
	
	@GetMapping("/now")
	public ResponseEntity< Map<String ,Object >> getNow(){
		
		String now = "";
		
		try (
				Connection con = dataSource.getConnection() ; 
				PreparedStatement psmt= con.prepareStatement("select now()");
				ResultSet rs = psmt.executeQuery();
				){
			
			rs.next();
			now = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(Map.of("result" , now))  ;
		
	}
	
}
