package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public abstract class BusquedaDeRutas {
	
	public ArrayList<Viaje> buscar(ArrayList<Viaje> viajes){
		ArrayList<Viaje> resultado = new ArrayList<Viaje>();
		for (Viaje viaje : viajes) {
			if (this.condicionBusqueda(viaje)) {
				resultado.add(viaje);
			} 
		}
		return resultado;
		
	}
	
	protected abstract boolean condicionBusqueda(Viaje viaje);

}
