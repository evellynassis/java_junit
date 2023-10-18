package entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class ContaTest {

	@Test
	public void instanciaContaTest() {
		Conta conta = new Conta();
		assertNotNull(conta);
	}
	
	@Test
	public void instanciaContaComAtributosTest() throws ParseException {
		
		final Cliente expectedTitular = new Cliente();
	    final String expectedConta = "1234";
	    final String expectedAgencia = "100";
	    final double expectedSaldo = 1000.00;
	    final double expectedlimite = 10000.00;
	    
		String data = "10/01/2014"; 
		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura = sdfData.parse(data);
		    
	    final Date expectedDataAbertura = dataAbertura;
	    final Date expectedDataEncerramento = null;
		
		Conta conta = new Conta(expectedTitular,expectedAgencia, expectedConta,
				expectedSaldo, expectedlimite, expectedDataAbertura, expectedDataEncerramento);

		assertEquals(expectedTitular, conta.getTitular());
		assertEquals(expectedConta, conta.getConta());
		assertEquals(expectedAgencia, conta.getAgencia());
		assertEquals(expectedSaldo, conta.getSaldo(), 0.01);
		assertEquals(expectedDataAbertura, conta.getDataAbertura());
		assertEquals(expectedDataEncerramento, conta.getDataEncerramento());
			
	}	

}
