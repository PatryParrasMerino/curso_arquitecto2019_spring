package model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the movimientos database table.
 * 
 */

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idMovimiento;

	private double cantidad;

	
	private Date fecha;

	private String operacion;

	private int idCuenta;

	public Movimiento(int idMovimiento, double cantidad, Date fecha, String operacion, int idCuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.idCuenta = idCuenta;
	}

	public Movimiento() {
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

}