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
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;

import org.junit.jupiter.api.BeforeEach;

class OrdenExportacionTest {
	
	private OrdenDeExportacion ordenDeExportacion;
	private Shipper shipper;
	private Container container;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viaje;
	private int hsAntesDeTurno;
	
	@BeforeEach
	void SetUp() throws Exception{
		shipper = mock(Shipper.class);
		container = mock(Container.class);
		camion = mock(Camion.class);
		camion2 = mock(Camion.class);
		chofer = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		viaje = mock(Viaje.class);
		hsAntesDeTurno = 2;
		ordenDeExportacion = new OrdenDeExportacion(shipper,container,camion,chofer,viaje,hsAntesDeTurno);
	}
	
	@Test
	void testCamionCoincide() {
		when(camion.getId()).thenReturn(10);
		assertTrue(ordenDeExportacion.coincideCamion(camion));
	}
	
	@Test
	void testCamionNoCoincide() {
		when(camion.getId()).thenReturn(10);
		when(camion2.getId()).thenReturn(11);
		assertFalse(ordenDeExportacion.coincideCamion(camion2));
	}
	
	@Test
	void testChoferCoincide() {
		when(chofer.getId()).thenReturn(100);
		assertTrue(ordenDeExportacion.coincideChofer(chofer));
	}
	
	@Test
	void testChoferNoCoincide() {
		when(chofer.getId()).thenReturn(100);
		when(chofer2.getId()).thenReturn(111);
		assertFalse(ordenDeExportacion.coincideChofer(chofer2));
	}

	@Test
	void testPedirContainer() {
		assertEquals(container,ordenDeExportacion.getContainer());
	}
	
	@Test
	void testPedirShipper() {
		assertEquals(shipper,ordenDeExportacion.getShipper());
	}
	
	@Test
	void testFechaLlegada() {
		when(viaje.fechaLlegada()).thenReturn(LocalDateTime.of(2023, 11, 10, 12, 30));
		assertEquals(LocalDateTime.of(2023, 11, 10, 12, 30),ordenDeExportacion.getFechaLlegada());
	}
	
	@Test
	void testFechaSalida() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		assertEquals(LocalDateTime.of(2023, 11, 10, 18, 30),ordenDeExportacion.getFechaSalida());
	}
	
	@Test
	void testTurno() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		assertEquals(LocalDateTime.of(2023, 11, 10, 16, 30),ordenDeExportacion.getTurno());
	}
	
	@Test
	void testTurnoCamiandoHorasAntesParaElTurno() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		ordenDeExportacion.horasAntesParaTurno(4);
		assertEquals(LocalDateTime.of(2023, 11, 10, 14, 30),ordenDeExportacion.getTurno());
	}
	
	@Test
	void testSeCumpleRequisitosPorqueCoincideCamionYChoferYNoSuperaElTiempoPermitido() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer);
		when(chofer.getId()).thenReturn(100);
		assertTrue(ordenDeExportacion.cumpleRequisitos(camion, LocalDateTime.of(2023, 11, 10, 18, 30)));
	}	
	
	@Test
	void testNoSeCumpleRequisitosPorqueCoincideCamionYChoferPeroSuperaElTiempoPermitido() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer);
		when(chofer.getId()).thenReturn(100);
		assertFalse(ordenDeExportacion.cumpleRequisitos(camion, LocalDateTime.of(2023, 11, 10, 20, 30)));
	}	
	
	@Test
	void testNoSeCumpleRequisitosPorqueCoincideCamionYNoSuperaElTiempoPermitidoPeroElChoferNocoincide() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer2);
		when(chofer.getId()).thenReturn(100);
		when(chofer2.getId()).thenReturn(101);
		assertFalse(ordenDeExportacion.cumpleRequisitos(camion, LocalDateTime.of(2023, 11, 10, 18, 30)));
	}
	
	@Test
	void testNoSeCumpleRequisitosPorqueCoincideChoferYNoSuperaElTiempoPermitidoPeroElCamionNocoincide() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		when(camion.getId()).thenReturn(10);
		when(camion2.getId()).thenReturn(11);
		when(camion2.getChofer()).thenReturn(chofer);
		when(chofer.getId()).thenReturn(100);
		assertFalse(ordenDeExportacion.cumpleRequisitos(camion2, LocalDateTime.of(2023, 11, 10, 18, 30)));
	}
	
	@Test
	void testSeCumpleRequisitosLuegoSeModificaDiferenciaPermitidaYNoSeCumplen() {
		when(viaje.getFechaSalida()).thenReturn(LocalDateTime.of(2023, 11, 10, 18, 30));
		when(camion.getId()).thenReturn(10);
		when(camion.getChofer()).thenReturn(chofer);
		when(chofer.getId()).thenReturn(100);
		assertTrue(ordenDeExportacion.cumpleRequisitos(camion, LocalDateTime.of(2023, 11, 10, 18, 30)));
		ordenDeExportacion.diferenciaDeHorasPermitidas(1);
		assertFalse(ordenDeExportacion.cumpleRequisitos(camion, LocalDateTime.of(2023, 11, 10, 18, 30)));
	}	
}
