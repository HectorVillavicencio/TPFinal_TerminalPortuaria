package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
	private ArrayList<Container> containers;
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
		this.containers = new ArrayList<Container>();
		this.empresasDeTrasnporte = new ArrayList<EmpresaDeTransporte>();	
		this.criterio = new MenorPrecio();
		this.ordenesDeExportacion = new ArrayList<OrdenDeExportacion>();
		this.ordenesDeImportacion = new ArrayList<OrdenDeImportacion>();
	}
	
	

	public void avisarLlegadaAImportadores(Buque buque) {
		this.ordenesDeImportacionDeBuque(buque, this.ordenesDeImportacion).stream().forEach(oi -> oi.getConsignee().serAvisado(oi.getFechaLlegada()));;
	}
	
	private List<OrdenDeImportacion> ordenesDeImportacionDeBuque(Buque buque, List<OrdenDeImportacion> lista) {
		// TODO Auto-generated method stub
		return lista.stream().filter(oi -> oi.getViaje().equals(buque.getViaje())).toList();
	}

	public void avisarSalidaAExportadores(Buque buque) {
		this.ordenesDeExportacionDeBuque(buque, this.ordenesDeExportacion).stream().forEach(oe -> oe.getShipper().serAvisado());
	}
	
	private List<OrdenDeExportacion> ordenesDeExportacionDeBuque(Buque buque, List<OrdenDeExportacion> lista) {
		// TODO Auto-generated method stub
		return lista.stream().filter(oi -> oi.getViaje().equals(buque.getViaje())).toList();
	}
	
	public void exportar(Shipper shipper,Container container, Camion camion, Chofer chofer, Viaje viaje, int horasParaTurno,TerminalPortuaria destino) {
		this.ordenesDeExportacion.add(new OrdenDeExportacion(shipper,container,camion,chofer,viaje,horasParaTurno,this,destino));
	}
	
	public void importar(Consignee consignee,Container container, Camion camion, Chofer chofer, LocalDateTime fechaLlegada,Viaje viaje,TerminalPortuaria origen) {
		this.ordenesDeImportacion.add(new OrdenDeImportacion(consignee,container,camion,chofer,fechaLlegada, viaje, origen, this));
	}
	
	public void ingresarCarga(Camion camion,LocalDateTime momentoDeLlegada) {
		Container carga = camion.getCarga();
		OrdenDeExportacion orden =(OrdenDeExportacion) this.ordenDelContainer(carga, this.ordenesDeExportacion);
		if(orden.cumpleRequisitos(camion, momentoDeLlegada)) {
			this.agregarContainer(carga);
			camion.descargar();
		}
	}
	
	public void retirarCarga(Camion camion, Container cargaARetirar, LocalDateTime momentoDeLlegada) {
		
		OrdenDeImportacion orden = (OrdenDeImportacion) this.ordenDelContainer(cargaARetirar, this.ordenesDeImportacion);
		if(orden.cumpleRequisitos(camion)) {
			orden.CalcularDiasExcedidos(momentoDeLlegada);
			this.registrarServicios(cargaARetirar, orden);
			int indice = this.containers.indexOf(cargaARetirar);
			camion.cargar(this.containers.get(indice));
			this.containers.remove(cargaARetirar);
		}
	}
	
	public void agregarViaje(Viaje viaje){
	this.cronograma.add(viaje);
	}
	
	public void agregarContainer(Container container){
		this.containers.add(container); 
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


	public ArrayList<Container> getContainers() {
		return containers;
	}
	public ArrayList<EmpresaDeTransporte> getEmpresasDeTrasnporte() {
		return empresasDeTrasnporte;
	}
	public Criterio getCriterio() {
		return criterio; 
	}
	private Orden ordenDelContainer(Container c, List<? extends Orden> ordenes) {
		return ordenes.stream().filter(o-> o.getContainer() == c).findFirst().get();
	}
	
	public void realizarLavadoDeContainer(Container c, Orden orden) {
		//Creo el servicio lavado con los costos.
		Lavado lavado = new Lavado (this.precioFijoExcede, this.precioFijo, orden);
		//Busco la orden del container.
		//Le agrego este servicio
		orden.agregarServicio(lavado);
	}
	public void setPrecioFijoExcede(int precioFijoExcede) {
		this.precioFijoExcede= precioFijoExcede;
	}
	public void setPrecioFijo(int precioFijo) {
		this.precioFijo= precioFijo;
	}
	
	
	private void registrarServicios(Container c, Orden orden) {
		this.realizarLavadoDeContainer(c, orden);
		this.realizarServicioElectrico(c,orden);
		this.realizarServicioDePesado(c, orden);
		this.realizarServicioDeAlmacenamientoExcedente(c, orden);
	}
	
	private void realizarServicioElectrico(Container c, Orden orden) {
		//Creo el servicio eléctrico
		Electricidad electricidad = new Electricidad(this.costoPorKw, orden);
		//Busco la orden del container.
		//Le agrego este servicio
		orden.agregarServicio(electricidad);
	}
	public void setCostoPorKw(int costoPorKw) {
		this.costoPorKw= costoPorKw;
	}
	
	
	private void realizarServicioDePesado(Container c, Orden orden) {
		//Creo el servicio de pesado
		Pesado pesado = new Pesado(costoDePesado);
		//Busco la orden del container.
		//Le agrego este servicio
		orden.agregarServicio(pesado);
	}
	public void setCostoDePesado(int costoDePesado) {
		this.costoDePesado= costoDePesado;
	}
	
	private void realizarServicioDeAlmacenamientoExcedente(Container c, Orden orden) {
		//Creo el servicio de almacenamiento excedente
		AlmacenamientoExcedente almacenamiento = new AlmacenamientoExcedente(precioPorExcedente,orden.diasExcedidos() );
		//Le agrego este servicio
		orden.agregarServicio(almacenamiento);
	}
	public void setPrecioPorExcedente(int precioPorExcedente) {
		this.precioPorExcedente = precioPorExcedente;
	}
	
	
	
}
