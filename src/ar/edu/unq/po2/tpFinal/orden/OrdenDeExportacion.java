package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;
import ar.edu.unq.po2.tpFinal.ShipperYConsignee.Shipper;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class OrdenDeExportacion extends Orden{
	private Shipper shipper;
	private Viaje viaje;
	private int horasAntesParaTurno;
	
	
	public OrdenDeExportacion(Shipper shipper,Container container, Camion camion, Chofer chofer, Viaje viaje, int horasParaTurno, TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino) {
		super(container, camion, chofer, 3,viaje,terminalOrigen,terminalDestino);
		this.viaje = viaje;
		this.shipper = shipper;
		this.horasAntesParaTurno = horasParaTurno;
	}

	@Override
	public LocalDateTime getFechaLlegada() {
		// TODO Auto-generated method stub
		return this.viaje.fechaLlegada();
	}
	
	public LocalDateTime getFechaSalida() {
		return this.viaje.getFechaSalida();
	}
	
	public Shipper getShipper() {
		return this.shipper;
	}
	
	public boolean cumpleRequisitos(Camion camion, LocalDateTime llegadaCamion) {
		return this.coincideCamion(camion) && this.coincideChofer(camion.getChofer()) && !(this.superaTiempoPermitido(llegadaCamion)); 
	}

	private boolean superaTiempoPermitido(LocalDateTime llegadaCamion) {
		// TODO Auto-generated method stub
		long diferencia = ChronoUnit.HOURS.between(this.getTurno(), llegadaCamion);
		return (int)diferencia> this.diferenciaDeHorasPermitida;
	}
	
	public void horasAntesParaTurno(int horas) {
		this.horasAntesParaTurno = horas;
	}
	
	@Override
	public LocalDateTime getTurno() {
		// TODO Auto-generated method stub
		return this.getFechaSalida().minusHours(this.horasAntesParaTurno);
	}

	@Override
	public int diasExcedidos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
