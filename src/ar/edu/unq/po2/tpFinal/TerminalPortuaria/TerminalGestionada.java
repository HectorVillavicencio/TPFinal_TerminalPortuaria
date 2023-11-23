package ar.edu.unq.po2.tpFinal.TerminalPortuaria;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Consignee;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;

public class TerminalGestionada extends TerminalPortuaria{
	private List<OrdenDeExportacion> ordenesDeExportacion;
	private List<OrdenDeImportacion> ordenesDeImportacion;

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
}
