package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {
	
	@Override
	public ArrayList<Provincia> listarProvincias(){
	    String query = "SELECT idProvincia, provincia FROM provincias";
		ArrayList<Provincia> listaProvincias = new ArrayList<>();	
		
	    try (Connection conexion = Conexion.getConnection();
		         PreparedStatement statement = conexion.prepareStatement(query);
		         ResultSet resultSet = statement.executeQuery()) {

		        while (resultSet.next()) {
		            Provincia provincia = new Provincia();
		            
		            provincia.setId(resultSet.getInt("idProvincia"));
		            provincia.setProvincia(resultSet.getString("provincia"));
		            listaProvincias.add(provincia);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	    
		return listaProvincias;
	}

	@Override
	public Provincia obtenerProvinciaPorId(int id) {
	    String query = "SELECT idProvincia, provincia FROM provincias WHERE idProvincia = ?";
	    Provincia provincia = null;

	    try (Connection conexion = Conexion.getConnection();
	         PreparedStatement statement = conexion.prepareStatement(query)) {

	        // Establecer el parámetro del id
	        statement.setInt(1, id);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                provincia = new Provincia();
	                provincia.setId(resultSet.getInt("idProvincia"));
	                provincia.setProvincia(resultSet.getString("provincia"));
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return provincia;
	}

}
