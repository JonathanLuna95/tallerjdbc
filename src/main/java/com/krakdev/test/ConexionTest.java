package com.krakdev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class ConexionTest {
	
	private static final Logger log = LogManager.getLogger(ConexionTest.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		
		log.info("Inicia Conexion");
		
		try {
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tallerjdbc","postgres","qM5pw2W");
			
			log.info("Conexion exitosa");
			
		} catch (Exception e) {
			log.error("Error de conexion" + e.getMessage());
		
		
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
