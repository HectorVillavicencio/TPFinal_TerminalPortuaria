import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaCompuesta;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaCompuestaAnd;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaCompuestaOr;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaDeRutas;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.FiltraFechaSalida;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.FiltroFechaLlegada;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.FiltroPuertoDestino;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Naviera;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Tramo;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

class BusquedaTestCase {
	
	
	BusquedaDeRutas nombreDestino1;

	
	BusquedaDeRutas fechaSalida1;
	BusquedaDeRutas fechaSalida2;
	
	
	BusquedaDeRutas fechaLlegada1;
	BusquedaDeRutas fechaLlegada2;
	BusquedaDeRutas fechaLlegada3;
	
	BusquedaCompuesta compuestaAnd;
	BusquedaCompuesta compuestaOr;
	
	
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
		viajes.add(viaje2);
		viajes.add(viaje3); 
		
		
		nombreDestino1 =new FiltroPuertoDestino(terminal4);
		fechaSalida1 = new FiltraFechaSalida(LocalDateTime.of(2023, Month.NOVEMBER, 1, 1, 0));	
		fechaLlegada3= new FiltroFechaLlegada(LocalDateTime.of(2023, Month.NOVEMBER, 1, 3, 0));
		
		compuestaAnd= new BusquedaCompuestaAnd();
		compuestaOr= new BusquedaCompuestaOr();
		
	}
	@Test
	void testBusquedaPorDestino1() {
		ArrayList<Viaje> listaFiltrada = nombreDestino1.buscar(viajes);
		assertEquals(listaFiltrada.size(),1);  
	}
	
	 @Test
	void testBusquedaPorFechaSalida1() {
		ArrayList<Viaje> listaFiltrada = fechaSalida1.buscar(viajes);
		assertEquals(listaFiltrada.size(),1); 
	} 
	 
	 @Test
	 void testBusquedaPorFechaLlegada1() {
		ArrayList<Viaje> listaFiltrada = fechaLlegada3.buscar(viajes);
		assertEquals(listaFiltrada.size(),0);  
	} 
	 
	 @Test
	 void testBusquedaCompuestaAnd1() {
		 compuestaAnd.addBusqueda(nombreDestino1);
		 compuestaAnd.addBusqueda(fechaSalida1);
		 
		 ArrayList<Viaje> listaFiltrada =  compuestaAnd.buscar(viajes);
		 
		 assertEquals(listaFiltrada.size(),0);
		 
	 }
	 
	 @Test
	 void testBusquedaCompuestaOr1() {
		 compuestaOr.addBusqueda(nombreDestino1);
		 compuestaOr.addBusqueda(fechaSalida1);
		 compuestaOr.addBusqueda(fechaSalida2);
		 compuestaOr.removeBusqueda(fechaSalida2);
		 
		 
		 ArrayList<Viaje> listaFiltrada =  compuestaOr.buscar(viajes);
		 
		 assertEquals(listaFiltrada.size(),2);
		 
	 }
	 
	 
	

}
