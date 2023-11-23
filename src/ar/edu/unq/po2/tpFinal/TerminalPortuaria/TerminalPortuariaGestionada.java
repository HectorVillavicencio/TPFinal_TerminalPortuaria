package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.util.ArrayList;

import Criterio.Criterio;
import Criterio.MenorPrecio;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.EmpresaDeTransporte;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaDeRutas;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class TerminalPortuariaGestionada {
	
	private ArrayList<Viaje> cronograma;
	private ArrayList<Container> conteiners;
	private ArrayList<EmpresaDeTransporte> empresasDeTrasnporte;
	private Criterio criterio;
	
	public TerminalPortuariaGestionada() {
		cronograma = new ArrayList<Viaje>();
		conteiners = new ArrayList<Container>();
		empresasDeTrasnporte = new ArrayList<EmpresaDeTransporte>();	
		criterio = new MenorPrecio();
	}
	
	
	public void agregarViaje(Viaje viaje){
	this.cronograma.add(viaje);
	}
	
	public void agregarContainer(Container container){
	this.conteiners.add(container); 
	}
	
	public void agregarEmpresaDeTransporte(EmpresaDeTransporte empresa ){
		this.empresasDeTrasnporte.add(empresa);
	}
	
	public void elegirCriterio(Criterio criterio) {
		this.criterio= criterio;
	}
	
	public ArrayList<Viaje> buscarRutas(BusquedaDeRutas filtro) {
		return filtro.buscar(cronograma); 
	}
	
	public Circuito mejorCircuito() {
		return criterio.buscar(cronograma);
	}


	public ArrayList<Viaje> getCronograma() {
		return cronograma;
	}


	public ArrayList<Container> getConteiners() {
		return conteiners;
	}


	public ArrayList<EmpresaDeTransporte> getEmpresasDeTrasnporte() {
		return empresasDeTrasnporte;
	}


	public Criterio getCriterio() {
		return criterio; 
	}
	
	
	
}
