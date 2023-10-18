package servicos;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import utils.DataUtils;

public class EmprestimoTest {
	
	Emprestimo emprestimo;
	DataUtils dataUtilsMock;
	DataUtils dataUtilsSpy;
	
	@BeforeEach
	public void setUp() throws Exception {
		emprestimo = new Emprestimo();
		dataUtilsMock = Mockito.mock(DataUtils.class);
		dataUtilsSpy = Mockito.spy(DataUtils.class) ;
	}

	/** Teste do método aprovaPagamentoMockTest() utilizando Mock.*/  
	@Test
	public void aprovaPagamentoMockTest() {
		Mockito.when(dataUtilsMock.prazoPagamento(10)).thenReturn(20);
		assertEquals(emprestimo.aprovaPagamento(dataUtilsMock, 1), 0);
	}
	
	/** Teste do método aprovaPagamentoMockTest() utilizando Spy.*/
	@Test
	public void aprovaPagamentoSpyTest() {
		Mockito.when(dataUtilsSpy.prazoPagamento(10)).thenReturn(20);
		assertEquals(emprestimo.aprovaPagamento(dataUtilsSpy, 1), 11);
	}

}