package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehiculo {
	
	private static final Logger log = LogManager.getLogger(SelectVehiculo.class);

	public void listar() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = Conexion.getConnection();

			String sql = "SELECT * FROM vehiculos";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				int kilometraje = rs.getInt("kilometraje");

				System.out.println(
						"Placa: " + placa +
						", Marca: " + marca +
						", Modelo: " + modelo +
						", Año: " + anio +
						", Precio: " + precio +
						", Color: " + color +
						", Disponible: " + disponible +
						", Kilometraje: " + kilometraje
				);
			}

		} catch (Exception e) {

			log.error("Ocurrio un error durante la ejecucion" + e.getMessage());

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}

				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
					log.info("Conexion cerrada");
				}

			} catch (Exception e) {
				log.error("Error al cerrar la conexion" + e.getMessage());
			}
		}
	}

}
