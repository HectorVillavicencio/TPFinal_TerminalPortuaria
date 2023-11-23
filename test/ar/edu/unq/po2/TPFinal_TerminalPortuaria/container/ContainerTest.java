package ar.edu.unq.po2.TPFinal_TerminalPortuaria.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.BuqueYContainer.Outbound;

class ContainerTest {
	private Container container1;
	
	@BeforeEach
	void SetUp() throws Exception{
		container1= new Container(TipoCerrado.CerradoPrecinto, 10, 10, 10, 100, 0, TipoContainer.Dry);
	}
	

	@Test
	void testContainerTipoDeCerrado() {		
		assertEquals(TipoCerrado.CerradoPrecinto,container1.getTipoCerrado());
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
		assertEquals(TipoContainer.Dry,container1.getTipoContainer()); 
	}


}
