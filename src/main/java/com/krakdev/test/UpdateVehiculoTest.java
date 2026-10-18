package com.krakdev.test;

import com.krakdev.jdbc.UpdateVehiculo;

public class UpdateVehiculoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UpdateVehiculo update = new UpdateVehiculo();

		update.actualizar("PDA-1234", 21500.99, false);
	

	}

}
