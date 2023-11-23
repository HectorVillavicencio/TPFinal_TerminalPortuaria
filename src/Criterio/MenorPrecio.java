package Criterio;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorPrecio extends Criterio{
	
	private float costo;

	public MenorPrecio(float costo) {
		
		super();
		this.costo = costo;
		
	}

	@Override
	protected boolean condicionBusqueda(Circuito circuito) {
		return circuito.costoTotal()==(costo);
	} 
	
}
