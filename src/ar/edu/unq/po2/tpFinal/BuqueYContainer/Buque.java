package ar.edu.unq.po2.tpFinal.BuqueYContainer;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.*;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalGestionada;

public class Buque {
	
	private List<Container> containers;
	private GPS gps;
	private FaseDeBuque fase;
	private TerminalGestionada terminal;
	
	public Buque(GPS gps) {
		this.gps = gps;
		this.containers = new ArrayList<Container>();
		this.fase = new Outbound(this);
	}
	
	public FaseDeBuque getFase() {
		return fase;
	}
	
	public void setTerminal(TerminalGestionada terminal) {
		this.terminal = terminal;
	}
	
	public void agregarCarga(Container container) {
		this.containers.add(container);
	}
	
	public void eliminarCarga(Container container) {
		this.containers.remove(container);
	}
	
	public List<Container> getCarga(){
		return this.containers;
	}
	
	public int distanciaDeTerminal() {
		return this.gps.distanciaDeTerminal(this.terminal);
	}
	
	public void chequearPosicion() {
		this.fase.chequearPosicion(this.distanciaDeTerminal());
	}
	
	public void cambiarFase() {
		this.fase.siguienteFase();
	}
	
	public void setFase(FaseDeBuque nuevaFase) {
		this.fase = nuevaFase;
	}

	public void avisoDeArribo() {
		// TODO Auto-generated method stub
		this.terminal.avisarLlegadaAImportadores(this);
	}

	public void avisoDePartida() {
		// TODO Auto-generated method stub
		this.terminal.avisarSalidaAExportadores(this);
	}	
	
	//para pasar a Working y Departing
	public void serAutorizado() {
		this.cambiarFase();
	}

}
