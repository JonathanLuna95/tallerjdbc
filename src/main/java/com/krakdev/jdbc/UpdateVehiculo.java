package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public void actualizar(String placa, double precio, boolean disponible) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Conexion.getConnection();

			String sql = "UPDATE vehiculos SET precio = ?, disponible = ? WHERE placa = ?";

			ps = con.prepareStatement(sql);

			ps.setDouble(1, precio);
			ps.setBoolean(2, disponible);
			ps.setString(3, placa);

			int filas = ps.executeUpdate();

			log.info("Filas actualizadas: " + filas);

		} catch (Exception e) {

			log.error("Ocurrio un error durante la ejecucion" + e.getMessage());

		} finally {

			try {

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
