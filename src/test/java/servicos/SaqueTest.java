package servicos;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import entidades.Cliente;
import entidades.Conta;
import utils.APIConnection;
import utils.DatabaseConnection;

public class SaqueTest {
	
	Cliente titularMaria;
	Cliente titularJoao;
	
    String conta;
    String agencia;
    double saldo;
    double expectedlimite;
    
    String data; 
	SimpleDateFormat sdfData;
	Date dataAbertura ;
	
	Date expectedDataAbertura;
	Date expectedDataEncerramento;
	
	APIConnection consultaSPCMock;
	DatabaseConnection insertContaMock;
	
	Saque saqueMaria;
	Saque saqueJoao;
	
	@BeforeEach
	public void setUp() throws ParseException {
		titularMaria = new Cliente("Maria", "Paz", "123456789");
		titularJoao = new Cliente("João", "Luiz", "987654321");
		
	    conta = "1234";
	    agencia = "100";
	    saldo = 1000.00;
	    expectedlimite = 10000.00;
	    
	    data = "10/01/2014"; 
		sdfData = new SimpleDateFormat("dd/MM/yyyy");
	    dataAbertura = sdfData.parse(data);
		
	    expectedDataAbertura = dataAbertura;
	    expectedDataEncerramento = null;
	    
	    saqueMaria = new Saque();
	    saqueJoao = new Saque();
	    
	    consultaSPCMock = Mockito.mock(APIConnection.class);
		insertContaMock = Mockito.mock(DatabaseConnection.class);
	}
	
	@Test
	public void realizaSaqueTest() throws ParseException {
		    
		Conta contaMaria = new Conta(titularMaria, agencia, conta,
				saldo, expectedlimite, expectedDataAbertura, expectedDataEncerramento);

		Mockito.when(consultaSPCMock.consultaSPC(contaMaria.getTitular().getNome())).thenReturn(true);
		
		saqueMaria.setApiConnection(consultaSPCMock);
		
		saqueMaria.setBdConnection(insertContaMock);
		
		//Realiza Saque
		saqueMaria.realizaSaque(contaMaria, 50.00);
		
		Mockito.verify(insertContaMock).insertConta(contaMaria);
		
		assertEquals("O saldo foi atualizado para R$ 950,00!", 950.00, contaMaria.getSaldo(), 0.01);
		
	}

	@Test
	public void realizaSaqueSaldoInsuficienteTest() throws ParseException {
		    
		Conta contaJoao = new Conta(titularJoao, agencia, conta,
				saldo, expectedlimite, expectedDataAbertura, expectedDataEncerramento);

		System.out.print(contaJoao.getTitular().getNome());
		
		Mockito.when(consultaSPCMock.consultaSPC(contaJoao.getTitular().getNome())).thenReturn(false);
		
		saqueJoao.setApiConnection(consultaSPCMock);
		
		saqueJoao.setBdConnection(insertContaMock);
		
		//Realiza Saque
		saqueJoao.realizaSaque(contaJoao, 1500.00);
		
		assertEquals("Não foi realizado o saque. O saldo não foi atualizado!", 1000.00, contaJoao.getSaldo(), 0.01);
		
	}
}
