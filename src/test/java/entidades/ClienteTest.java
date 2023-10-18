package entidades;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	
	Cliente clienteTest;
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;
	
	@BeforeEach
	public void setUp() {
		clienteTest = new Cliente();
		cliente1 = new Cliente("Maria", "Paz", "123456789");
		cliente3 = new Cliente("Joge", "Sousa", "987654321");
	}
	
	@Test
	public void instanciaClienteVazioTest() {
		assertNotNull(clienteTest);
	}
	
	@Test
	public void instanciaClienteComAtributosTest() {
		
	    final String expectedNome = "Maria";
	    final String expectedSobreNome = "Paz";
	    final String expectedCpf = "123456789";

	    clienteTest = new Cliente("Maria", "Paz", "123456789");
	    
	    String resultNome = clienteTest.getNome();
	    String resultSobreNome = clienteTest.getSobreNome();
	    String resultCpf = clienteTest.getCpf();

	    assertEquals(expectedNome, resultNome);
	    assertEquals(expectedSobreNome, resultSobreNome);
	    assertEquals(expectedCpf, resultCpf);
	}
	
	@Test
	public void cienteGetSetNomeTest() {
		clienteTest.setNome("Maria");
		
		assertEquals("Maria", clienteTest.getNome());
	}
	
	@Test
	public void cienteGetSetSobreNomeTest() {
		clienteTest.setSobreNome("Paz");
		
		assertEquals("Paz", clienteTest.getSobreNome());
	}

	@Test
	public void cienteGetSetCpfTest() {
		clienteTest.setCpf("123456789");
		
		assertEquals("123456789", clienteTest.getCpf());
	}
	
	@Test
	public void cienteSameObjTest() {
		cliente2 = cliente1;
		
		assertSame("São os mesmos clientes", cliente1, cliente2);

	}
	
	@Test
	public void cienteNotSameObjTest() {
		
		assertNotSame("Não são os mesmos clientes", cliente1, cliente3);
	}
	
}
