package negocioImpl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;

import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Usuario;
import exceptions.ClienteNegocioException;
import exceptions.CuentaNegocioException;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio {
	
	private CuentaDao cuentaDao;
	
	public CuentaNegocioImpl() {
		this.cuentaDao = new CuentaDaoImpl();
	}
	
	@Override
    public void agregarCuenta(Cuenta cuenta, int idCliente) throws SQLException {
        // se verifica que la cuenta no sea nula y tenga datos mínimos válidos
        if (cuenta == null) {
            throw new CuentaNegocioException("La cuenta no puede ser nula.");
        }
        /*if (cuenta.getCliente() == null || cuenta.getCliente().getIdCliente() <= 0) {
            throw new CuentaNegocioException("El cliente debe ser válido.");
        }*/
        if (cuenta.getTipoCuenta() == null || cuenta.getTipoCuenta().getId() <= 0) {
            throw new CuentaNegocioException("El tipo de cuenta debe ser válido.");
        }
        if (cuenta.getSaldo() < 0) {
            throw new CuentaNegocioException("El saldo no puede ser negativo.");
        }
		try {
	       cuentaDao.agregarCuenta(cuenta, idCliente);
		}
		catch (SQLException e) {
			e.printStackTrace();
			//ClienteSPException exc1 = new ClienteSPException();
			throw e;
		}finally {
			
		}
    }

    @Override
    public ArrayList<Cuenta> listarCuentas() {
    	// Llstar los cuentas activas
    	ArrayList<Cuenta> cuentas = cuentaDao.listarCuentas();
    	
    	if (cuentas == null || cuentas.isEmpty()) {
			System.out.println("No hay cuentas activas.");
			return new ArrayList<>();
		}

		return cuentas;
    }

    @Override
    public boolean modificarCuenta(Cuenta cuenta) throws CuentaNegocioException {
        // Validaciones de datos de la cuenta
        if (cuenta == null || cuenta.getIdCuenta() <= 0) {
            throw new CuentaNegocioException("La cuenta a modificar debe ser válida y tener un ID.");
        }
        /*if (cuenta.getCliente() == null || cuenta.getCliente().getIdCliente() <= 0) {
            throw new CuentaNegocioException("El cliente debe ser válido.");
        }*/
        if (cuenta.getTipoCuenta() == null || cuenta.getTipoCuenta().getId() <= 0) {
            throw new CuentaNegocioException("El tipo de cuenta debe ser válido.");
        }
        if (cuenta.getSaldo() < 0) {
            throw new CuentaNegocioException("El saldo no puede ser negativo.");
        }

        return cuentaDao.modificarCuenta(cuenta);
    }

    @Override
    public boolean bajaCuenta(int idCuenta) throws CuentaNegocioException {
        // validar ID de la cuenta
        if (idCuenta <= 0) {
            throw new CuentaNegocioException("El ID de la cuenta debe ser válido.");
        }
        
        return cuentaDao.bajaCuenta(idCuenta);
    }
    
    @Override
	public long obtenerProximoCBU() throws CuentaNegocioException  {
    	return cuentaDao.obtenerProximoCBU();
    }
    
    @Override
	public long obtenerProximoNumeroCuenta() throws CuentaNegocioException  {
    	return cuentaDao.obtenerProximoNumeroCuenta();
    }
    

    @Override
    public Cuenta obtenerCuentaPorId(int idCuenta) throws CuentaNegocioException {
		
        // validar ID de la cuenta
        if (idCuenta <= 0) {
            throw new CuentaNegocioException("El ID de la cuenta debe ser válido.");
        }
        
        Cuenta cuenta = cuentaDao.obtenerCuentaPorId(idCuenta);
		
        return cuenta;
    }
    
    @Override
    public Cuenta obtenerCuentaPorCbu(long cbu) throws CuentaNegocioException {
		
        // validar ID de la cuenta
        if (cbu <= 0) {
            throw new CuentaNegocioException("El CBU de la cuenta debe ser válido.");
        }
        
        Cuenta cuenta = cuentaDao.obtenerCuentaPorCbu(cbu);
		
        return cuenta;
    }

	@Override
	public ArrayList<Cuenta> obtenerCuentasPorCliente(int idCliente) {
		
        if (idCliente <= 0) {
            throw new CuentaNegocioException("El ID del cliente debe ser valido.");
        }
        
        return cuentaDao.obtenerCuentasPorCliente(idCliente);
	}

	@Override
	public void ejecutarSPTransferencia(long cbuDestino, long cbuOrigen, float monto, String concepto) throws SQLException { 
		System.out.print("qqqqqqqq");
		try {
			System.out.print("qqqq1111");
			cuentaDao.ejecutarSPTransferencia(cbuDestino, cbuOrigen, monto, concepto);
			}
			catch (SQLException e) {
				System.out.print("qqqqq2222");
				e.printStackTrace();
				//ClienteSPException exc1 = new ClienteSPException();
				throw e;
			}finally {
				
			}		
	}
	
	@Override
	public boolean ingresos(int idCuenta, Float montoACargar) {

		return cuentaDao.ingresos(idCuenta, montoACargar);
	}
	
	@Override
	public ArrayList<Cliente> filtrarCuentas(
	    Date fechaInicio, 
	    Date fechaFin, 
	    Float montoMinimo, 
	    Float montoMaximo
	) {
	    return cuentaDao.filtrarCuentas(fechaInicio, fechaFin, montoMinimo, montoMaximo);
	}

	@Override
	public ArrayList<String> reporteMovimientosCuentas(Date fechaInicio, Date fechaFin) {
		ArrayList<String> reporte= cuentaDao.reporteMovimientosCuentas(fechaInicio, fechaFin);
		return reporte;
	}

}
