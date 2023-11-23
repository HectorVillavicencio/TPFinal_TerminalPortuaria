package ar.edu.unq.po2.tpFinal.Servicio;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.TipoContainer;




class ServicioTest {
	private Servicio servicioAlmacenamiento;
	private Servicio servicioElectricidad;
	private Lavado servicioLavado;
	private Servicio servicioPesado;
	private Container container1;
	
	
	@BeforeEach
	void SetUp() throws Exception{
		servicioAlmacenamiento= new AlmacenamientoExcedente(2,100);
		servicioElectricidad=new Electricidad(30);
		servicioLavado= new Lavado(100,  50, 70);
		servicioPesado=new Pesado(10);
		container1 = mock(Container.class);
	}

	@Test
	void testServicioAlmacenamientoConDiasExcedentes() {
		assertEquals(servicioAlmacenamiento.costo(container1),200);
	}
	
	@Test
	void testServicioElectricidadConConsumo() {
		when(container1.getTipoContainer()).thenReturn(TipoContainer.Reefer);
		when(container1.getConsumo()).thenReturn(10.0);
		assertEquals(servicioElectricidad.costo(container1),300);
	}
	
	@Test
	void testServicioElectricidadContainerNoReefer() {
		when(container1.getTipoContainer()).thenReturn(TipoContainer.Dry);
		when(container1.getConsumo()).thenReturn(0.0);
		assertEquals(servicioElectricidad.costo(container1),0);
	}
	
	@Test
	void testServicioLavadoExcedente() {
		when(container1.getAltura()).thenReturn(10.0);
		when(container1.getAncho()).thenReturn(10.0);
		when(container1.getLargo()).thenReturn(10.0);
		assertEquals(servicioLavado.totalMetroCubico(container1),1000);
		assertEquals(servicioLavado.costo(container1),100);
	}
	
	@Test
	void testServicioLavado() {
		when(container1.getAltura()).thenReturn(5.0);
		when(container1.getAncho()).thenReturn(5.0);
		when(container1.getLargo()).thenReturn(2.0);
		assertEquals(servicioLavado.costo(container1),50);
	}
	
	@Test
	void testServicioPesado() {
		assertEquals(servicioPesado.costo(container1),10);
	}

}
