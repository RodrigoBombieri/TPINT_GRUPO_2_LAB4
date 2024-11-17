package dao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Cuenta;

public interface CuentaDao {
//	public boolean  agregarCuenta(Cuenta cuenta, int idCliente);
	public void  agregarCuenta(Cuenta cuenta, int idCliente) throws SQLException;	
	public ArrayList<Cuenta> listarCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public boolean bajaCuenta(int idCuenta);
	public Cuenta obtenerCuentaPorId(int idCuenta);
	public long obtenerProximoCBU();	
	public long obtenerProximoNumeroCuenta();	
	public ArrayList<Cuenta> obtenerCuentasPorCliente(int idCliente);
	public boolean ingresos(int idCuenta, BigDecimal montoACargar);
}