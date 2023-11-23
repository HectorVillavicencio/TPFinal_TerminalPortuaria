package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class FiltroFechaLlegada extends BusquedaDeRutas{

	private LocalDateTime fechaLlegada;

	public FiltroFechaLlegada(LocalDateTime fechaLlegada) {
		
		super();
		this.fechaLlegada = fechaLlegada;
		
	}

	@Override
	protected boolean condicionBusqueda(Viaje viaje) {
		return viaje.fechaLlegada().equals(fechaLlegada);
	}
}
