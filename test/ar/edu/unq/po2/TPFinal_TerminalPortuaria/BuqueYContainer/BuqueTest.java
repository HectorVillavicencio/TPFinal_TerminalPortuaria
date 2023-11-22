package ar.edu.unq.po2.TPFinal_TerminalPortuaria.BuqueYContainer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.*;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalGestionada;

class BuqueTest {

	private TerminalGestionada terminal;
	private Buque buque;
	private GPS gps;
	private Container container1;
	private Container container2;
	private Container container3;
	private Container container4;
	
	@BeforeEach
	void SetUp() throws Exception{
		container1 = mock(Container.class);
		container2 = mock(Container.class);
		container3 = mock(Container.class);
		container4 = mock(Container.class);
		terminal = mock(TerminalGestionada.class);
		gps = mock(GPS.class);
		buque = new Buque(gps);
		buque.setTerminal(terminal);
	}
	
	@Test
	void testBuqueNOEstaAMenosDe50KmsEntoncesAvisaATerminal() {
		when(buque.distanciaDeTerminal()).thenReturn(51);
		buque.chequearPosicion();
		verify(terminal, never()).avisarLlegadaAImportadores(buque);
	}
	
	@Test
	void testBuqueEstaAMenosDe50KmsEntoncesAvisaATerminal() {
		when(buque.distanciaDeTerminal()).thenReturn(49);
		buque.chequearPosicion();
		verify(terminal).avisarLlegadaAImportadores(buque);
	}

	@Test
	void testBuqueLlegoALaTerminalYPasaAFaseArrived() {
		buque.setFase(new Inbound(buque));
		when(buque.distanciaDeTerminal()).thenReturn(0);
		buque.chequearPosicion(); 
		assertInstanceOf(Arrived.class, buque.getFase());
	}
	
	@Test
	void testBuqueEstaEnLaTerminaYRecibeAutorizacionParaTrabajar() {
		when(buque.distanciaDeTerminal()).thenReturn(0);
		buque.setFase(new Arrived(buque));
		buque.serAutorizado();
		assertInstanceOf(Working.class, buque.getFase());
	}
	
	@Test
	void testBuqueEstaEnLaTerminaYFinalizaLosTrabajosYRecibeAutorizacionParaPartir() {
		when(buque.distanciaDeTerminal()).thenReturn(0);
		buque.setFase(new Working(buque));
		buque.serAutorizado();
		assertInstanceOf(Departing.class, buque.getFase());
	}
	
	@Test
	void testBuqueEstaAUnKmDeLaTerminalEntoncesAvisaATerminalYVuelveAFaseOutbound() {
		when(buque.distanciaDeTerminal()).thenReturn(1);
		buque.setFase(new Departing(buque));
		buque.chequearPosicion();
		verify(terminal).avisarSalidaAExportadores(buque);
		assertInstanceOf(Outbound.class, buque.getFase());
	}
	
	@Test
	void testAgregarContainers() {
		buque.agregarCarga(container1);
		buque.agregarCarga(container2);
		buque.agregarCarga(container3);
		assertEquals(buque.getCarga().size(),3);
	}
	
	@Test 
	void testAgregarYEliminarContainers(){
		buque.agregarCarga(container1);
		buque.agregarCarga(container2);
		buque.agregarCarga(container3);
		buque.eliminarCarga(container1);
		buque.eliminarCarga(container2);
		buque.agregarCarga(container4);
		assertEquals(buque.getCarga().size(),2);
	}
}
