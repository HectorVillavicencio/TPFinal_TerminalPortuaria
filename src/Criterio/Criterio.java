package Criterio;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public abstract class Criterio {
	public Circuito buscar(ArrayList<Viaje> viajes){
		Circuito resultado = viajes.get(0).getCircuito();
		for (Viaje viaje : viajes) {
			if (this.condicionBusqueda(resultado,viaje.getCircuito())) {
				resultado = viaje.getCircuito();
			} 
		}
		return resultado; 
		
	}
	
	protected abstract boolean condicionBusqueda(Circuito circuito1, Circuito circuito2);

}
