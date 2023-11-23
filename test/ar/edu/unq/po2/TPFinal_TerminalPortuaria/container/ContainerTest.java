package ar.edu.unq.po2.TPFinal_TerminalPortuaria.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainerTest {
	private Container container1;
	private TipoCerrado CerradoPrecinto;
	private TipoContainer Dry;
	
	@BeforeEach
	void SetUp() throws Exception{
		container1= new Container(CerradoPrecinto, 10, 10, 10, 100, 0, Dry);
	}
	

	@Test
	void testContainerTipoDeCerrado() {		
		assertEquals(container1.getTipoCerrado(), CerradoPrecinto); 
	}
	@Test
	void testContainerGetAncho() {		
		assertEquals(container1.getAncho(), 10); 
	}
	
	@Test
	void testContainerGetLargo() {		
		assertEquals(container1.getLargo(), 10); 
	}
	@Test
	void testContainerGetAltura() {		
		assertEquals(container1.getAltura(), 10); 
	}
	

	@Test
	void testContainerGetPeso() {		
		assertEquals(container1.getPeso(), 100); 
	}
	
	@Test
	void testContainerGetConsumo() {		
		assertEquals(container1.getConsumo(), 0); 
	}
	
	@Test
	void testContainerGetTipoContainer() {		
		assertEquals(container1.getTipoContainer(), Dry); 
	}


}
