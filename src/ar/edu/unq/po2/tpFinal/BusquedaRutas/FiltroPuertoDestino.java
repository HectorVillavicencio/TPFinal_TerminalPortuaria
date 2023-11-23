package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class FiltroPuertoDestino extends BusquedaDeRutas {

	private TerminalPortuaria destino;

	public FiltroPuertoDestino(TerminalPortuaria destino) {
		
		super();
		this.destino = destino;
		
	}

	@Override
	protected boolean condicionBusqueda(Viaje viaje) {
		return viaje.getCircuito().terminalFinal().equals(destino);
	}
 
} 
