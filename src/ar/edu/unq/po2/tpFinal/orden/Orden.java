package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;
import ar.edu.unq.po2.tpFinal.Servicio.Servicio;

public abstract class Orden {
	protected Container container;
	protected Camion camion;
	protected Chofer chofer;
	protected int diferenciaDeHorasPermitida;
	protected List<Servicio> servicios;


	
	public Orden(Container container, Camion camion, Chofer chofer, int diferenciaDeHorasPermitida) {
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.servicios = new ArrayList<Servicio>();
		this.diferenciaDeHorasPermitida = diferenciaDeHorasPermitida;
	}
	
	protected void diferenciaDeHorasPermitidas(int horas) {
		this.diferenciaDeHorasPermitida = horas;
	}
	
	public Container getContainer() {
		return this.container; 
	}
	
	protected boolean coincideCamion(Camion camion) {
		// TODO Auto-generated method stub
		return this.camion == camion;
	}

	protected boolean coincideChofer(Chofer chofer) {
		// TODO Auto-generated method stub
		return this.chofer == chofer;
	}
	
	public abstract LocalDateTime getTurno();
	
	public abstract LocalDateTime getFechaLlegada();
	
	public void agregarServicio(Servicio s) {
		servicios.add(s);
	}

	public abstract int diasExcedidos();
	
}
