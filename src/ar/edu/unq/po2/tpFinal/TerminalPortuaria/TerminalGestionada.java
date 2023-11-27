package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Criterio.Criterio;
import Criterio.MenorPrecio;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.EmpresaDeTransporte;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.BusquedaRutas.BusquedaDeRutas;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Consignee;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;

public class TerminalGestionada implements TerminalPortuaria{
	
	private ArrayList<Viaje> cronograma;
	private ArrayList<Container> conteiners;
	private ArrayList<EmpresaDeTransporte> empresasDeTrasnporte;
	private Criterio criterio;
	private List<OrdenDeExportacion> ordenesDeExportacion;
	private List<OrdenDeImportacion> ordenesDeImportacion;
	
	public TerminalGestionada() {
		this.cronograma = new ArrayList<Viaje>();
		this.conteiners = new ArrayList<Container>();
		this.empresasDeTrasnporte = new ArrayList<EmpresaDeTransporte>();	
		this.criterio = new MenorPrecio();
		this.ordenesDeExportacion = new ArrayList<OrdenDeExportacion>();
		this.ordenesDeImportacion = new ArrayList<OrdenDeImportacion>();
	}
	
	

	public void avisarLlegadaAImportadores(Buque buque) {
		
	}
	
	public void avisarSalidaAExportadores(Buque buque) {
		
	}
	
	public void exportar(Shipper shipper,Container container, Camion camion, Chofer chofer, Viaje viaje, int horasParaTurno) {
		this.ordenesDeExportacion.add(new OrdenDeExportacion(shipper,container,camion,chofer,viaje,horasParaTurno));
	}
	
	public void importar(Consignee consignee,Container container, Camion camion, Chofer chofer, LocalDateTime fechaLlegada) {
		this.ordenesDeImportacion.add(new OrdenDeImportacion(consignee,container,camion,chofer,fechaLlegada));
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
