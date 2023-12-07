package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.GPS;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Consignee;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;

class TerminalGestionadaTest {
	
	private TerminalGestionada terminalGestionada;
	private Consignee consignee;
	private Shipper shipper;
	private Viaje viaje;
	private Camion camion;
	private Chofer chofer;
	private LocalDateTime fechaLlegada;
	private TerminalPortuaria terminalOrigen;
	private TerminalPortuaria terminalDestino;
	private Container container;
	private Buque buque;
	
	@BeforeEach
	void SetUp() throws Exception{
		terminalGestionada = new TerminalGestionada();
		consignee= mock(Consignee.class);
		shipper = mock(Shipper.class);
		viaje = mock(Viaje.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		fechaLlegada = LocalDateTime.of(2023, 11, 10, 12, 30);
		terminalOrigen = mock(TerminalPortuaria.class);
		terminalDestino = mock(TerminalPortuaria.class);
		container = mock(Container.class);
		buque = mock(Buque.class);
		
	}
	
	@Test
	void testImportarYAvisarLlegadaDeBuque() {
		when(buque.getViaje()).thenReturn(viaje);
		terminalGestionada.importar(consignee, container, camion, chofer, fechaLlegada, viaje, terminalOrigen);
		terminalGestionada.avisarLlegadaAImportadores(buque);
		verify(consignee).serAvisado(fechaLlegada);
	}
	
	@Test
	void testExportarYAvisarSalidaAExportador() {
		when(buque.getViaje()).thenReturn(viaje);
		terminalGestionada.exportar(shipper, container, camion, chofer, viaje, 0, terminalDestino);
		terminalGestionada.avisarSalidaAExportadores(buque);
		verify(shipper).serAvisado();
	}

}
