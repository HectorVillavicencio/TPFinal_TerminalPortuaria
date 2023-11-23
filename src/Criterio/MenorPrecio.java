package Criterio;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorPrecio extends Criterio{
	


	public MenorPrecio() {
		
		super();

		
	}

	@Override
	protected boolean condicionBusqueda(Circuito circuito1, Circuito circuito2) {
		return circuito1.costoTotal()>circuito2.costoTotal(); 
	} 
	
}
