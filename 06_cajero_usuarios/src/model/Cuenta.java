package model;

import java.io.Serializable;


/**
 * The persistent class for the cuentas database table.
 * 
 */

public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int numeroCuenta;

	private double saldo;

	private String tipocuenta;

	
	public Cuenta(int numeroCuenta, double saldo, String tipocuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}

	public Cuenta() {
	}

	public int getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipocuenta() {
		return this.tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
}