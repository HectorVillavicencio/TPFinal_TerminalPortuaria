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
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalGestionada;
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
	TerminalGestionada terminal1;
	TerminalGestionada terminal2;
	TerminalGestionada terminal3;
	TerminalGestionada terminal4;
	TerminalGestionada terminal5;
	TerminalGestionada terminal6;
	TerminalGestionada terminal7;
	TerminalGestionada terminal8;
	Viaje viaje1;
	Viaje viaje2;
	
	TerminalGestionada terminal;
	
	@BeforeEach
	void SetUp() throws Exception {
		naviera = new Naviera();
		
		
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		
		terminal1 = new TerminalGestionada();
		terminal2 = mock(TerminalGestionada.class);
		terminal3 =  new TerminalGestionada();
		terminal4 = mock(TerminalGestionada.class);
		terminal5 = mock(TerminalGestionada.class);
		terminal6 = mock(TerminalGestionada.class);
		terminal7 = mock(TerminalGestionada.class);
		terminal8 = mock(TerminalGestionada.class);
		
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
		
		terminal = new TerminalGestionada();
		
		
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
	
	@Test
	void testagregarViajeTerminalG() {
		terminal.agregarViaje(viaje1);
		assertEquals(terminal.getCronograma().size(),1);
	}
	
	@Test
	void precioEntreTerminales1() {
		assertEquals(circuito3.precioEntre(terminal1, terminal4),19);
	}
	
	@Test
	void precioEntreTerminales2() {
		assertEquals(circuito3.precioEntre(terminal1, terminal2),10);
	}
	
	@Test
	void precioEntreTramos1() {
		assertEquals(viaje1.precioViajeEntre(terminal1, terminal2), 10);
	}
	
	@Test
	void precioEntreTramos2() {
		assertEquals(viaje1.precioViajeEntre(terminal1, terminal4), 19);
	}
	
	@Test
	void enviarViajeATerminales() {
		naviera.enviarViajeATerminales(viaje1);
		assertEquals(terminal1.getCronograma().size(), 2);
		
	}
	
	
	

}