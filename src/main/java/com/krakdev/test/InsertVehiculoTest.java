package com.krakdev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;
import com.krakdev.jdbc.InsertVehiculo;

public class InsertVehiculoTest {
	
	private static final Logger log = LogManager.getLogger(ConexionTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehiculo vehiculo = new Vehiculo("PDA-5678", "KIA", "Rio", 2022, 20000.99, "Gris", true, 45000);
		
		InsertVehiculo.insertar(vehiculo);

	}

}
