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
import ar.edu.unq.po2.tpFinal.Servicio.*;
import ar.edu.unq.po2.tpFinal.orden.*;

public class TerminalGestionada implements TerminalPortuaria{
	
	private ArrayList<Viaje> cronograma;
	private ArrayList<Container> conteiners;
	private ArrayList<EmpresaDeTransporte> empresasDeTrasnporte;
	private Criterio criterio;
	private List<OrdenDeExportacion> ordenesDeExportacion;
	private List<OrdenDeImportacion> ordenesDeImportacion;
	private int precioFijoExcede;
	private int precioFijo;
	private int costoPorKw;
	private int costoDePesado;
	private int precioPorExcedente;
	
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
	
	public void exportar(Shipper shipper,Container container, Camion camion, Chofer chofer, Viaje viaje, int horasParaTurno,TerminalPortuaria origen, TerminalPortuaria destino) {
		this.ordenesDeExportacion.add(new OrdenDeExportacion(shipper,container,camion,chofer,viaje,horasParaTurno,origen,destino));
	}
	
	public void importar(Consignee consignee,Container container, Camion camion, Chofer chofer, LocalDateTime fechaLlegada,Viaje viaje,TerminalPortuaria origen, TerminalPortuaria destino) {
		this.ordenesDeImportacion.add(new OrdenDeImportacion(consignee,container,camion,chofer,fechaLlegada, viaje, origen, destino));
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
	private Orden ordenDelContainer(Container c) {
		return ordenesDeExportacion.stream().filter(o-> o.getContainer() == c).findFirst().get();
	}
	
	public void realizarLavadoDeContainer(Container c) {
		//Creo el servicio lavado con los costos.
		Lavado lavado = new Lavado (this.precioFijoExcede, this.precioFijo, ordenDelContainer(c));
		//Busco la orden del container.
		//Le agrego este servicio
		ordenDelContainer(c).agregarServicio(lavado);
	}
	public void setPrecioFijoExcede(int precioFijoExcede) {
		this.precioFijoExcede= precioFijoExcede;
	}
	public void setPrecioFijo(int precioFijo) {
		this.precioFijo= precioFijo;
	}
	
	
	private void realizarServicioElectrico(Container c) {
		//Creo el servicio eléctrico
		Electricidad electricidad = new Electricidad(this.costoPorKw, ordenDelContainer(c));
		//Busco la orden del container.
		//Le agrego este servicio
		ordenDelContainer(c).agregarServicio(electricidad);
	}
	public void setCostoPorKw(int costoPorKw) {
		this.costoPorKw= costoPorKw;
	}
	
	
	private void realizarServicioDePesado(Container c) {
		//Creo el servicio de pesado
		Pesado pesado = new Pesado(costoDePesado);
		//Busco la orden del container.
		//Le agrego este servicio
		ordenDelContainer(c).agregarServicio(pesado);
	}
	public void setCostoDePesado(int costoDePesado) {
		this.costoDePesado= costoDePesado;
	}
	
	private void realizarServicioDeAlmacenamientoExcedente(Container c) {
		//Creo el servicio de almacenamiento excedente
		AlmacenamientoExcedente almacenamiento = new AlmacenamientoExcedente(precioPorExcedente,ordenDelContainer(c).diasExcedidos() );
		//Le agrego este servicio
		ordenDelContainer(c).agregarServicio(almacenamiento);
	}
	public void setPrecioPorExcedente(int precioPorExcedente) {
		this.precioPorExcedente = precioPorExcedente;
	}
	
	
	
}
