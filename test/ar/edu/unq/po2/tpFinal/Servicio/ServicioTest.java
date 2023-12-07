package ar.edu.unq.po2.tpFinal.Servicio;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.TipoContainer;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.orden.*;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.*;


class ServicioTest {
	private Servicio servicioAlmacenamiento;
	private Servicio servicioElectricidad;
	private Lavado servicioLavado;
	private Servicio servicioPesado;
	private Container container1;
	private OrdenDeExportacion ordenDeExportacion;
	private Shipper shipper;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viaje;
	private int hsAntesDeTurno;
	private TerminalPortuaria terminal;
	private TerminalPortuaria terminal2;
	
	
	@BeforeEach
	void SetUp() throws Exception{
		container1 = mock(Container.class);
		terminal = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		shipper = mock(Shipper.class);
		camion = mock(Camion.class);
		camion2 = mock(Camion.class);
		chofer = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		viaje = mock(Viaje.class);
		hsAntesDeTurno = 2;
		ordenDeExportacion = new OrdenDeExportacion(shipper,container1,camion,chofer,viaje, hsAntesDeTurno,terminal,terminal2);
		servicioAlmacenamiento= new AlmacenamientoExcedente(2,100);
		servicioElectricidad=new Electricidad(30,ordenDeExportacion);
		servicioLavado= new Lavado(100,  50, ordenDeExportacion);
		servicioPesado=new Pesado(10);
	}

	@Test
	void testServicioAlmacenamientoConDiasExcedentes() {
		assertEquals(servicioAlmacenamiento.costo(10),200);
	}
	
	@Test
	void testServicioElectricidadConConsumo() {
		when(ordenDeExportacion.getContainer().getTipoContainer()).thenReturn(TipoContainer.Reefer);
		when(ordenDeExportacion.getContainer().getConsumo()).thenReturn(10.0);
		assertEquals(servicioElectricidad.costo(10),300);
	}
	
	@Test
	void testServicioElectricidadContainerNoReefer() {
		when(container1.getTipoContainer()).thenReturn(TipoContainer.Dry);
		when(container1.getConsumo()).thenReturn(0.0);
		assertEquals(servicioElectricidad.costo(10),0);
	}
	
	@Test
	void testServicioLavadoExcedente() {
		when(container1.getAltura()).thenReturn(10.0);
		when(container1.getAncho()).thenReturn(10.0);
		when(container1.getLargo()).thenReturn(10.0);
		when(ordenDeExportacion.getContainer().getMetrosCubicos()).thenReturn(30.0);
		assertEquals(servicioLavado.costo(10),50);
	}
	
	@Test
	void testServicioLavado() {
		when(container1.getAltura()).thenReturn(5.0);
		when(container1.getAncho()).thenReturn(5.0);
		when(container1.getLargo()).thenReturn(2.0);
		assertEquals(servicioLavado.costo(10),50);
	}
	
	@Test
	void testServicioPesado() {
		assertEquals(servicioPesado.costo(10),10);
	}

}
