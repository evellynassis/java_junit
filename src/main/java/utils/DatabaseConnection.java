package utils;

import entidades.Conta;

public interface DatabaseConnection {

	public void insertSaque(Conta conta);
	
	public void insertConta(Conta conta);

}
