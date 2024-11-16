package entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Cuota {

	private int idCuota;
	private int numCuota;
	private BigDecimal montoAPagar;
	private Date fechaPago;
	private boolean estadoPago;
	
	public Cuota() {
	}
	
	public Cuota(int idCuota, int numCuota, BigDecimal montoAPagar, Date fechaPago, boolean estado) {
		super();
		this.idCuota = idCuota;
		this.numCuota = numCuota;
		this.montoAPagar = montoAPagar;
		this.fechaPago = fechaPago;
		this.estadoPago = estado;
	}
	
	public int getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	
	public int getNumCuota() {
		return numCuota;
	}
	public void setNumCuota(int numCuota) {
		this.numCuota = numCuota;
	}
	public BigDecimal getMontoAPagar() {
		return montoAPagar;
	}
	public void setMontoAPagar(BigDecimal montoAPagar) {
		this.montoAPagar = montoAPagar;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public boolean isEstado() {
		return estadoPago;
	}
	public void setEstado(boolean estado) {
		this.estadoPago = estado;
	}
	
	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", idPrestamo=" + numCuota + ", montoAPagar="
				+ montoAPagar + ", fechaPago=" + fechaPago + ", estado=" + estadoPago + "]";
	}
	
	
	
}
