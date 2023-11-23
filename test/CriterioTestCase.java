import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Criterio.Criterio;
import Criterio.MenorPrecio;
import Criterio.MenorTerminal;
import Criterio.MenorTiempo;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Naviera;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Tramo;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class CriterioTestCase {
	
	Criterio precio;
	Criterio tiempo;
	Criterio terminal;
	
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
	Viaje viaje3;
	
	ArrayList<Viaje> viajes; 
	
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
		
		tramo1 = new Tramo(terminal1,terminal2,1,1);
		tramo2 = new Tramo(terminal3,terminal4,2,2);
		tramo3 = new Tramo(terminal5,terminal6,3,3);
		tramo4 = new Tramo(terminal7,terminal8,4,4);
		
		circuito1 = new Circuito(); 
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		 
		circuito2 = new Circuito(); 
		circuito2.agregarTramo(tramo1);
		circuito2.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo4);
		
		circuito3 = new Circuito(); 		
		circuito3.agregarTramo(tramo1);
		circuito3.agregarTramo(tramo2);
		
		viaje1 = new Viaje(circuito1, buque1,LocalDateTime.of(2023, Month.NOVEMBER, 1, 1, 0));
		viaje2 = new Viaje(circuito2, buque1,LocalDateTime.of(2023, Month.NOVEMBER, 2, 2, 0));
		viaje3 = new Viaje(circuito3, buque1,LocalDateTime.of(2023, Month.NOVEMBER, 3, 3, 0));
		
		viajes = new ArrayList<Viaje>();
		viajes.add(viaje1);
		viajes.add(viaje3); 
		
		tiempo = new MenorTiempo();
		precio = new MenorPrecio();
		terminal = new MenorTerminal();
		
		
	} 
	
	@Test
	void testMejorTiempoDelCriterio() {
		assertEquals(tiempo.buscar(viajes),circuito3); 
	}
	
	@Test
	void testMejorPrecioDelCriterio() {
		assertEquals(precio.buscar(viajes),circuito3); 
	}
	
	@Test
	void testMejorTerminalDelCriterio() {
		assertEquals(terminal.buscar(viajes),circuito3); 
	}
	
	
	

}
