package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

	public void eliminar(String placa) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Conexion.getConnection();

			String sql = "DELETE FROM vehiculos WHERE placa = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, placa);

			int filas = ps.executeUpdate();

			log.info("Filas eliminadas: " + filas);

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
