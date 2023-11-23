package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class FiltraFechaSalida extends BusquedaDeRutas{
	
	private LocalDateTime fechaSalida;

	public FiltraFechaSalida(LocalDateTime fechaSalida) {
		
		super();
		this.fechaSalida = fechaSalida;
		
	}

	@Override 
	protected boolean condicionBusqueda(Viaje viaje) {
		return viaje.getFechaSalida().equals(fechaSalida);
	}  
 
} 
