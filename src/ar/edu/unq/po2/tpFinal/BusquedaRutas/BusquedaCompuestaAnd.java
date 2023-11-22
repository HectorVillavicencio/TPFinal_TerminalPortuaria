package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class BusquedaCompuestaAnd extends BusquedaCompuesta {
	
	public BusquedaCompuestaAnd() {
		super();
	}

	@Override
	protected boolean condicionFormato(ArrayList<Viaje> lista, Viaje elemento) {
		return lista.contains(elemento);
	}

	@Override
	protected ArrayList<Viaje> casoBase(ArrayList<Viaje> viajes) {
		return viajes;
	}

	@Override
	protected ArrayList<Viaje> formatoBusqueda(ArrayList<Viaje> listaUno, ArrayList<Viaje> listaDos) {
		ArrayList<Viaje> resultado = new ArrayList<Viaje>();
		for(Viaje viaje:listaDos) {
			if(this.condicionFormato(listaUno,viaje)) {
				resultado.add(viaje);
			}
		}		
		return resultado; 
	}

	@Override
	protected boolean condicionBusqueda(Viaje viaje) {
		// TODO Auto-generated method stub
		return false;
	} 

}
