package ar.edu.unq.po2.tpFinal.BusquedaRutas;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public abstract class BusquedaCompuesta extends BusquedaDeRutas{
	protected ArrayList<BusquedaDeRutas> listaBusquedas;

	public BusquedaCompuesta() {
		
		this.listaBusquedas = new ArrayList<BusquedaDeRutas>();
		
	}
	 
	@Override
	public ArrayList<Viaje> buscar(ArrayList<Viaje> viajes){
		ArrayList<Viaje> resultado = this.casoBase(viajes);
		for(BusquedaDeRutas busqueda: this.listaBusquedas) {
			resultado = this.formatoBusqueda(resultado,busqueda.buscar(viajes));
		}		
		return resultado;
	}
	
	protected abstract ArrayList<Viaje> casoBase(ArrayList<Viaje> viajes);

	public void addBusqueda(BusquedaDeRutas busqueda) {

		this.listaBusquedas.add(busqueda);
		
	} 
	
	public void removeBusqueda(BusquedaDeRutas busqueda) {
		
		this.listaBusquedas.remove(busqueda);
		
	}
	
	protected abstract ArrayList<Viaje> formatoBusqueda(ArrayList<Viaje> listaUno, ArrayList<Viaje> listaDos);

	protected abstract boolean condicionFormato(ArrayList<Viaje> lista, Viaje elemento);
	
}
