package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import dao.CuotaDao;
import entidades.Cuota;
import entidades.Prestamo;

public class CuotaDaoImpl implements CuotaDao {

    @Override
    public ArrayList<Cuota> listarCuotas() {
        String query = "SELECT idCuota, idPrestamo, numCuota, montoAPagar, fechaPago, estado FROM cuotas";
        ArrayList<Cuota> listaCuotas = new ArrayList<>();

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cuota cuota = new Cuota();
                cuota.setIdCuota(resultSet.getInt("idCuota"));
                //int idPrestamo = resultSet.getInt("idPrestamo");
//                Prestamo prestamo = aux.prestamoXId(idPrestamo);
//                cuota.setPrestamo(prestamo);
                
                cuota.setNumCuota(resultSet.getInt("numCuota"));
                cuota.setMontoAPagar(resultSet.getBigDecimal("montoAPagar"));
                cuota.setFechaPago(resultSet.getDate("fechaPago"));
                cuota.setEstado(resultSet.getBoolean("estado"));

                listaCuotas.add(cuota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCuotas;
    }

    @Override
    public boolean agregarCuota(Cuota cuota, int idPrestamo) {
        String query = "INSERT INTO cuotas(idPrestamo, numCuota, montoAPagar, fechaPago, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, idPrestamo);
            statement.setInt(2, cuota.getNumCuota());
            statement.setBigDecimal(3, cuota.getMontoAPagar());
            statement.setDate(4, (java.sql.Date) new Date(cuota.getFechaPago().getTime()));
            statement.setBoolean(5, cuota.isEstado());

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean bajarCuota(int idCuota) {
        String query = "UPDATE cuotas SET estado = false WHERE idCuota = ?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, idCuota);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cuota obtenerCuotaPorId(int idCuota) {
        String query = "SELECT idCuota, idPrestamo, numCuota, montoAPagar, fechaPago, estado FROM cuotas WHERE idCuota = ?";
        Cuota cuota = null;
        PrestamoDaoImpl aux = new PrestamoDaoImpl();

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, idCuota);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cuota = new Cuota();
                    cuota.setIdCuota(resultSet.getInt("idCuota"));

                    cuota.setNumCuota(resultSet.getInt("numCuota"));
                    cuota.setMontoAPagar(resultSet.getBigDecimal("montoAPagar"));
                    cuota.setFechaPago(resultSet.getDate("fechaPago"));
                    cuota.setEstado(resultSet.getBoolean("estado"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuota;
    }

	@Override
	public boolean registrarPago(int idCuota) {
		String query = "UPDATE cuotas SET estadoPago = true WHERE idCuota= ?";
		try (Connection conexion = Conexion.getConnection();
				PreparedStatement statement = conexion.prepareStatement(query)) {

			statement.setInt(2, idCuota);

			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
