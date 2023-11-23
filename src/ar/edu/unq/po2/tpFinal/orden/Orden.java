package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Camion;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre.Chofer;

public abstract class Orden {
	protected Container container;
	protected Camion camion;
	protected Chofer chofer;
	protected int diferenciaDeHorasPermitida;
	
	public Orden(Container container, Camion camion, Chofer chofer, int diferenciaDeHorasPermitida) {
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.diferenciaDeHorasPermitida = diferenciaDeHorasPermitida;
	}
	
	protected void diferenciaDeHorasPermitidas(int horas) {
		this.diferenciaDeHorasPermitida = horas;
	}
	
	protected Container getContainer() {
		return this.container;
	}
	
	protected boolean coincideCamion(Camion camion) {
		// TODO Auto-generated method stub
		return this.camion.getId() == camion.getId();
	}

	protected boolean coincideChofer(Chofer chofer) {
		// TODO Auto-generated method stub
		return this.chofer.getId() == chofer.getId();
	}
	
	public abstract LocalDateTime getTurno();
	
	public abstract LocalDateTime getFechaLlegada();
}
