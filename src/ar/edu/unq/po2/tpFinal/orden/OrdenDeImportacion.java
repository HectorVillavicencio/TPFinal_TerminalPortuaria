package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Consignee;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class OrdenDeImportacion extends Orden{
	private Consignee consignee;
	private LocalDateTime fechaLlegada;
	
	public OrdenDeImportacion(Consignee consignee,Container container, Camion camion, Chofer chofer, LocalDateTime fechaLlegada, Viaje viaje,TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino) {
		super(container,camion,chofer, 24, viaje,terminalOrigen,terminalDestino);
		this.fechaLlegada = fechaLlegada;
		this.consignee = consignee;
	}
	
	public boolean cumpleRequisitos(Camion camion) {
		return this.coincideCamion(camion) && this.coincideChofer(camion.getChofer()); 
	}
	
	public Consignee getConsignee() {
		return this.consignee;
	}

	@Override
	public LocalDateTime getFechaLlegada() {
		// TODO Auto-generated method stub
		return this.fechaLlegada;
	}

	@Override
	public LocalDateTime getTurno() {
		// TODO Auto-generated method stub
		return this.fechaLlegada.plusHours(this.diferenciaDeHorasPermitida);
	}
	
	public int diasExcedidos(LocalDateTime fechaDeRetiro) {
		return (int) ChronoUnit.DAYS.between(this.getTurno(), fechaDeRetiro);
	}

	@Override
	public int diasExcedidos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
