package ar.edu.unq.po2.tpFinal.BuqueYContainer;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.*;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class Buque {
	
	private List<Container> containers;
	private GPS gps;
	private FaseDeBuque fase;
	
	public Buque(GPS gps) {
		this.gps = gps;
		this.containers = new ArrayList<Container>();
		this.fase = new Outbound(this);
	}
	
	public void agregarCarga(Container container) {
		this.containers.add(container);
	}
	
	public void eliminarCarga(Container container) {
		this.containers.remove(container);
	}
	
	public int distanciaDeTerminal(TerminalPortuaria terminal) {
		return this.gps.distanciaDeTerminal(terminal);
	}
	
	public void chequearPosicion(TerminalPortuaria terminal) {
		this.fase.chequearPosicion(this.distanciaDeTerminal(terminal));
	}
	
	public void cambiarFase() {
		this.fase.siguienteFase();
	}
	
	public void setFase(FaseDeBuque nuevaFase) {
		this.fase = nuevaFase;
	}

	public void avisoDeArrivo() {
		// TODO Auto-generated method stub
		//avisar a la terminal que el buque esta llegando
	}
	
	
	//ambas funciones funcionan igual, unificar en una sola
	public void iniciarTrabajoEnTerminal() {
		this.cambiarFase();
	}
	
	public void depart() {
		this.cambiarFase();
	}

	public void avisoDePartida() {
		// TODO Auto-generated method stub
		//avisar a la terminal que el buque ya partio
	}
}
