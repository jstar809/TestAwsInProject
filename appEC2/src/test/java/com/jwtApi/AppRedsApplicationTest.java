package com.jwtApi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppRedsApplicationTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void contextLoad() {
		try (
				Connection con = ds.getConnection() ; 
				PreparedStatement psmt= con.prepareStatement("select now()");
				ResultSet rs = psmt.executeQuery();
				){
			
			rs.next();
			System.out.println(rs.getString(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
