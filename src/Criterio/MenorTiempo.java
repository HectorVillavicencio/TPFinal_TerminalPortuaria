package Criterio;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorTiempo extends Criterio{
	
	private int tiempo;

	public MenorTiempo(int tiempo) {
		
		super();
		this.tiempo = tiempo;
		
	}

	protected boolean condicionBusqueda(Circuito circuito){
		return circuito.tiempoTotal()==(tiempo);
	}

}
