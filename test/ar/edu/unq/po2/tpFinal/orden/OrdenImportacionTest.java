package ar.edu.unq.po2.tpFinal.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Consignee;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

import org.junit.jupiter.api.BeforeEach;

class OrdenImportacionTest {

	private OrdenDeImportacion ordenDeImportacion;
	private Consignee consignee;
	private Container container;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private LocalDateTime fechaLlegada;
	private TerminalPortuaria terminal;
	private TerminalPortuaria terminal2;
	private Viaje viaje;
	
	@BeforeEach
	void SetUp() throws Exception{
		viaje = mock(Viaje.class);
		terminal = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		consignee = mock(Consignee.class);
		container = mock(Container.class);
		camion = mock(Camion.class);
		camion2 = mock(Camion.class);
		chofer = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		fechaLlegada = LocalDateTime.of(2023, 11, 10, 12, 30);
		ordenDeImportacion = new OrdenDeImportacion(consignee,container,camion,chofer,fechaLlegada,viaje, terminal, terminal2);
	}
	
	@Test
	void testCamionCoincide() {
		//when(camion.getId()).thenReturn(10);
		assertTrue(ordenDeImportacion.coincideCamion(camion));
	}

	@Test
	void testCamionNoCoincide() {
		//when(camion.getId()).thenReturn(10);
		//when(camion2.getId()).thenReturn(11);
		assertFalse(ordenDeImportacion.coincideCamion(camion2));
	}
	
	@Test
	void testChoferCoincide() {
		//when(chofer.getId()).thenReturn(100);
		assertTrue(ordenDeImportacion.coincideChofer(chofer));
	}
	
	@Test
	void testChoferNoCoincide() {
		//when(chofer.getId()).thenReturn(100);
		//when(chofer2.getId()).thenReturn(111);
		assertFalse(ordenDeImportacion.coincideChofer(chofer2));
	}
	
	@Test
	void testPedirContainer() {
		assertEquals(container,ordenDeImportacion.getContainer());
	}
	
	@Test
	void testPedirConsignee() {
		assertEquals(consignee,ordenDeImportacion.getConsignee());
	}
	
	@Test
	void testFechaLlegada() {
		assertEquals(LocalDateTime.of(2023, 11, 10, 12, 30),ordenDeImportacion.getFechaLlegada());
	}
	
	@Test
	void testTurnoTieneFechaLlegadaMas24HsdePermitidoElRetiro() {
		assertEquals(LocalDateTime.of(2023, 11, 11, 12, 30),ordenDeImportacion.getTurno());
	}
	
	@Test
	void testTurnoTieneFechaLlegadaModificandoA48HsElPermitidoElRetiro() {
		ordenDeImportacion.diferenciaDeHorasPermitidas(48);
		assertEquals(LocalDateTime.of(2023, 11, 12, 12, 30),ordenDeImportacion.getTurno());
	}	
	@Test
	void testSeCumpleRequisitosPorqueCoincideCamionYChofer() {
		//when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer);
		//when(chofer.getId()).thenReturn(100);
		assertTrue(ordenDeImportacion.cumpleRequisitos(camion));
	}
	
	@Test
	void testNoSeCumpleRequisitosPorqueCoincideCamionYNoCoincideChofer() {
		//when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer2);
		//when(chofer.getId()).thenReturn(100);
		//when(chofer2.getId()).thenReturn(101);
		assertTrue(ordenDeImportacion.coincideCamion(camion));
		assertFalse(ordenDeImportacion.coincideChofer(chofer2));
		assertFalse(ordenDeImportacion.cumpleRequisitos(camion));
	}
	
	@Test
	void testNoSeCumpleRequisitosPorqueNoCoincideCamionYCoincideChofer() {
		//when(camion.getId()).thenReturn(10);
		//when(camion2.getId()).thenReturn(11);
		when(camion2.getChofer()).thenReturn(chofer);
		//when(chofer.getId()).thenReturn(100);
		assertFalse(ordenDeImportacion.coincideCamion(camion2));
		assertTrue(ordenDeImportacion.coincideChofer(chofer));
		assertFalse(ordenDeImportacion.cumpleRequisitos(camion2));
	}
	
	@Test
	void testCamionTiene2DiasExcedidoEnRetiro() {
		assertEquals(2,ordenDeImportacion.CalcularDiasExcedidos(LocalDateTime.of(2023, 11, 13, 12, 30)));
	}
}
