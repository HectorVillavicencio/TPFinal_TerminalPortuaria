import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaDeRutas;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Naviera;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Tramo;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

class NavierasYCircuitos {
	
	Naviera naviera;
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	Tramo tramo4;
	Buque buque1;
	Buque buque2;
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;
	TerminalPortuaria terminal3;
	TerminalPortuaria terminal4;
	TerminalPortuaria terminal5;
	TerminalPortuaria terminal6;
	TerminalPortuaria terminal7;
	TerminalPortuaria terminal8;
	Viaje viaje1;
	Viaje viaje2;
	
	@BeforeEach
	void SetUp() throws Exception {
		naviera = new Naviera();
		
		
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		
		terminal1 = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		terminal3 = mock(TerminalPortuaria.class);
		terminal4 = mock(TerminalPortuaria.class);
		terminal5 = mock(TerminalPortuaria.class);
		terminal6 = mock(TerminalPortuaria.class);
		terminal7 = mock(TerminalPortuaria.class);
		terminal8 = mock(TerminalPortuaria.class);
		
		tramo1 = new Tramo(terminal1,terminal2,10,10);
		tramo2 = new Tramo(terminal3,terminal4,9,9);
		tramo3 = new Tramo(terminal5,terminal6,11,11);
		tramo4 = new Tramo(terminal7,terminal8,12,12);
		
		circuito1 = new Circuito(); 
		circuito2 = new Circuito(); 
		circuito3 = new Circuito(); 
		
		circuito3.agregarTramo(tramo1);
		circuito3.agregarTramo(tramo2);
		
		viaje1 = new Viaje(circuito3, buque1,LocalDateTime.of(2023, Month.NOVEMBER, 10, 12, 0));
		
		
	} 
	
	@Test
	void testTerminalInicialTramo() {		
		assertEquals(tramo1.getTerminalInicial(), terminal1); 
	}
	
	@Test
	void testTerminalFinalTramo() {		
		assertEquals(tramo1.getTerminalFinal(), terminal2); 
	}
	
	@Test
	void testtiempoTramo() {		
		assertEquals(tramo1.getTiempo(), 10); 
	}
	
	@Test
	void testTerminalPrecioTramo() {		
		assertEquals(tramo2.getPrecio(), 9); 
	}
	

	@Test
	void testListaDeCircuito() {	
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		assertEquals(circuito1.getTramos().size(), 2); 
	}
	
	@Test
	void testTiempoTotalCircuito() {
		circuito2.agregarTramo(tramo1);
		circuito2.agregarTramo(tramo1);
		assertEquals(circuito2.tiempoTotal(), 20); 
	} 
	
	@Test
	void testCostoTotalCircuito() {
		circuito2.agregarTramo(tramo1);
		assertEquals(circuito2.costoTotal(), 10); 
	} 
	
	@Test
	void testTerminalInicialCircuito() {
		circuito2.agregarTramo(tramo1);
		circuito2.agregarTramo(tramo2);
		assertEquals(circuito2.terminalInicial(), terminal1); 
	} 
	
	@Test
	void testTerminalFinalCircuito() {
		circuito2.agregarTramo(tramo1);
		circuito2.agregarTramo(tramo2);
		circuito2.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo4);
		assertEquals(circuito2.terminalFinal(), terminal8); 
	} 
	
	@Test
	void testBuqueViaje() {
		assertEquals(viaje1.getBuque(), buque1);
	}
	
	@Test
	void testFechaLlegadaViaje() {
		assertEquals(viaje1.fechaLlegada(), LocalDateTime.of(2023, Month.NOVEMBER, 11, 07, 0));
	}
	
	@Test
	void testFechaSalidaViaje() {
		assertEquals(viaje1.getFechaSalida(), LocalDateTime.of(2023, Month.NOVEMBER, 10, 12, 0));
	}
	
	@Test
	void testCircuitoViaje(){
		assertEquals(viaje1.getCircuito(), circuito3);
	}
	
	@Test
	void testNViajeNaviera() {
		naviera.nuevoViaje(buque1, circuito3, LocalDateTime.of(2023, Month.NOVEMBER, 10, 12, 0));
		assertEquals(naviera.getViajes().size(), 1);
	}
	
	@Test
	void testAgregarBuqueNaviera() {
		naviera.agregarBuque(buque1);
		naviera.agregarBuque(buque2);
		assertEquals(naviera.getBuques().size(), 2);
	}
	
	@Test
	void testAgregarCircuitoNaviera() {
		naviera.agregarCircuito(circuito1);
		naviera.agregarCircuito(circuito2);
		naviera.agregarCircuito(circuito3);
		assertEquals(naviera.getCircuitos().size(), 3);
	}
	

	
	

}
