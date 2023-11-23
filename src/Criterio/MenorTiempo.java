package Criterio;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorTiempo extends Criterio{
	
	

	public MenorTiempo() {
		
		super();
		
		
	}

	protected boolean condicionBusqueda(Circuito circuito1, Circuito circuito2){
		return circuito1.tiempoTotal() > circuito2.tiempoTotal(); 
	}

}
