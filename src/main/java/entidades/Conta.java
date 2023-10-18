package entidades;

import java.util.Date;

public class Conta {
	
	private Cliente titular;
	private String conta;
	private String agencia;
	private double saldo;
	private double limite;
	private Date dataAbertura;
	private Date dataEncerramento;
	
	public Conta() {
		
	}
	
	public Conta(Cliente titular, String agencia, String conta, double saldo, double limite,
			Date dataAbertura, Date dataEncerramento) {
		super();
		this.titular = titular;
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		this.limite = limite;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
